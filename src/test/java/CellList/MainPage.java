package CellList;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readProperties.Utils;
import java.util.List;


public class MainPage extends BasePage {

    public MainPage () {

        driver.get(Utils.getProperty("url"));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='middleCenterInner']//td[2]/input)[1]")
    private WebElement firstName;

    @FindBy(xpath = "(//div[@class='middleCenterInner']//td[2]/input)[2]")
    private WebElement lastName;

    @FindBy(xpath = "//select[@class='gwt-ListBox']")
    private WebElement category;

    @FindBy(xpath = "//option[@value='Family']")
    private WebElement categoryValue;

    @FindBy(xpath = "//input[@class='gwt-DateBox']")
    private WebElement birthdayField;

    @FindBy(xpath = "//table[@class='datePickerDays']//td/div[text()='16']")
    private WebElement birthdayValue;

    @FindBy(xpath = "//div[@class='middleCenterInner']//td[2]/textarea")
    private WebElement address;

    @FindBy(xpath = "//button[text()='Update Contact']")
    private WebElement updateContact;

    @FindBy(xpath = "//button[text()='Create Contact']")
    private WebElement createContact;

    @FindBy(xpath = "//div[@class='gwt-HTML'][contains(text(),'25')]")
    private WebElement amountContacts;


    public MainPage createContact (String firstNameValue, String lastNameValue, String addressValue){
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        category.click();
        categoryValue.click();
        birthdayField.click();
        birthdayValue.click();
        address.sendKeys(addressValue);
        createContact.click();
        return this;
    }

    /**
     * Метод для нажатия на поле First Name
     */

    public void clickFirstName(){
        firstName.click();
    }

    /**
     * Метод для нажатия на поле Last Name
     */

    public void clickLastName(){
        lastName.click();
    }

    /**
     * Метод для подставления нового значения в First Name
     */

    public void updateFirstName(String firstname) {
        clickFirstName();
        firstName.clear();
        firstName.sendKeys(firstname);
        updateContact.click();
    }

    /**
     * Метод для подставления нового значения в Last Name
     */

    public void updateLastname(String lastname) {
        clickLastName();
        lastName.clear();
        lastName.sendKeys(lastname);
        updateContact.click();
    }

    /**
     * Метод возвращающий первый элемент в списке контактов
     */

    public WebElement getFirstContact(){
        List<WebElement> contacts = driver.findElements(By.xpath("//div[@class='CMWVMEC-g-a']"));
        WebElement firstContact = contacts.get(0);

        return firstContact;
    }

    /**
     * Метод для получения количества контактов в списке
     */

    public String getContactsTotalAmount(){
        String rawAmount = amountContacts.getText();
        String[] splitAmount = rawAmount.split(  ": ");
        String totalAmount = splitAmount[splitAmount.length - 1];

        return totalAmount;
    }
}