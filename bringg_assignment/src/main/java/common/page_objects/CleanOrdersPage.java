package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CleanOrdersPage implements Pageable {

    private static final By TABLE_LINE_MARK_ITEM = By.className("slick-select");

    private static final By MORE_ACTION_DROP_DOWN = By.id("btnMoreOptions");

    private static final By MORE_ACTION_ITEM = By.className("ng-binding ");

    private static final By REASON_DDL = By.id("reasonSelect");

    private static final By CONFIRM = By.linkText("Confirm");

    private List<WebElement> tableCheckBox = new ArrayList<>();







//    private static final By TABLE_ROW_LOCATOR = By.className("odd");

//    private static final By TABLE_ROW_LOCATOR2 = By.className("even");


    private WebElement addOrder;

    private WebDriver driver = SeleniumDecorator.getInstance().getDriver();


    public CleanOrdersPage(){

    }

    @Override
    public void prepareElements() {
        tableCheckBox = driver.findElements(TABLE_LINE_MARK_ITEM);
    }

    public final void clean(MoreAction moreAction) {
        selectLine();
        doMoreActions(moreAction);
    }

    public final void selectLine(){
        for (WebElement we : tableCheckBox){
            we.click();
        }
    }

    public final void doMoreActions(MoreAction moreAction){
        decorator.handleDropDown(driver.findElement(MORE_ACTION_DROP_DOWN), MORE_ACTION_ITEM, moreAction.value);
        WebElement reason = driver.findElement(REASON_DDL);
        reason.click();
        reason.sendKeys(Keys.ARROW_DOWN);
        reason.sendKeys(Keys.ENTER);
        driver.findElement(CONFIRM).click();


//        addOrder.click();
    }

//    public final void verifyOrder(){
//        Assert.assertEquals("Order doesn't appear in table", 1, driver.findElements(TABLE_ROW_LOCATOR).size() + driver.findElements(TABLE_ROW_LOCATOR2).size());
//    }

    public enum MoreAction {

        CANCEL_ORDERS ("Cancel Orders");

        private String value;

        MoreAction(String value){
            this.value = value;
        }

    }

    @Override
    public String getPageUniqueIdentifier() {
        return "https://app.bringg.com/#/planning/";
    }
}
