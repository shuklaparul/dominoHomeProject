package dominoDataTests;

import dominoDataLib.HomePage;
import dominoDataLib.TodoPage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by parul on 3/8/2017.
 */
public class HomePageTest extends dominoDataFunctionalTestBase {

    @BeforeClass
    public static void setup() {
        String serverUrl = "http://todomvc.com/";

        setDriver(browserType, serverUrl, browserPath);
    }

    @Test
    public void verifyHomepageisLoaded() throws InterruptedException {
        // Test Set up
        HomePage homepage = new HomePage(driver, wait);

        // Test Steps
        String pageLabel = homepage.getPageLabel().getText();

        // Verification
        verifyEquals(pageLabel, "TodoMVC", "Values verified");
        List<WebElement> getTabs = homepage.getViewTabs();
        ArrayList<String> actualValues = new ArrayList<>();
        actualValues.add("Download");
        actualValues.add("View on GitHub");
        actualValues.add("Blog");
        int i = 0;
        for (WebElement e : getTabs) {
            verifyEquals(e.getText(), actualValues.get((actualValues.size() - 1) - i), "Verified correct");
            i++;
        }
    }

    @Test
      public void verifyLinksnavigatetorespectiveTodoPage(){
        // Test Setup
        HomePage homePage = new HomePage(driver,wait);
        String frameworkType = "angularjs";

        //Test Steps
        TodoPage todoPage =  homePage.getFrameworkView(2);
        String newPageUrl = driver.getCurrentUrl();

       // Verification
       verifyEquals(newPageUrl,"http://todomvc.com/examples/"+frameworkType+"/#/","Page verified");
    }
}


