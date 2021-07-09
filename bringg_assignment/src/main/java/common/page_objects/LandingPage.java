package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LandingPage implements Pageable {

    private static final By PROFILE_DROW_DOWN = By.className("dropdown-toggle");
    private static final By LIST_ITEM_LOCATOR = By.className("ng-binding");

    public LandingPage(){

    }

    @Override
    public void prepareElements() {
    }

    public final void enterSetting(final String value){
        decorator.handleDropDown(driver.findElement(PROFILE_DROW_DOWN), LIST_ITEM_LOCATOR, value);
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "https://app.bringg.com/#/map/";
    }

    public enum HeaderItem {

        SETTING;
    }
}
