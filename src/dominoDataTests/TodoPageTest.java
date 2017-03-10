package dominoDataTests;

import dominoDataLib.HomePage;
import dominoDataLib.TodoPage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * Created by parul on 3/10/2017.
 */
public class TodoPageTest extends dominoDataFunctionalTestBase {

   public TodoPageTest(){

        }


        @BeforeClass
        public static  void setup() {
            String serverUrl = "http://todomvc.com/examples/angularjs/#/";
            setDriver(browserType, serverUrl, browserPath);


        }
        @Test
        public void verifyTextboxeditablefunctional() throws InterruptedException {
          //Test Setup
            TodoPage todoPage =new TodoPage(driver,wait);

         // Test Steps
            WebElement we = todoPage.getSearchText();
            we.sendKeys("Testing");
            we.sendKeys(Keys.RETURN);
            we.sendKeys("Testing345");

         // Verification
            log.info("Test Passed");
        }
}
