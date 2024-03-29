package com.UKTalentHubJava.test_cases.testng;

import com.UKTalentHubJava.utilities.ReadConfig;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseClassAutomationPractice {

    ReadConfig readconfig = new ReadConfig();
    public String baseURL = "https://practice.automationtesting.in/my-account/";

    public String username = "123123@email.com";
    public String password = "PasswordPassword!Password!123";
    public String testName;

    public WebDriver driver;
    public static Logger logger;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String br) {

        logger = Logger.getLogger("UkTalentHub");
        PropertyConfigurator.configure("Log4j.properties");

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

        if (br.equals("chrome")) {
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--disable-notifications");

            //System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
            //WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver(ops);
            driver.manage().window().maximize();

        } else if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (br.equals("ie")) {
            System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseURL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
