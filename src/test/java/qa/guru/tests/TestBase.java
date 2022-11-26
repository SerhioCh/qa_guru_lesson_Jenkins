package qa.guru.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.guru.helpers.Attach;

public class TestBase {

    @BeforeAll
    static void configure() {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.baseUrl = "https://demoqa.com";

        Configuration.browserCapabilities = capabilities;
        Configuration.browser = System.getProperty("browser");
        Configuration.browserVersion = System.getProperty("version");
        Configuration.browserSize = System.getProperty("windowSize");
        Configuration.remote = System.getProperty("remote");
        if (System.getProperty("remote") != null) {
            Configuration.remote = System.getProperty("remote");
        }
    }


    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

}
