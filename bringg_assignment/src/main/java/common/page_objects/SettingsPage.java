package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SettingsPage implements Pageable {

    private static final By CLEAN_LOCATOR = By.xpath("/html/body/div[3]/div[2]/div/ng-view/div/div/div[2]/div/div/ng-form/div[17]/div/input");

    private WebElement clean;

    public SettingsPage(){

    }

    @Override
    public void prepareElements() {
        clean = driver.findElement(CLEAN_LOCATOR);
    }

    public final void clean(){
        decorator.scroll(clean);
        clean.click();
        driver.switchTo().alert().accept();
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "https://app.bringg.com/#/merchant/";
    }
}
