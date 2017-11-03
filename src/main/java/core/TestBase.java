package core;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {

    @BeforeTest
    public void setUp() {
        Driver.init();
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(Long.parseLong(PropertiesContainer.get("test.timeout")), TimeUnit.SECONDS);
        Driver.get().get(PropertiesContainer.get("test.baseUrl"));
    }

    @AfterTest
    public void tearDown() {
        Driver.quit();
    }
}
