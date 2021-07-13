package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddTeamPage implements Pageable {

    private static final By NAME_LOCATOR = By.id("teamName");
    private static final By ADDRESS_LOCATOR = By.cssSelector("#teamAddress > div.ui-select-match.ng-scope");
    private static final By ADD_LOCATOR = By.linkText("Add Team");


    private WebElement name;
    private WebElement address;
    private WebElement add;

    private WebDriver driver = SeleniumDecorator.getInstance().getDriver();


    public AddTeamPage(){

    }

    @Override
    public void prepareElements() {
        name = driver.findElement(NAME_LOCATOR);
        address = driver.findElement(ADDRESS_LOCATOR);
        add = driver.findElement(ADD_LOCATOR);
    }

    public final void addTeam(final String name, final String address){
        decorator.clear(this.name).senkKeys(this.name, name);
        decorator.senkKeys(this.address, address);
        this.address.sendKeys(Keys.ENTER);
        add.click();
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "";
    }
}
