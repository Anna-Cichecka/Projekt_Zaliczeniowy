package TaskOne;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CreateNewAddressesSteps {

    WebDriver driver;
    NewAddressPage newAddressPage;
    LoginPage loginPage;
    YourAccountPage yourAccountPage;
    YourAddressesPage yourAddressesPage;
    MainShopPage mainShopPage;
    String expectedLoggedUser = "Test Użytkownik";

    @Given("An open CodersLab shop webpage in browser")
    public void anOpenMystoreTestlabCoderslabWebpageInBrowser() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\annac\\Documents\\IT\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://mystore-testlab.coderslab.pl");

    }

    @And("User is on login page")
    public void userIsOnLoginPage() {
        mainShopPage = new MainShopPage(driver);
        mainShopPage.signIn();
    }

    @When("User login")
    public void userLogin() {
        loginPage = new LoginPage(driver);
        loginPage.loginAs("abc@b.pl", "abcb1");
    }

    @Then("User is logged to his account")
    public void userIsLoggedToHisAccount() {
        String currentLoggedUser = loginPage.getLoggedUsername();

        Assert.assertEquals(expectedLoggedUser, currentLoggedUser);

    }

    @When("User go to addresses area")
    public void userGoToCreateAddressesOption() {
        yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.goToNewAddressForm();

    }

    @And("User go to create new addresses option")
    public void userGoToCreateNewAddressesOption() {
        yourAddressesPage = new YourAddressesPage(driver);
        yourAddressesPage.plusCreateNewAddress.click();
    }


    @And("User type data alias {string} address {string} city {string} zip_postalCode {string} country {string} phone {string} to New addresses form")
    public void userTypeDataAliasAddressCityZip_postalCodeCountryPhoneToNewAddressesForm(String alias, String address, String city, String zip_postalCode, String country, String phone) {
        newAddressPage = new NewAddressPage(driver);
        newAddressPage.setAliasInput(alias);
        newAddressPage.setAddressInput(address);
        newAddressPage.setCityInput(city);
        newAddressPage.setZip_postalCodeInput(zip_postalCode);
        newAddressPage.setCountrySelect(country);
        newAddressPage.setPhoneInput(phone);

    }

    @And("User save the form")
    public void userSaveTheForm() {
        newAddressPage.submitForm();
    }


    @Then("Data alias {string} address {string} city {string} zip_postalCode {string} country {string} phone {string}in new address are correct")
    public void dataAliasAddressCityZip_postalCodeCountryPhoneInFormAreCorrect(String alias, String address, String city, String zip_postalCode, String country, String phone) {


        Assert.assertTrue("Alert should be displayed", yourAddressesPage.alertSuccess.isDisplayed());
        Assert.assertEquals("Address successfully added!", yourAddressesPage.alertSuccess.getText());


        Assert.assertEquals(alias, yourAddressesPage.lastAlias.getText());
        Assert.assertEquals(expectedLoggedUser + "\n" + address + "\n" + city + "\n" + zip_postalCode + "\n" + country + "\n" + phone, yourAddressesPage.lastAddress.getText());


    }

    @When("User delete new address")
    public void userDeleteNewAddress() {

        yourAddressesPage.deleteAddress.click();

    }

    @Then("Address is deleted")
    public void addressIsDeleted() {

        Assert.assertTrue("Alert should be displayed", yourAddressesPage.alertSuccess.isDisplayed());
        Assert.assertEquals("Address successfully deleted!", yourAddressesPage.alertSuccess.getText());
        Assert.assertFalse("Element should not be displayed", yourAddressesPage.lastAddressArea.isDisplayed());


    }


    @And("User sign out")
    public void userSignOut() {
             mainShopPage.signOut();
    }

    @And("User close browser")
    public void userCloseBrowser() {
              driver.quit();
    }
}
