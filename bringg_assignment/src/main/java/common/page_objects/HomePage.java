package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage implements Pageable {

    private static final By SIGN_IN_LOCATOR = By.className("header_user_info");

    private WebElement signIn;

    private final static Logger logger = Logger.getLogger(HomePage.class);

    public HomePage(){
    }

    @Override
    public void prepareElements() {
        signIn = SeleniumDecorator.getInstance().getDriver().findElement(SIGN_IN_LOCATOR);
    }

    public void signIn() {
        signIn.click();
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "http://automationpractice.com/index.php";
    }



}
