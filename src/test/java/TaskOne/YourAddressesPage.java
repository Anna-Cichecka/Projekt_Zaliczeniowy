package TaskOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourAddressesPage {
    private static WebDriver driver;


    public YourAddressesPage(WebDriver driver) {
        this.driver = driver;

    }

    WebElement alertSuccess = driver.findElement(By.xpath("//article[@role='alert' and @data-alert='success']"));
    WebElement plusCreateNewAddress = driver.findElement(By.xpath("//a[@data-link-action = 'add-address']"));

    public void getAddressId(){
    WebElement lastCurrentAddressDate = driver.findElements(By.className("address")).getLast();
    String id = lastCurrentAddressDate.getAttribute("id");
    // System.out.println(id);

}
    WebElement lastAddressArea = driver.findElement(By.xpath("//article[@id='\" + id + \"']"));
    WebElement lastAddress = driver.findElement(By.xpath("//article[@id='\" + id + \"']/div/address"));
    //System.out.println("lastAddress: " + lastAddress);
    //String pobranyAdres = lastAddress.getText();
    //System.out.println("pobrany adres: " + pobranyAdres);
    // System.out.println(" ");
    // System.out.println( expectedLoggedUser+"\n"+address+"\n"+city+"\n"+zip_postalCode+"\n"+country+"\n"+phone);
    WebElement lastAlias = driver.findElement(By.xpath("//article[@id='\" + id + \"']/div/h4"));
    //System.out.println("lastAlias: " + lastAlias);

    WebElement deleteAddress = driver.findElement(By.xpath("//article[@id='\" + id + \"']/div/a[@data-link-action = 'delete-address']"));

    public void addressDelete(){
     deleteAddress.click();
    }




}
