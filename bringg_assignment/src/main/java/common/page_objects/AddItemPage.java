package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddItemPage implements Pageable {

    private static final By NAME_LOCATOR = By.id("teamName");
    private static final By ADDRESS_LOCATOR = By.xpath("//*[@id=\"teamAddress\"]/input[1]");
    private static final By ADD_LOCATOR = By.linkText("Add Team");


    private WebElement name;
    private WebElement address;
    private WebElement add;

    public AddItemPage(){

    }

    @Override
    public void prepareElements() {
        name = SeleniumDecorator.getInstance().getDriver().findElement(NAME_LOCATOR);
        address = SeleniumDecorator.getInstance().getDriver().findElement(ADDRESS_LOCATOR);
        add = SeleniumDecorator.getInstance().getDriver().findElement(ADD_LOCATOR);
    }

    public final void addTeam(final String name, final String address){
        decorator.clear(this.name).senkKeys(this.name, name);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ADDRESS_LOCATOR)).click();
        decorator.clear(this.address).senkKeys(this.address, address);
        this.address.sendKeys(Keys.ENTER);
        add.click();
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "https://app.bringg.com/#/login/";
    }
}
