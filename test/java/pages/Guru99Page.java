package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Guru99Page {
    public Guru99Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='New Customer']")
    public  WebElement newCustomer;

    @FindBy(name = "name")
    public WebElement nameInput;

    @FindBy(css = "input[type='submit']")
    public WebElement submit;




}
