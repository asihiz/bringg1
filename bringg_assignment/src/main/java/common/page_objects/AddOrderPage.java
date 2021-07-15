package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AddOrderPage implements Pageable {

    private static final By TITLE_LOCATOR = By.id("txt_order_title");
    private static final By TEAM_LOCATOR = By.className("select2-input");
    private static final By DRIVER_NAME_LOCATOR = By.className("task_way_point_customer-select");
    private static final By ADDRESS_LOCATOR = By.xpath("//*[@id=\"waypoint_address\"]/div[1]/span/span[2]/span");
    private static final By ADD_ORDER_LOCATOR = By.id("btn_add_new_order");

    private WebElement title;
    private WebElement team;
    private WebElement driver   ;
    private WebElement address;
    private WebElement add;

    private WebDriver webDriver = SeleniumDecorator.getInstance().getDriver();
    private JavascriptExecutor executor = (JavascriptExecutor)SeleniumDecorator.getInstance().getDriver();


    public AddOrderPage(){

    }

    @Override
    public void prepareElements() {
        title = webDriver.findElement(TITLE_LOCATOR);
        team = webDriver.findElement(TEAM_LOCATOR);
        address = webDriver.findElement(ADDRESS_LOCATOR);
        add = webDriver.findElement(ADD_ORDER_LOCATOR);
    }

    public final void addOrder(String title, String team, String driverName, String address){
        decorator.clear(this.title).senkKeys(this.title, title);
        decorator.doAutoComplete(this.team, team);
        decorator.doAutoComplete(webDriver.findElement(DRIVER_NAME_LOCATOR), driverName);
        decorator.doJavaScriptAutoComplete(this.address, address);
        add.click();
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
        return "";
    }
}
