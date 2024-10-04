import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {

    @Test
    public void testGoogleTitle() throws MalformedURLException {
        // Use ChromeOptions for browser settings
        ChromeOptions options = new ChromeOptions();

        // Get Selenium Remote URL from environment (GitHub Actions will set this)
        String seleniumUrl = System.getenv("SELENIUM_REMOTE_URL");

        // Set up WebDriver with remote URL
        WebDriver driver = new RemoteWebDriver(new URL(seleniumUrl), options);
        
        // Open Google and check the title
        driver.get("https://www.google.com");
        assertEquals("Google", driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
