
package common.test;


import common.selenium_services.decorator.SeleniumDecorator;
import common.selenium_services.driver.SeleniumDriver;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import util.general_util.GeneralUtils;
import util.properties.PropertiesHandlerImpl;

import java.util.Properties;


public class BaseTest {

    public static String BASE_CLIENT_URL;

    public static String CLIENT_USER;

    public static String CLIENT_PASSWORD;

    public static final String BASE_CLIENT_URL_PROP = "base.url.client";

    public static final String CLIENT_USER_PROP = "client.user";

    public static final String CLIENT_PASSWORD_PROP = "client.password";

    private static final String FILE_NAME = "src/test/resources/env/application.properties";

    private final static Logger logger = Logger.getLogger(BaseTest.class);

    private static Properties props;

    public static void beforeClass() {
        configureLog4J();
        configureProps();
    }

    protected void before(SeleniumDriver.DriverType dt, SeleniumDriver.OS machine){
        SeleniumDecorator.getInstance().setDriver(setUp(dt, machine));
        SeleniumDecorator.getInstance().getDriver().get(BASE_CLIENT_URL);
    }

    private static void configureLog4J () {
        try {
            BasicConfigurator.configure();
        } catch (Exception e) {
        }
    }

    private static void configureProps() {
        try {
            props = PropertiesHandlerImpl.getInstance().parseFromFile(FILE_NAME);
            PropertiesHandlerImpl.setProps(props);
            injectPropData();
        } catch (Exception e) {
            GeneralUtils.reportError("Error reading property file", e);
        }
    }

    protected <T extends WebDriver> T setUp(SeleniumDriver.DriverType driverType, SeleniumDriver.OS os){
        return SeleniumDriver.getInstance().createDriver(driverType, os);
    }

    protected void closeDriver(){
        SeleniumDriver.getInstance().close();
    }

    private static void injectPropData(){
        BASE_CLIENT_URL = PropertiesHandlerImpl.getPropData().getProperty(BASE_CLIENT_URL_PROP);
        CLIENT_USER = PropertiesHandlerImpl.getPropData().getProperty(CLIENT_USER_PROP);
        CLIENT_PASSWORD = PropertiesHandlerImpl.getPropData().getProperty(CLIENT_PASSWORD_PROP);
    }


}
