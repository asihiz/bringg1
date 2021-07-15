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

    private LandingPage landingPage;

    private SettingsPage settingsPage;

    private DriversPage driversPage;

    private AddTeamPage addTeamPage;

    private AddDriverPage addDriverPage;

    private PlanningPage planningPage;

    private AddOrderPage addOrderPage;

    private CleanOrdersPage cleanOrdersPage;


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

    public final void enterProfile(LandingPage.ProfileItem item){
        landingPage = pageFactory.createPage(PageFactory.Page.LANDING);
        landingPage.enterProfile(item);
    }

    public final void clickHeader(LandingPage.HeaderItem headerItem) {
        landingPage = pageFactory.createPage(PageFactory.Page.LANDING);
        landingPage.clickHeader(headerItem);
    }

    public final void cleanAccount() {
        settingsPage = pageFactory.createPage(PageFactory.Page.SETTING);
        settingsPage.cleanAccount();
    }

    public final void       addTeam(final String name, final String address) {
        driversPage = pageFactory.createPage(PageFactory.Page.DRIVERS);
        driversPage.addTeam();
        addTeamPage = pageFactory.createPage(PageFactory.Page.ADD_TEAM);
        addTeamPage.addTeam(name, address);
    }

    public final void verifyTeam(final String name, final String address) {
        driversPage = pageFactory.createPage(PageFactory.Page.DRIVERS);
        driversPage.verifyTeamWasAdded(name, address);
    }

    public final void goToTeam() {
        driversPage = pageFactory.createPage(PageFactory.Page.DRIVERS);
        driversPage.goToTeams();
    }

    public final void addDriver(String username, String password, String driverName, AddDriverPage.ValidatorOption vo){
        driversPage = pageFactory.createPage(PageFactory.Page.DRIVERS);
        driversPage.addDriver();
        addDriverPage = pageFactory.createPage(PageFactory.Page.ADD_DRIVER);
        addDriverPage.addDriver(username, password, driverName, vo);
    }

    public final void verifyDriverWasAdded(String driverName) {
        driversPage = pageFactory.createPage(PageFactory.Page.DRIVERS);
        driversPage.verifyDriverWasAdded(driverName);
    }

    public final void addOrder(String title, String team, String driver, String address){
        planningPage = pageFactory.createPage(PageFactory.Page.PLANNING);
        planningPage.addOrder();
        addOrderPage = pageFactory.createPage(PageFactory.Page.ADD_ORDER);
        addOrderPage.addOrder(title, team, driver, address);
    }

    public final void verifyOrder() {
        planningPage = pageFactory.createPage(PageFactory.Page.PLANNING);
        planningPage.verifyOrder();
    }

    public final void clean(CleanOrdersPage.MoreAction moreAction) {
        cleanOrdersPage = pageFactory.createPage(PageFactory.Page.CLEAN_ORDER);
        cleanOrdersPage.clean(moreAction);
    }


}
