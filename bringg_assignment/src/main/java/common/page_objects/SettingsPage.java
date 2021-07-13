package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingsPage implements Pageable {

    private static final By CLEAN_LOCATOR = By.xpath("/html/body/div[3]/div[2]/div/ng-view/div/div/div[2]/div/div/ng-form/div[17]/div/input");
    private static final By MERCHANT_CONG = By.linkText("Merchant Configuration");
    private static final By DO_PLANNING = By.id("planning_phase_exists");
    private static final By UPDATE_LOCATOR = By.xpath("/html/body/div[3]/div[2]/div/ng-view/div/div/div[2]/div/ng-include/div/div/div[1]/div/form/div/div[45]/div/input");

    private WebElement clean;
    private WebElement merchantConf;

    private WebDriver driver = SeleniumDecorator.getInstance().getDriver();


    public SettingsPage(){

    }

    @Override
    public void prepareElements() {
        clean = driver.findElement(CLEAN_LOCATOR);
        merchantConf = driver.findElement(MERCHANT_CONG);
    }

    public final void cleanAccount() {
        decorator.scrollElement(clean).click();
        driver.switchTo().alert().accept();
        decorator.scrollElement(merchantConf).click();
        decorator.scrollElement(driver.findElement(DO_PLANNING)).click();
        decorator.scrollElement(driver.findElement(UPDATE_LOCATOR)).click();
        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(DO_PLANNING).isSelected(), true);
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "https://app.bringg.com/#/merchant/";
    }
}
