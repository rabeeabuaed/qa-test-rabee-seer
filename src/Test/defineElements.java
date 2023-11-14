package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

public class defineElements {

    static WebDriver driver;

    @FindBy(how = How.NAME, using = "name")
    WebElement name;

    @FindBy(how = How.NAME, using = "phone")
    WebElement phone;

    @FindBy(how = How.NAME, using = "email")
    WebElement email;

    @FindBy(how = How.NAME, using = "country")
    WebElement country;

    @FindBy(how = How.NAME, using = "city")
    WebElement city;

    @FindBy(how = How.CSS, using = "#load_form > fieldset:nth-child(10) > input[type=text]")
    WebElement username;

    @FindBy(how = How.CSS, using = "#load_form > fieldset:nth-child(11) > input[type=password]")
    WebElement paswword;

    @FindBy(how = How.XPATH, using = "//body/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/input[1]")
    WebElement submit;

    @FindBy(how = How.CSS, using = "#alert")
    WebElement alert;
 
    public void ClickOnTheElement(WebElement element) {
        element.click();
        // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void ClickOnTheElementWhenView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void SendValue(WebElement element, String input) {
        element.click();
        element.clear();
        element.sendKeys(input);
    }

    public String GetTheTextOfTheElement(WebElement element) {
        return element.getText();
    }

    defineElements(ThreadLocal<WebDriver> driver2) {
        driver = driver2.get();
        PageFactory.initElements(driver, this);
    }
    
    
}
