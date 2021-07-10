package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddOrderPage implements Pageable {

    private static final By TITLE_LOCATOR = By.id("txt_order_title");
    private static final By TEAM_LOCATOR = By.className("select2-input");
    private static final By DRIVER_NAME_LOCATOR = By.className("task_way_point_customer-select");
    private static final By ADDRESS_LOCATOR = By.id("waypoint_second_address");
    private static final By ADD_ORDER_LOCATOR = By.id("btn_add_order");

    private WebElement title;
    private WebElement team;
    private WebElement driver   ;
    private WebElement address;
    private WebElement add;

    public AddOrderPage(){

    }

    @Override
    public void prepareElements() {
        title = driver.findElement(TITLE_LOCATOR);
        team = driver.findElement(TEAM_LOCATOR);
//        driver = driver.findElement(DRIVER_NAME_LOCATOR);
        address = driver.findElement(ADDRESS_LOCATOR);
        add = driver.findElement(ADD_ORDER_LOCATOR);
    }

    public final void addOrder(String title, String team, String driver, String address){

        decorator.clear(this.title).senkKeys(this.title, title);
        decorator.clear(this.team).senkKeys(this.team, team);
        this.team.sendKeys(Keys.ENTER);
        this.driver = driver.findElement(DRIVER_NAME_LOCATOR);
        decorator.waitForVisibility(this.driver);
        decorator.senkKeys(this.driver, driver);
        this.driver.sendKeys(Keys.ENTER);
        decorator.clear(this.address).senkKeys(this.address, address);
        this.address.sendKeys(Keys.ENTER);
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
        return "https://app.bringg.com/#/login/";
    }
}
