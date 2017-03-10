package dominoDataLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;


/**
     * Created by parul on 3/8/2017.
     */
    public class HomePage extends dominoDataBasePage {
        public HomePage(WebDriver driver, Wait<WebDriver> wait) {
            super(null, driver, wait);

        }

        /*
        API to get page lable this is used to verify is page ha been loaded
        @returns  : Page Label
         */

        public WebElement getPageLabel(){
            return  driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/p/strong"));
        }

        /*
         API to navigate between the tabs on Home page
         @return : List of three tabs
         */
        public List<WebElement> getViewTabs(){
            return driver.findElements(By.xpath("/html/body/div[2]/header/div[1]/nav"));
        }

        /*
          API to navigate between Pages
          @return : Expected page object
          @param : For noe we have hardcoded the value ideally we should be storing the test constans in a collection
          and reading from it.
         */
        public TodoPage getFrameworkView(int frameworkRank){
           WebElement framework = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/iron-pages/div[1]/ul/li[2]"));
            Actions action = new Actions(driver);
            action.moveToElement(framework).build().perform();
            framework.click();
            return new TodoPage(driver,wait);
        }

    }


