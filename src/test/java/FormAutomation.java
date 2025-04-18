import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FormAutomation {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver= new ChromeDriver() ;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void fillupform() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        //allow cookies
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        driver.findElement(By.id("edit-name")).sendKeys("Aisha Mim");
        driver.findElement(By.id("edit-number")).sendKeys("1234567890");
        driver.findElement(By.id("edit-email")).sendKeys("aishamim@gmail.com");
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("This is Aisha");
        //date
        driver.findElement(By.id("edit-date")).clear();
        driver.findElement(By.id("edit-date")).sendKeys("10/04/2025");

        //scroll page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        /// file upload
        WebElement fileInput = driver.findElement(By.id("edit-uploadocument-upload"));
        fileInput.sendKeys("C:\\ff.pdf");

        Thread.sleep(3000);

        //checkbox
        List<WebElement> checkbtn = driver.findElements(By.className("form-checkbox"));
        checkbtn.get(0).click();


        //button
        driver.findElement(By.id("edit-submit")).click();

        //assertion\
        String exText = "Thank you for your submission!";
        String actText = driver.findElement(By.id("block-pagetitle-2")).getText();
        Assertions.assertTrue(actText.equals(exText));
        }

    @AfterAll
    public void close() {
        driver.quit();
    }
    }






