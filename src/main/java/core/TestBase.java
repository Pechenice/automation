package core;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    @BeforeTest
    public void setUp() {
        Driver.init();
    }

    @AfterTest
    public void tearDown() {
        Driver.quit();
    }
}
