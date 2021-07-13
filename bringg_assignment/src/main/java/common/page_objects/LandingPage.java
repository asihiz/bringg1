package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage implements Pageable {

    public static final By PROFILE_DROW_DOWN = By.className("dropdown-toggle");
    private static final By LIST_ITEM_LOCATOR = By.className("ng-binding");

    private WebDriver driver = SeleniumDecorator.getInstance().getDriver();


    public LandingPage(){

    }

    @Override
    public void prepareElements() {
    }

    public final void enterProfile(ProfileItem item){
        decorator.handleDropDown(driver.findElement(PROFILE_DROW_DOWN), LIST_ITEM_LOCATOR, item.value);
    }

    public void clickHeader(HeaderItem headerItem) {
        driver.findElement(headerItem.locator).click();
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "https://app.bringg.com/#/map/";
    }

    public enum HeaderItem {

        DRIVERS (By.linkText("Drivers")),
        PLANNING (By.linkText("Dispatch"));

        private By locator;

        HeaderItem(By locator){
            this.locator = locator;
        }


    }

    public enum ProfileItem {

        SETTING ("Settings"),
        LOG_OUT ("Log Out");

        private String value;

        ProfileItem(String value){
            this.value = value;
        }


    }
}
