package LevelSetTests;

import Moduls.FilesReaders.ExcelFileReader;
import Pages.LandingPage;
import UI.UiActions;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

/**
 * test scenario to validate if having only one not free product
 */
public class TestScenario extends BaseClass {

    LandingPage landingPage = new LandingPage(); //Instantiation of LandPage object


    /**
     * <p> Test Scenario </p>
     * <p> Step.1) Open Url </p>
     * <p> Step.2) Click to create document button  </p>
     * <p> Step.3) Validate if having only one not free product </p>
     * <p> Step.4) Close the browser window </p>
     */
    @Attachment(value = "Screenshot", type = "image/png")
    @Test(dataProvider = "LocatorValue")
    public void test_havingOnlyOneNotFree(String value,String status) {


        landingPage.clickOnCreateDocumentBtn();


        Allure.addAttachment("Page Screenshot",
                new ByteArrayInputStream(((TakesScreenshot) UiActions.driver).getScreenshotAs(OutputType.BYTES)));

        Assert.assertEquals(landingPage.assertTheSearchKeywordIsDisplayed(value,status), "$349");

    }


    /**
     * to get test data from excel file (external file )
     *
     * @return test data of test
     */

    @DataProvider(name = "LocatorValue")
    Object[][] getDataFromExcel() {
        Object[][] data = ExcelFileReader.excelReader("src\\test\\resources\\DataDriven\\testingData.xlsx");
        return data;
    }
}


