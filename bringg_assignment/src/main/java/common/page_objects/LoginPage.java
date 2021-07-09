package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.general_util.GeneralUtils;
import util.poller.Pollable;

public class LoginPage implements Pageable, Pollable {

    private static final By EMAIL_LOCATOR = By.id("inputEmail");
    private static final By PASSWORD_LOCATOR = By.id("inputPassword");
    private static final By SIGN_IN_LOCATOR = By.id("userPassword");


    private WebElement email;
    private WebElement password;
    private WebElement singIn;

    public LoginPage(){

    }

    @Override
    public void prepareElements() {
        email = SeleniumDecorator.getInstance().getDriver().findElement(EMAIL_LOCATOR);
        password = SeleniumDecorator.getInstance().getDriver().findElement(PASSWORD_LOCATOR);
        singIn = SeleniumDecorator.getInstance().getDriver().findElement(SIGN_IN_LOCATOR);
    }

    public final void login(final String email, final String password){
        decorator.clear(this.email).senkKeys(this.email, email);
        decorator.clear(this.password).senkKeys(this.password, password);
        singIn.click();
        try {
            Pollable.super.waitUntil(15000, 1000, "cant click on register exception");
        } catch (Exception e){
            GeneralUtils.reportError("cant click on register exceptio", e);
        }
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "https://app.bringg.com/#/login/";
    }

    @Override
    public boolean until() throws Exception {
        if(driver.getCurrentUrl().equalsIgnoreCase("https://app.bringg.com/#/map/")){
            return true;
        }
        return false;

    }

}
