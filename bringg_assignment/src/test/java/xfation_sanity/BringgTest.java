package xfation_sanity;

import common.building_blocks.BringgUIService;
import common.page_objects.ShoppingStoreMenu;
import common.selenium_services.driver.SeleniumDriver;
import common.selenium_services.page.PageFactory;
import common.test.BaseTest;
import org.junit.*;
import org.junit.runners.MethodSorters;

/**
 * Created by asi on 2/19/2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BringgTest extends BaseTest {

    private BringgUIService bringgUIService = BringgUIService.getInstance();
//    private PageFactory pageFactory = new PageFactory();


    @BeforeClass
    public static void beforeClass ()  {
        BaseTest.beforeClass();
    }

    @Before
    public void setUp() {
        super.before(SeleniumDriver.DriverType.CHROME, SeleniumDriver.OS.WINDOWS);
    }

    @Test
    public void loginTest() {
        bringgUIService.login(CLIENT_USER, CLIENT_PASSWORD);
        bringgUIService.enterSetting("Settings");
        bringgUIService.doSettingFlow();

    }

//    @Test
//    public void doShoppingFlowTest() {
//        xFashionUIService.signUp(CLIENT_USER, CLIENT_PASSWORD);
//        xFashionUIService.enterSummerDressMenu(ShoppingStoreMenu.ShopMenu.WOMEN);
//        xFashionUIService.doShoppingFlow();
//        xFashionUIService.approvePurchaseDiscount();
//    }

    @After
    public void tearDown()  {
        super.closeDriver();
    }

    @AfterClass
    public static void after() {
        try {
            SeleniumDriver.getInstance().close();
        } catch (Exception e) {

        }


    }

}