package SmartLife;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;


public class TestSmartLifeCreateEvent {

    @Test
    public void CreateEvent() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/windows10/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();

        driver.get("https://smartlifepath-client-qa.herokuapp.com/web-site/home");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/app-root/section/app-slp-website/section/app-home/div/div/section[1]/div/div[2]/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/form/div[1]/div/mat-form-field/div/div[1]/div[3]/input")));
        driver.findElement(By.xpath("/html/body/app-root/section/app-slp-website/section/app-home/div/div/section[1]/div/div[2]/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/form/div[1]/div/mat-form-field/div/div[1]/div[3]/input")).sendKeys("polezniybess@gmail.com"); // enter Email
        driver.findElement(By.xpath("/html/body/app-root/section/app-slp-website/section/app-home/div/div/section[1]/div/div[2]/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/form/div[2]/div/mat-form-field/div/div[1]/div[3]/input")).sendKeys("Qwerty"); // enter password
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/app-root/section/app-slp-website/section/app-home/div/div/section[1]/div/div[2]/div[2]/div/mat-tab-group/div/mat-tab-body[1]/div/form/div[3]/div/button/span")).click(); // click to Login button

        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/app-root/section/app-slp-platform/section/app-slp-my-stream/div/slp-user-menu/div[2]/slp-avatar/div")));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(text(),'Create')]")).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Event')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Event')]")).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'images']/div[contains(@style, 'charity')]"))); //add image
        driver.findElement(By.xpath("//div[@class = 'images']/div[contains(@style, 'charity')]")).click(); //logo
        Thread.sleep(1500);

        driver.findElement(By.xpath("//*[@id = 'mat-button-toggle-2']")).click(); //public button
        Thread.sleep(1500);

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/mat-dialog-container/slp-create-event-new-dialog/div/mat-horizontal-stepper/div[2]/div[1]/form/mat-form-field[1]/div/div[1]/div[3]/input")).sendKeys("Autotest Event"); //Name of Event
        Thread.sleep(1500);

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/mat-dialog-container/slp-create-event-new-dialog/div/mat-horizontal-stepper/div[2]/div[1]/form/div[3]/div[3]/mat-form-field/div/div[1]/div[3]/mat-select/div/div[2]/div")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"mat-option-18\"]/span")).click(); //select education category
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/mat-dialog-container/slp-create-event-new-dialog/div/mat-horizontal-stepper/div[2]/div[1]/form/mat-form-field[2]/div/div[1]/div[3]/textarea")).sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."); //description
        Thread.sleep(1000);

        WebElement element = driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-0\"]/form/div[5]/button/span")); //click to Next button
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/mat-dialog-container/slp-create-event-new-dialog/div/mat-horizontal-stepper/div[2]/div[2]/form/div[2]/div[3]/mat-checkbox/label/div")).click(); //online event checkbox
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/mat-dialog-container/slp-create-event-new-dialog/div/mat-horizontal-stepper/div[2]/div[2]/form/div[7]/button[2]/span")).click(); //Next button

        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/mat-dialog-container/slp-create-event-new-dialog/div/mat-horizontal-stepper/div[2]/div[3]/div[4]/button[2]")).click(); //Next button

        Thread.sleep(1000);
        WebElement element1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/mat-dialog-container/slp-create-event-new-dialog/div/mat-horizontal-stepper/div[2]/div[4]/div[3]/button[2]/span")); //click to Next button
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element1);

        Thread.sleep(2000);

        assertTrue(driver.findElement(By.cssSelector(".title")).getText().contains("Autotest Event Community")); //check name of event

        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/app-root/section/app-slp-platform/section/app-event/div/div/div/div/div[2]/div[1]/span/button[2]/span")).click(); //delete event
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"mat-dialog-1\"]/slp-confirm-dialog/slp-dialog-wrapper/div[2]/div[2]/button[2]/span")).click();

        driver.quit();

    }
}
