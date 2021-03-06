package maventest;


import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Retry;

public class ExternalPropertyTest {

    @Test(retryAnalyzer = Retry.class)
    public void browserPropertyTest() {
        String externalProperty = System.getProperty("browser");
        Assert.assertEquals(externalProperty, "CHROME");
    }

}
