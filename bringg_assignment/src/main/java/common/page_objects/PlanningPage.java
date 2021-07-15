package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlanningPage implements Pageable {

    private static final By ADD_ORDER_LOCATOR = By.id("btn_add_order");

    private static final By TABLE_ROW_LOCATOR = By.className("odd");

    private static final By TABLE_ROW_LOCATOR2 = By.className("even");


    private WebElement addOrder;

    private WebDriver driver = SeleniumDecorator.getInstance().getDriver();


    public PlanningPage(){

    }

    @Override
    public void prepareElements() {
        addOrder = driver.findElement(ADD_ORDER_LOCATOR);
    }

    public final void addOrder(){
        addOrder.click();
    }

    public final void verifyOrder(){
//        Assert.assertEquals("Order doesn't appear in table", 1, driver.findElements(TABLE_ROW_LOCATOR).size());
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "https://app.bringg.com/#/planning/";
    }
}
