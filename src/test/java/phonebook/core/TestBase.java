package phonebook.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {
    // браузер по умолчанию
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser","chrome"));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void startTest() {
        app.init();
    }

    @AfterSuite
    public void stopTest(){
        app.stop();
    }

    @BeforeMethod
    public void setUp(Method method, Object[] p) {
        logger.info("logger info: " + method.getName() + "with data: " + Arrays.asList(p));
        //logger.warn("logger warn");
        //logger.error("logger error");
        //logger.debug("logger debug");
    }

    @AfterMethod(enabled = true)
    public void tearDown(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED" + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED" + result.getMethod().getMethodName() + " Screenshot: " + app.getUserHelper().takeScreenshot());
        }

        logger.info("===========================================================================" );
    }
}
