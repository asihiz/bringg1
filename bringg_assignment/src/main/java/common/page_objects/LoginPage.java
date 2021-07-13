package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.general_util.GeneralUtils;
import util.poller.Pollable;

public class LoginPage implements Pageable, Pollable {

    private static final By EMAIL_LOCATOR = By.id("inputEmail");
    private static final By PASSWORD_LOCATOR = By.id("inputPassword");
    private static final By SIGN_IN_LOCATOR = By.id("userPassword");
    private WebDriver driver = SeleniumDecorator.getInstance().getDriver();

    private WebElement email;
    private WebElement password;
    private WebElement singIn;

    public LoginPage(){

    }

    @Override
    public void prepareElements() {
        email = driver.findElement(EMAIL_LOCATOR);
        password = driver.findElement(PASSWORD_LOCATOR);
        singIn = driver.findElement(SIGN_IN_LOCATOR);
    }

    public final void login(final String email, final String password){

        this.email.sendKeys(email);
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
        try {
            driver.findElement(LandingPage.PROFILE_DROW_DOWN);
            return true;
        } catch (Exception e){
            return false;
        }
//        if(driver.getCurrentUrl().equalsIgnoreCase("https://app.bringg.com/#/map/")){
//            return true;
//        }
//        return false;

    }

}
