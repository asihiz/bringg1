package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.general_util.GeneralUtils;
import util.poller.Pollable;

import java.util.ArrayList;
import java.util.List;

public class CleanOrdersPage implements Pageable {

    private static final By TABLE_LINE_MARK_ITEM = By.className("slick-select");
    private static final By SELECT_ALL = By.className("group-select-all");



    private static final By MORE_ACTION_DROP_DOWN = By.id("btnMoreOptions");

    private static final By MORE_ACTION_ITEM = By.className("ng-binding");

    private static final By REASON_DDL = By.id("reasonSelect");

    private static final By CONFIRM = By.xpath("/html/body/div[1]/div/div/div/div[3]/button[2]");

    private List<WebElement> tableCheckBox = new ArrayList<>();

    private WebElement selectAll;
    private WebElement classElement;

    private WebElement addOrder;

    private WebDriver driver = SeleniumDecorator.getInstance().getDriver();


    public CleanOrdersPage(){

    }

    @Override
    public void prepareElements() {
        selectAll = driver.findElement(SELECT_ALL);
    }

    public final void clean(MoreAction moreAction) {
        selectLine();
        doMoreActions(moreAction);
    }

    public final void selectLine(){
        selectAll.click();
    }

    public final void doMoreActions(MoreAction moreAction){
        decorator.handleDropDown(driver.findElement(MORE_ACTION_DROP_DOWN), MORE_ACTION_ITEM, moreAction.value);
        WebElement reason = driver.findElement(REASON_DDL);
        reason.click();
        reason.sendKeys(Keys.ARROW_DOWN);
        reason.sendKeys(Keys.ENTER);
        driver.findElement(CONFIRM).click();
    }

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
