package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PIMpage {
    public PIMpage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "button[class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
    public WebElement addButton;

    @FindBy(name = "firstName")
    public WebElement firstName;

    @FindBy(name = "lastName")
    public WebElement lastName;

    @FindBy(xpath = "//div[@class=\"oxd-toast-container oxd-toast-container--bottom\"]//preceding::input[@class=\"oxd-input oxd-input--active\" and @placeholder=\"Search\"]")
    public WebElement id;

    @FindBy(css = "button[type=submit")
    public WebElement save;

    @FindBy(css = "h6[class='oxd-text oxd-text--h6 --strong']")
    public WebElement text;


    Faker faker = new Faker();
    public String fName = faker.name().firstName();
   public String fLastName = faker.name().lastName();
   public String employeeID = faker.number().digits(3);

    /**
     * This method adds employee with some randomly generated data
     */
    public void addEmployee(){
        addButton.click();

        firstName.sendKeys(fName);
        lastName.sendKeys(fLastName);
        id.clear();
        id.sendKeys(employeeID);

        save.click();
    }




}
