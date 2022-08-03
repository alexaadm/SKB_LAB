package CellList;

import Base.BaseTest;
import Helpers.TestValues;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CellListTest extends BaseTest {

    MainPage mainPage = new MainPage();

    private List<WebElement> categories = driver.findElements(By.xpath("//select[@class='gwt-ListBox']//option"));

    @Test
    @Description ("Тест на создание контакта и проверка что список контактов увеличивается на +1 ")
    public void checkContact(){

        String initialAmount = mainPage.getContactsTotalAmount();

        mainPage.createContact(TestValues.TEST_FirstName, TestValues.TEST_LastName ,TestValues.TEST_Address);

        String newAmount = mainPage.getContactsTotalAmount();

        int expectedDifference = 1;
        int difference = Integer.parseInt(newAmount) - Integer.parseInt(initialAmount);

        Assert.assertEquals(expectedDifference, difference);

    }

    @Test
    @Description ("В выпающем списке Category 5 позиций")
    public void checkCategoryList(){
      int expectedElementsAmount = 5;

      Assert.assertEquals(expectedElementsAmount, categories.size());
    }

    @Test
    @Description ("В выпадающем списке Category выводятся правильные категории")
    public void checkCategoriesSuitability(){
        String[] expectedCategories = {"Family", "Friends", "Coworkers", "Businesses"};

        for (int i = 0; i < expectedCategories.length; i++) {
            Assert.assertEquals(expectedCategories[i], categories.get(i).getText());
        }
    }

    @Test
    @Description ("Тест на обновление данных о контакте и проверка что обновленный контакт отображается в списке")
    public void checkContactEditions(){
        String valueToRenameFirstname = TestValues.TEST_FirstName;
        String valueToRenameLastname = TestValues.TEST_LastName;
        String contactNameXpath = "//div[@tabindex='0']/descendant::td/following-sibling::td";

        WebElement firstContact = mainPage.getFirstContact();

        firstContact.click();
        mainPage.updateFirstName(valueToRenameFirstname);
        mainPage.updateLastname(valueToRenameLastname);

        String firstContactName = driver.findElements(By.xpath(contactNameXpath)).get(0).getText();

        Assert.assertEquals(valueToRenameFirstname + " " + valueToRenameLastname, firstContactName);
    }
}