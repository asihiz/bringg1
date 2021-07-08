package common.page_objects;

import common.selenium_services.page.Pageable;
import org.openqa.selenium.By;

public class ShoppingStoreMenu implements Pageable {

    private static final By MAIN_MENU_LOCATOR = By.className("sf-with-ul");

    private static final By SUMMER_DRESSES_LOCATOR = By.linkText("Summer Dresses");


    public ShoppingStoreMenu(){

    }

    @Override
    public void prepareElements() {
    }

    public enum ShopMenu {

        WOMEN ("Women");
//        DRESSES ("Dresses");

        public String titleValue;

        ShopMenu(String titleValue) {
            this.titleValue = titleValue;
        }

        public void enterSummerDressMenu(ShopMenu shopMenu){
           decorator.elementHover(decorator.getDriver().findElement(MAIN_MENU_LOCATOR), SUMMER_DRESSES_LOCATOR);
        }
    }

    @Override
    public String getPageUniqueIdentifier() {
        return "http://automationpractice.com/index.php?controller=my-account";
    }


}
