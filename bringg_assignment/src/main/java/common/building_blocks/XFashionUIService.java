package common.building_blocks;


import common.page_objects.*;
import common.page_objects.*;
import common.selenium_services.page.PageFactory;

/**
 * Created by asih on 8/31/2017.
 */
public class XFashionUIService {

    private static final XFashionUIService INSTANCE = new XFashionUIService();

    private PageFactory pageFactory = new PageFactory();

    private LoginPage loginPage;

    private HomePage homePage;

    private ShoppingStoreMenu shoppingStoreMenu;

    private SummerDressPage summerDressPage;

//    private purchaseApprovalPage purchaseApprovalPage;

    private XFashionUIService() {
        // Avoid reflection calls on Singleton(
        // Private constructor can be called by reflection
        // Solve thread safe issues
        if (INSTANCE != null) {
            return;
        }
    }

    public static XFashionUIService getInstance() {
        return INSTANCE;
    }


    public final void signIn() {
        homePage = pageFactory.createPage(PageFactory.Page.HOME);
        homePage.signIn();
    }

    public void login(String email, String password) {
        loginPage = pageFactory.createPage(PageFactory.Page.LOGIN);
        loginPage.login(email, password);
    }

    public final void signUp(String email, String password) {
        signIn();
        login(email, password);
    }

    public void enterSummerDressMenu(ShoppingStoreMenu.ShopMenu shopMenu) {
        shoppingStoreMenu = pageFactory.createPage(PageFactory.Page.SHOPPING_STORE_MENU);
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
