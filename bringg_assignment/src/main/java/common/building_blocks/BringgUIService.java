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


    private DriversPage driversPage;

    private AddItemPage addItemPage;


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


    public void login(String email, String password) {
        loginPage = pageFactory.createPage(PageFactory.Page.LOGIN);
        loginPage.login(email, password);
    }

    public final void enterSetting(String value) {
        landingPage = pageFactory.createPage(PageFactory.Page.LANDING);
        landingPage.enterSetting(value);
    }

    public final void clickHeader(LandingPage.HeaderItem headerItem) {
        landingPage = pageFactory.createPage(PageFactory.Page.LANDING);
        landingPage.clickHeader(headerItem);
    }

    public final void cleanAccount() {
        settingsPage = pageFactory.createPage(PageFactory.Page.SETTING);
        settingsPage.cleanAccount();
    }

    public final void addTeam(final String name, final String address) {
        driversPage = pageFactory.createPage(PageFactory.Page.DRIVERS);
        driversPage.addTeam();
        addItemPage = pageFactory.createPage(PageFactory.Page.ADD_ITEM);
        addItemPage.addTeam(name, address);
    }

    public final void verifyTeam(final String name, final String address) {
        driversPage = pageFactory.createPage(PageFactory.Page.DRIVERS);
        driversPage.verifyTeamWasAdded(name, address);
    }



    public void enterSummerDressMenu(ShoppingStoreMenu.ShopMenu shopMenu) {
//        shoppingStoreMenu = pageFactory.createPage(PageFactory.Page.SHOPPING_STORE_MENU);
        shopMenu.enterSummerDressMenu(shopMenu);
    }



    public final void approvePurchaseDiscount() {
//        purchaseApprovalPage = pageFactory.createPage(PageFactory.Page.PURCHASE_APPROVAL);
//        purchaseApprovalPage.approveDiscount();
    }

}
