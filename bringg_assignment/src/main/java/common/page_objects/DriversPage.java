package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DriversPage implements Pageable {

    private static final By TEAM_LOCATOR = By.linkText("Teams");
    private static final By ADD_TEAM = By.xpath("/html/body/div[3]/div[2]/div/ng-view/div/div[1]/div[2]/div/button");
    private static final By ADD_DRIVER = By.id("btn_add_driver");
//    private static final By DRIVER_TABLE_ITEM = By.className("ng-scope");;

    private WebElement teams;
    private WebElement addDriver;

    public DriversPage(){

    }

    @Override
    public void prepareElements() {
         teams = SeleniumDecorator.getInstance().getDriver().findElement(TEAM_LOCATOR);
    }

    public final void addTeam(){
        teams.click();
        driver.findElement(ADD_TEAM).click();
    }

    public final void verifyTeamWasAdded(final String name, final String address){
        driver.navigate().refresh();
        Assert.assertTrue(decorator.assertText(name));
        Assert.assertTrue(decorator.assertText(address));
    }

    public void verifyDriverWasAdded(String driverName, String username){
        Assert.assertTrue(decorator.assertText(driverName));
        Assert.assertTrue(decorator.assertText(username));
    }

    public final void addDriver(){
        driver.findElement(ADD_DRIVER).click();
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "https://app.bringg.com/#/login/";
    }
}
