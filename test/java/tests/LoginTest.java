package tests;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utilities.Driver;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeEach
    public void before(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        LoginPage loginPage = new LoginPage();
    }
    @Test
    public void testSuccessfulLogin(){

        loginPage.login("Admin","admin123");

        Assertions.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }
    @Test
    public void wrongLogin(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        LoginPage loginPage = new LoginPage();
        loginPage.login("Admin","admin");
        Assertions.assertTrue(loginPage.invalidLOgInMessage.isDisplayed());
    }


}
