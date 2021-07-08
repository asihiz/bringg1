package common.page_objects;

import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.page.Pageable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage implements Pageable {

    private static final By EMAIL_LOCATOR = By.id("email");

    private static final By PASSWORD_LOCATOR = By.id("passwd");

    @FindBy
    private static final By SIGN_IN_LOCATOR = By.id("SubmitLogin");


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

    public void login(String email, String password){
        decorator.clear(this.email).senkKeys(this.email, email);
        decorator.clear(this.password).senkKeys(this.password, password);
        singIn.click();
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    }
}
