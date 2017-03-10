package dominoDataLib;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Wait;


/**
 * Created by parul on 3/8/2017.
 */

/**
     * Base page for all the pages on App.
     *
     * @author shukla.parul@gmail.com
     */

    public class dominoDataBasePage {
    protected WebDriver driver;
    protected final Wait<WebDriver> wait;
    protected final WebElement element;

    /**
     * Constructor for all components.
     *
     * @param element the root element of the component
     * @param driver  the driver
     * @param wait    the wait
     */
    public dominoDataBasePage(WebElement element, WebDriver driver, Wait<WebDriver> wait) {
        this.driver = driver;
        this.wait = wait;
        this.element = element;

    }

    /**
     * @return the element
     */
    public WebElement getElement() {

        return element;
    }

    /**
     * @return the driver
     */
    protected WebDriver getDriver() {
        return driver;
    }

    /**
     * @return the wait
     */
    protected Wait<WebDriver> getWait() {
        return wait;
    }


}


