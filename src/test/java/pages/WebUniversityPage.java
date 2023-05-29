package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class WebUniversityPage {

    public WebUniversityPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

        @FindBy (xpath = "//input[@placeholder='Add new todo']")
        public WebElement adNewTodo;

    @FindBy (xpath = "//li")
    public List<WebElement> todosWebElement;

    @FindBy (xpath = "//i[@class='fa fa-trash']")
    public List<WebElement> deleteButtonsWebElement;

    @FindBy (xpath = "//li")
    public List<WebElement> newtodosWebElement;


}
