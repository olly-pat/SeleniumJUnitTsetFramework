package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPage;
import pages.LoginPage;
import pages.PIMpage;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.time.Duration;

public class PIMTest {
    PIMpage piMpage = new PIMpage();
    LoginPage loginPage = new LoginPage();
    WebDriver driver = Driver.getDriver();
    CommonPage commonPage = new CommonPage();

    @BeforeEach
    public void before(){
       loginPage.login("Admin", "admin123");
    }

    @Test
    public void test(){
        commonPage.pimTab.click();
        piMpage.addEmployee();

        String expectedName = piMpage.firstName + " "+piMpage.lastName;
        SeleniumUtils.verifyTextInElement(driver,20,piMpage.text,expectedName);

        commonPage.pimTab.click();

        WebElement empIdTable = driver.findElement(By.xpath("//div[text()='"+ piMpage.employeeID + "']"));
        WebElement firstNameInTable = driver.findElement(By.xpath("//div[text()='"+ piMpage.employeeID + "']/../following-sibling::div[1]"));
        WebElement lastNameInTable = driver.findElement(By.xpath("//div[text()='"+ piMpage.employeeID + "']/../following-sibling::div[2]"));

        SeleniumUtils.verifyTextInElement(driver,10,empIdTable,piMpage.employeeID);
        SeleniumUtils.verifyTextInElement(driver,10,firstNameInTable,piMpage.fName);
        SeleniumUtils.verifyTextInElement(driver,10,lastNameInTable,piMpage.fLastName);

    }
}
