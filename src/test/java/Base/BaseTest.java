package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

@ExtendWith(TestViewer.class)
abstract public class BaseTest {

    protected static WebDriver driver;

    @BeforeAll
        public static void setUp (){

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            BasePage.setDriver(driver);

    }

    @AfterAll
    public static void closeBrowser(){
        driver.close();
        driver.quit();
    }

}