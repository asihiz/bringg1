package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SettingsPage implements Pageable {

    private static final By CLEAN_LOCATOR = By.xpath("/html/body/div[3]/div[2]/div/ng-view/div/div/div[2]/div/div/ng-form/div[17]/div/input");
    private static final By MERCHANT_CONG = By.linkText("Merchant Configuration");
//    private static final By GO_PLANNING = By.id("planning_phase_exists");
    private static final By GO_PLANNING = By.xpath("//*[contains(text(), 'Go through planning phase before execution')]");


    //*[@id="planning_phase_exists"]
    private static final By UPDATE_LOCATOR = By.xpath("/html/body/div[3]/div[2]/div/ng-view/div/div/div[2]/div/ng-include/div/div/div[1]/div/form/div/div[45]/div/input");

    private WebElement clean;
    private WebElement merchantConf;
    private WebElement goPlanning;
    private WebElement update;


    public SettingsPage(){

    }

    @Override
    public void prepareElements() {
        clean = driver.findElement(CLEAN_LOCATOR);
        merchantConf = driver.findElement(MERCHANT_CONG);
        goPlanning = driver.findElement(GO_PLANNING);
        update = driver.findElement(UPDATE_LOCATOR);

    }

    public final void doSettingFlow() {
        decorator.scroll(clean);
        clean.click();
        driver.switchTo().alert().accept();
        decorator.scroll(merchantConf);
        merchantConf.click();
        decorator.scroll(driver.findElement(UPDATE_LOCATOR));
        driver.findElement(UPDATE_LOCATOR).click();
        decorator.scroll(update);
        update.click();
        driver.navigate().refresh();
        Assert.assertEquals(goPlanning.isSelected(), true);
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "https://app.bringg.com/#/merchant/";
    }
}
