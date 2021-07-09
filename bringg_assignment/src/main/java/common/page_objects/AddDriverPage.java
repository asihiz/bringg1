package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddDriverPage implements Pageable {

    private static final By VALIDATOR_METHOD_LOCATOR = By.className("dropdown-toggle");
    private static final By LIST_ITEM_LOCATOR = By.className("ng-binding");
    private static final By DRIVER_NAME_LOCATOR = By.id("userName");
    private static final By USER_NAME_LOCATOR = By.id("userEmail");
    private static final By PASSWORD_LOCATOR = By.id("userPassword");
    private static final By ADD_DRIVER_LOCATOR = By.linkText("Add Driver");





//    private static final By ADD_TEAM = By.xpath("/html/body/div[3]/div[2]/div/ng-view/div/div[1]/div[2]/div/button");
//    private static final By ADD_DRIVER = By.linkText("Add Driver");


    private WebElement dropdown;
    private WebElement driverName;
    private WebElement add;
    private WebElement username;
    private WebElement password;



    public AddDriverPage(){

    }

    @Override
    public void prepareElements() {
        dropdown = SeleniumDecorator.getInstance().getDriver().findElement(VALIDATOR_METHOD_LOCATOR);
        driverName = SeleniumDecorator.getInstance().getDriver().findElement(DRIVER_NAME_LOCATOR);
        username = SeleniumDecorator.getInstance().getDriver().findElement(USER_NAME_LOCATOR);
        password = SeleniumDecorator.getInstance().getDriver().findElement(PASSWORD_LOCATOR);
        add = SeleniumDecorator.getInstance().getDriver().findElement(ADD_DRIVER_LOCATOR);

    }

    public final void addDriver(String username, String password, String driverName, ValidatorOption vo){
        decorator.clear(this.driverName).senkKeys(this.driverName, driverName);
        decorator.handleDropDown(dropdown, LIST_ITEM_LOCATOR, vo.value);
        decorator.clear(this.username).senkKeys(this.username, username);
        decorator.clear(this.password).senkKeys(this.password, password);

    }


    public enum ValidatorOption {

        PHONE_SMS ("Phone / SMS Validation"),
        EMAIL_PASSWORD ("Email and Password");

        String value;


        ValidatorOption(String value) {
            this.value = value;
        }
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "https://app.bringg.com/#/login/";
    }
}
