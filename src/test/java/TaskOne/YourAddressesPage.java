package TaskOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourAddressesPage {
    private static WebDriver driver;
    WebElement alertSuccess;
    WebElement lastAddressArea;
    WebElement lastAddress;
    String lastAlias;
    String id;


    public YourAddressesPage(WebDriver driver) {
        this.driver = driver;

    }

    public void clickCreateNewAddress() {
        WebElement plusCreateNewAddress = driver.findElement(By.xpath("//a[@data-link-action = 'add-address']"));
        plusCreateNewAddress.click();

    }

    public boolean alertSuccessIsDisplayed() {

        alertSuccess = driver.findElement(By.xpath("//article[@role='alert' and @data-alert='success']"));
        boolean a = alertSuccess.isDisplayed();
        return a;

    }

   public String getAddressId() {
       WebElement lastCurrentAddressDate = driver.findElements(By.className("address")).getLast();
       id = lastCurrentAddressDate.getAttribute("id");
        System.out.println(id);
       return id;
   }

    public void findLastAddressArea() {

        lastAddressArea = driver.findElement(By.xpath("//article[@id='\" + id + \"']"));
    }

    public void findLastAddress() {
        lastAddress = driver.findElement(By.xpath("//article[@id='\" + id + \"']/div/address"));

        //System.out.println("lastAddress: " + lastAddress);
        //String pobranyAdres = lastAddress.getText();
        //System.out.println("pobrany adres: " + pobranyAdres);
        // System.out.println(" ");
        // System.out.println( expectedLoggedUser+"\n"+address+"\n"+city+"\n"+zip_postalCode+"\n"+country+"\n"+phone);
        //
    }

    public String getLastAlias() {


        String lastAlias = driver.findElement(By.xpath("//article[@id='\" + id + \"']/div/h4")).getText();
        //System.out.println("lastAlias: " + lastAlias);
        return lastAlias;

    }


    public void clickAddressDelete() {
        WebElement deleteAddress = driver.findElement(By.xpath("//article[@id='\" + id + \"']/div/a[@data-link-action = 'delete-address']"));
        deleteAddress.click();
    }


}
