package Pages;

import UI.UiActions;
import org.openqa.selenium.By;

/**
 * navigate in levelSet site to assert about the product if free or not
 */
public class LandingPage {


    UiActions action = new UiActions();


    private final By createDocumentBtn = By.cssSelector("a[class='btn btn-info btn-outline mob-dropdown-btn']");
    String productLocator = "//div[text()='%s']/following-sibling::div//span[contains(text(),'%s')]";




    /**
     * click On Create Document button in home page
     *
     */
    public void clickOnCreateDocumentBtn() {


        action.waitFunction(createDocumentBtn, "waitVisibility");
        action.findElement(createDocumentBtn).actionOnElement("click");


    }

    /**
     * to get text and assert equals
     * @return
     */
    public String assertTheSearchKeywordIsDisplayed(String productName,String productStatus) {
         final By assertionValue = By.xpath(String.format(productLocator, productName,productStatus));
        action.waitFunction(assertionValue, "waitVisibility");
        return action.getTextFromLocator(assertionValue);
    }


}
