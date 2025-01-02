package TaskOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainShopPage {
    private  static WebDriver driver;

    public MainShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//a[@href='https://mystore-testlab.coderslab.pl/index.php?controller=my-account']")
    WebElement signInButton;
    @FindBy(xpath = "//a[@href='https://mystore-testlab.coderslab.pl/index.php?mylogout=']")
    WebElement signoutButton;

    public void signIn() {
        signInButton.click();
    }
    public void signOut() {
        signoutButton.click();
    }

}
