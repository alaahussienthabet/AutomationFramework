package UI;

import Moduls.Utilities.HandleExceptions;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UiActions {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private WebElement element;
    private List<WebElement> elements;


    /**
     * wait for element
     *
     * @param path
     * @param typOfWait
     */
    public void waitFunction(By path, String typOfWait) {
        try {
            switch (typOfWait) {
                case "waitVisibility":

                    wait.until(ExpectedConditions.visibilityOfElementLocated(path));
                    break;
                case "waitClick":
                    wait.until(ExpectedConditions.elementToBeClickable(path));
                    break;
            }
        } catch (ElementNotVisibleException e) {
            HandleExceptions.ElementNotVisibleExceptionHandling(e);
        } catch (ElementNotInteractableException e) {
            HandleExceptions.ElementNotInteractableExceptionHandling(e);
        } catch (TimeoutException e) {
            HandleExceptions.TimeoutExceptionHandling(e);
        }
    }

    /**
     * wait to specific time
     *
     * @param time
     */

    public void waitFunction(int time) {
        try {


            driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            HandleExceptions.TimeoutExceptionHandling(e);
        }
    }

    /**
     * to find element and return it
     *
     * @param path
     * @return
     */
    public UiActions findElement(By path) {

        try {

            element = driver.findElement(path);
        } catch (InvalidSelectorException e) {
            HandleExceptions.InvalidSelectorExceptionHandling(e);
        } catch (NoSuchElementException e) {
            HandleExceptions.NoSuchElementExceptionHandling(e);
        } catch (NullPointerException e) {
            HandleExceptions.NullPointerExceptionHandling(e);
        } catch (ElementNotVisibleException e) {
            HandleExceptions.ElementNotVisibleExceptionHandling(e);
        }
        return this;

    }

    /**
     * Find List of Elements
     *
     * @param path
     * @return
     */
    public UiActions findListOfElements(By path) {
        try {
            elements = driver.findElements(path);
        } catch (InvalidSelectorException e) {
            HandleExceptions.InvalidSelectorExceptionHandling(e);
        } catch (NoSuchElementException e) {
            HandleExceptions.NoSuchElementExceptionHandling(e);
        } catch (NullPointerException e) {
            HandleExceptions.NullPointerExceptionHandling(e);
        } catch (ElementNotVisibleException e) {
            HandleExceptions.ElementNotVisibleExceptionHandling(e);
        }
        return this;
    }

    /**
     * Get Size for list of elements have the same path
     *
     * @return elements size
     */
    public int getSizeOfElements() {
        return elements.size();
    }

    /**
     * to send value in specific element
     *
     * @param text
     * @return
     */
    public UiActions sendKeyToElement(String text) {
        try {
            element.sendKeys(text);
        } catch (NullPointerException e) {
            HandleExceptions.NullPointerExceptionHandling(e);
        } catch (NoSuchElementException e) {
            HandleExceptions.NoSuchElementExceptionHandling(e);
        }
        return this;

    }

    /**
     * to make actions on element
     *
     * @param action
     */

    public void actionOnElement(String action) {
        try {
            switch (action) {
                case "submit":
                    element.submit();
                    break;
                case "click":
                    element.click();
                    break;
                case "openNewTab":
                    Actions builder = new Actions(driver);
                    Action openLinkInNewTab = builder
                            .sendKeys(element, Keys.CONTROL).clickAndHold().keyUp(element, Keys.CONTROL)
                            .build();
                    openLinkInNewTab.perform();
                    builder.sendKeys(Keys.CONTROL + "\t").click(element).build().perform();
                    break;
                case "enter":
                    element.sendKeys(Keys.ENTER);
            }
        } catch (NullPointerException e) {
            HandleExceptions.NullPointerExceptionHandling(e);
        } catch (ElementNotInteractableException e) {
            HandleExceptions.ElementNotInteractableExceptionHandling(e);
        }
    }

    /**
     * Handle scroll Down action on the browser
     */
    public void scrollDownToBottom() {
        try {
            JavascriptExecutor scroll = (JavascriptExecutor) driver;
            scroll.executeScript("window.scrollTo(0,1800);");
        } catch (ElementNotVisibleException e) {
            HandleExceptions.ElementNotVisibleExceptionHandling(e);
        } catch (ElementNotInteractableException e) {
            HandleExceptions.ElementNotInteractableExceptionHandling(e);
        } catch (TimeoutException e) {
            HandleExceptions.TimeoutExceptionHandling(e);
        }
    }

    /**
     * to make true or false assertion about specific value
     *
     * @return
     */
    public boolean assertTrue(By assertionValue) {
        return UiActions.driver.findElement(assertionValue).isDisplayed();
    }

    /**
     * to get the text in specific locator
     *
     * @param textLocator
     * @return
     */
    public String getTextFromLocator(By textLocator) {
        String text = "";
        try {
            text = UiActions.driver.findElement(textLocator).getText();

        } catch (ElementNotVisibleException e) {
            HandleExceptions.ElementNotVisibleExceptionHandling(e);

        } catch (TimeoutException e) {
            HandleExceptions.TimeoutExceptionHandling(e);
        }

        return text;
    }


}
