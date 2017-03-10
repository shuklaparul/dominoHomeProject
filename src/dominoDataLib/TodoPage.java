package dominoDataLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;


/**
 * Created by parul on 3/8/2017.
 */
public class TodoPage extends dominoDataBasePage {
    public TodoPage(WebDriver driver, Wait<WebDriver> wait) {
        super(null, driver, wait);

    }

    /*
     @return : Returns text webelement
     */

    public WebElement getSearchText() {
        return driver.findElement(By.xpath("//*[@id='new-todo']"));
    }
}
