package tests;

import io.opentelemetry.api.internal.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import pages.Guru99Page;
import utilities.Config;
import utilities.Driver;

import javax.swing.text.Utilities;

public class Guru99Test {
    WebDriver driver = Driver.getDriver();
    Guru99Page guru99Page = new Guru99Page();

    @Test
    public void test(){
        driver.get(Config.getProperty("guru99Manager"));
        guru99Page.newCustomer.click();
        guru99Page.submit.click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals(Config.getProperty("guru99AlertMessage"),alert.getText());
    }
}
