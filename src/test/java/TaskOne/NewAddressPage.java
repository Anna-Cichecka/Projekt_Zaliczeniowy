package TaskOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {

    private static WebDriver driver;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "field-alias")
    WebElement aliasInput;

    @FindBy(id = "field-address1")
    WebElement addressInput;

    @FindBy(id = "field-city")
    WebElement cityInput;

    @FindBy(id = "field-postcode")
    WebElement zip_postalCodeInput;

    @FindBy(id = "field-id_country")                      //to jest select , trzeba w n im wybrać option value="17" (United Kingdom) bo inaczej się nie da
    WebElement countrySelect;


    @FindBy(id = "field-phone")
    WebElement phoneInput;

    @FindBy(xpath = "//footer/button[@type='submit']")
    WebElement submitButton;


    public void setAliasInput(String aliasdate){
        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(aliasdate);
    }

    public void setAddressInput(String address){
        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void setCityInput(String city){
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void setZip_postalCodeInput(String zip_postalCode){
        zip_postalCodeInput.click();
        zip_postalCodeInput.clear();
        zip_postalCodeInput.sendKeys(zip_postalCode);
    }

    public void setCountrySelect(String country){
        countrySelect.click();
        countrySelect.findElement(By.xpath("//select[@id='field-id_country']/option[@value='17']")).click();
    }

    public void setPhoneInput(String phone){
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void submitForm(){
        submitButton.click();
    }


}
