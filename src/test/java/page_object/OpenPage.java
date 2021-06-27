package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class OpenPage {

    private static WebDriver driver;

    public static void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void browserTearDown() {
        driver.quit();
        driver=null;
    }

    public static void helloWebDriver(String newPaste) {
        driver.findElement(By.id("postform-text")).sendKeys(newPaste);
    }

    public static void bashCode(String bash) {
        driver.findElement(By.id("postform-text")).sendKeys(bash);
    }

    public static void syntaxBash() {
        driver.findElement(By.id("select2-postform-format-container")).click();
        driver.findElement(By.xpath("(//*[contains(@class, 'select2-results__option') and text() = 'Bash'])[1]")).click();
    }

    public static void syntaxOk(String expectedText) {
        String actualText = driver.findElement(By.xpath("//div[@class='left']/a[text()='Bash']")).getAttribute("innerText");
        Assert.assertEquals(actualText, expectedText);
    }

    public static void titleICanWin(String title) {
        driver.findElement(By.name("PostForm[name]")).sendKeys(title);
    }

    public static void titleBringItOn(String title) {
        driver.findElement(By.name("PostForm[name]")).sendKeys(title);
    }

    public static void pasteExpiration() {
        driver.findElement(By.id("select2-postform-expiration-container")).click();
        driver.findElement(By.xpath("//li[contains(@id,'10M')]")).click();
    }

    public static void createNewPaste(String webTitle) throws InterruptedException {
        driver.findElement(By.xpath("//button[text()='Create New Paste']")).click();
        Thread.sleep(1000);
        String title = driver.getTitle();
        Assert.assertTrue(title.contains(webTitle));
    }

    public static void openPastebin(String baseURL) {
        driver.get(baseURL);
    }

    public static void equalsCode(String expectedText) {
        String actualText = driver.findElement(By.xpath("//textarea[@class='textarea']")).getAttribute("value");
        Assert.assertEquals(actualText, expectedText);
    }

}