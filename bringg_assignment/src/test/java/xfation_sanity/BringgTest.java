package xfation_sanity;

import common.building_blocks.BringgUIService;
import common.page_objects.AddDriverPage;
import common.page_objects.LandingPage;
import common.page_objects.ShoppingStoreMenu;
import common.selenium_services.driver.SeleniumDriver;
import common.selenium_services.page.PageFactory;
import common.test.BaseTest;
import org.junit.*;
import org.junit.runners.MethodSorters;
import util.general_util.GeneralUtils;

/**
 * Created by asi on 2/19/2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BringgTest extends BaseTest {

    private BringgUIService bringgUIService = BringgUIService.getInstance();

    private PageFactory pageFactory = new PageFactory();

    private Integer numberOfDrivers = 2;


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
        pageFactory.createPage(PageFactory.Page.LANDING);
    }

    @Test
    public void cleenUpAccountTest() {
        bringgUIService.login(CLIENT_USER, CLIENT_PASSWORD);
        bringgUIService.enterSetting("Settings");
        bringgUIService.cleanAccount();
    }

    @Test
        public void createNewTeamTest() {
        bringgUIService.login(CLIENT_USER, CLIENT_PASSWORD);
        bringgUIService.clickHeader(LandingPage.HeaderItem.DRIVERS);
        bringgUIService.addTeam("New Item", "64444, Saudi Arabia");
        bringgUIService.verifyTeam("New Item", "64444, Saudi Arabia");
        int a = 0;
    }

    @Test
    public void createDriveTest() {
        bringgUIService.login(CLIENT_USER, CLIENT_PASSWORD);
        bringgUIService.clickHeader(LandingPage.HeaderItem.DRIVERS);
        for(int i = 0; i <= numberOfDrivers; i++) {

            String randomUser = GeneralUtils.getRandomEmail();
            String password = GeneralUtils.getRandomString();
            String driverName = GeneralUtils.getRandomString();

            bringgUIService.addDriver(randomUser, password, driverName, AddDriverPage.ValidatorOption.EMAIL_PASSWORD);
            bringgUIService.verifyDriverWasAdded(randomUser, driverName);
        }
    }

    @Test
    public void createNewOrderTest() {
        bringgUIService.login(CLIENT_USER, CLIENT_PASSWORD);
        bringgUIService.clickHeader(LandingPage.HeaderItem.PLANNING);
        bringgUIService.addOrder("New Order", "New", "Asi2", "64444, Saudi Arabia");
        bringgUIService.verifyOrder();
    }

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