package Moduls.ScreenShotModul;

import UI.UiActions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * take screenShots if needed whatever the step in test
 */
public class ScreenShotFromSelenium {

    /**
     * take screenShot with png format
     * @param screenshotName
     * @throws IOException
     */
    public static void takeScreenShots(String screenshotName) throws IOException {
        Path path = Paths.get(".//ScreenShot//", screenshotName + ".png");
        try {
            FileOutputStream output = new FileOutputStream(path.toString());
            Files.createDirectories(path.getParent());

            output.write(((TakesScreenshot) UiActions.driver).getScreenshotAs(OutputType.BYTES));
            output.close();

        } catch (IOException e) {
            System.out.println("cant't take screenshot" + e.getMessage());
        }


    }
}






