package sharedData.browserService;

import org.openqa.selenium.edge.EdgeOptions;

public interface BrowserServices {
    void openBrowser();

    Object prepareOptions();
}
