package core;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    @BeforeTest
    public void setUp() {
        Driver.init();
        Driver.get().get(PropertiesContainer.get("test.baseUrl"));
    }

    @AfterTest
    public void tearDown() {
        Driver.quit();
    }
}
