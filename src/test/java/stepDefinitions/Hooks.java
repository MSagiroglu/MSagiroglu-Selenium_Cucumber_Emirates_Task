package stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.Driver;


public class Hooks {


    @Before
    public void setUp() throws Exception {
        System.out.println("Scenariolar çalışmaya başladı");
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }




    @After//import io.cucumber.java.After;
    public void tearDown(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {//-->Scenario fail olursa
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            scenario.attach(ts.getScreenshotAs(OutputType.BYTES), "image/jpeg", scenario.getName());
            Driver.quitDriver();
        }
        Driver.closeDriver();
    }



}


