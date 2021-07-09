package common.building_blocks;


import common.page_objects.*;
import common.selenium_services.page.PageFactory;

/**
 * Created by asih on 8/31/2017.
 */
public class BringgUIService {

    private static final BringgUIService INSTANCE = new BringgUIService();

    private PageFactory pageFactory = new PageFactory();

    private LoginPage loginPage;

    private HomePage homePage;

    private LandingPage landingPage;

    private SettingsPage settingsPage;


    private SummerDressPage summerDressPage;

//    private purchaseApprovalPage purchaseApprovalPage;

    private BringgUIService() {
        // Avoid reflection calls on Singleton(
        // Private constructor can be called by reflection
        // Solve thread safe issues
        if (INSTANCE != null) {
            return;
        }
    }

    public static BringgUIService getInstance() {
        return INSTANCE;
    }


//    public final void signIn() {
//        homePage = pageFactory.createPage(PageFactory.Page.HOME);
//        homePage.signIn();
//    }

    public void login(String email, String password) {
        loginPage = pageFactory.createPage(PageFactory.Page.LOGIN);
        loginPage.login(email, password);
    }

    public final void enterSetting(String value) {
        landingPage = pageFactory.createPage(PageFactory.Page.LANDING);
        landingPage.enterSetting(value);
    }


    public final void clean() {
        settingsPage = pageFactory.createPage(PageFactory.Page.SETTING);
        settingsPage.clean();
    }

    public void enterSummerDressMenu(ShoppingStoreMenu.ShopMenu shopMenu) {
//        shoppingStoreMenu = pageFactory.createPage(PageFactory.Page.SHOPPING_STORE_MENU);
        shopMenu.enterSummerDressMenu(shopMenu);
    }

    public final void doShoppingFlow() {
        summerDressPage = pageFactory.createPage(PageFactory.Page.SUMMER_DRESS);
        summerDressPage.doShoppingFlow();
    }

    public final void approvePurchaseDiscount() {
//        purchaseApprovalPage = pageFactory.createPage(PageFactory.Page.PURCHASE_APPROVAL);
//        purchaseApprovalPage.approveDiscount();
    }

}
