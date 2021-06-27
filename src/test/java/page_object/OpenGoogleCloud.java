package page_object;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.ArrayList;


public class OpenGoogleCloud {

    private static WebDriver driver;
    private static final By instances = By.xpath("//md-input-container/child::input[@ng-model='listingCtrl.computeServer.quantity']");
    private static final By series = By.xpath("//md-select[@name='series']/parent::md-input-container");
    private static final By seriesModel = By.xpath("//md-option[@value='n1']/div[@class='md-text ng-binding' and contains(text(),'N1')]");
    private static final By machineType = By.xpath("//label[text()='Machine type']/parent::md-input-container");
    private static final By machineModel = By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']");
    private static final By addGPUCheckBox = By.xpath("//md-checkbox[@aria-label='Add GPUs']");
    private static final By numberOfGPUs = By.xpath("//md-select[@placeholder='Number of GPUs']");
    private static final By numberOfGPUsModel = By.xpath("//md-option[@value='1' and @class='ng-scope md-ink-ripple' and @ng-disabled]");
    private static final By gpuType = By.xpath("//md-select[@placeholder='GPU type']");
    private static final By gpuTypeModel = By.xpath("//md-option[@value='NVIDIA_TESLA_V100']");
    private static final By localSsd = By.xpath("//md-select[@placeholder='Local SSD']");
    private static final By localSsdModel = By.xpath("//md-option[@value='2' and contains(@ng-repeat, 'Ssd')]");
    private static final By dataCenterLocation = By.xpath("//md-select[@placeholder='Datacenter location']");
    private static final By dataCenterLocationInFrankfurt = By.xpath("(//md-option[@value='europe-west3']/div[contains(text(),'Frankfurt')])[3]");
    private static final By committedUsage = By.xpath("//md-select[@placeholder='Committed usage']");
    private static final By oneYearUsage = By.xpath("//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='1']");
    private static final By estimateButton = By.xpath("//button[@aria-label='Add to Estimate']");
    private static final By vmClassIsRegular = By.xpath("//div[contains (text(),'VM class: regular')]");
    private static final By n1Standard8 = By.xpath("//div[contains (text(),'Instance type: n1-standard-8')]");
    private static final By regionIsFrankfurt = By.xpath("//div[contains (text(),'Region: Frankfurt')]");
    private static final By localSsdSpace2x375Gib = By.xpath("//div[contains (text(),'Total available local SSD space 2x375 GiB')]");
    private static final By commitmentTermOneYear = By.xpath("//div[contains (text(),'Commitment term: 1 Year')]");
    private static final By newFirstFrame = By.xpath("//iframe[contains(@name,'goog_')]");

    public static void openGoogleCloud(String googleCloud) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(googleCloud);
    }

    public static void searchBtn(String googleCloudCalc) {
        driver.findElement(By.xpath("//div/input")).click();
        driver.findElement(By.xpath("//div[@class='devsite-searchbox']/input")).sendKeys(googleCloudCalc);
        driver.findElement(By.xpath("//div[@class='devsite-searchbox']/input")).sendKeys(Keys.ENTER);
    }

    public static void calcClick() {
        driver.findElement(By.xpath("//div[@class='gs-title']/a[@href='https://cloud.google.com/products/calculator']")).click();
    }

    public static void sendKeyInToInstancesField(String keyForNumberOfInstances) {
        WebElement element = driver.findElement(newFirstFrame);
        driver.switchTo().frame(element);
        driver.switchTo().frame("myFrame");
        WebElement numberOfInstancesField = driver.findElement(instances);
        numberOfInstancesField.sendKeys(keyForNumberOfInstances);
    }

    public static void selectSeriesOfMachine() throws InterruptedException {
        driver.findElement(series).click();
        Thread.sleep(1000);
        driver.findElement(seriesModel).click();
    }

    public static void selectMachineType() throws InterruptedException {
        driver.findElement(machineType).click();
        Thread.sleep(1000);
        driver.findElement(machineModel).click();
    }

    public static void clickAddGpusCheckBox() {
        driver.findElement(addGPUCheckBox).click();
    }

    public static void selectNumberOfGpus() throws InterruptedException {
        driver.findElement(numberOfGPUs).click();
        Thread.sleep(1000);
        driver.findElement(numberOfGPUsModel).click();
    }

    public static void selectGpuType() throws InterruptedException {
        driver.findElement(gpuType).click();
        Thread.sleep(1000);
        driver.findElement(gpuTypeModel).click();
    }

    public static void selectLocalSsd() throws InterruptedException {
        driver.findElement(localSsd).click();
        Thread.sleep(1000);
        driver.findElement(localSsdModel).click();
    }

    public static void selectDataCenterLocation() throws InterruptedException {
        driver.findElement(dataCenterLocation).click();
        Thread.sleep(1000);
        driver.findElement(dataCenterLocationInFrankfurt).click();
    }

    public static void selectCommittedUsage() throws InterruptedException {
        driver.findElement(committedUsage).click();
        Thread.sleep(1000);
        driver.findElement(oneYearUsage).click();
    }

    public static void estimateBtn() {
        driver.findElement(estimateButton).click();
    }

    public static void checkVmClassIsRegular(String isRegular) {
        String vmIsRegular = driver.findElement(vmClassIsRegular).getAttribute("innerText");
        Assert.assertTrue(vmIsRegular.contains(isRegular));
    }

    public static void checkN1Standard8(String n1) {
        String n1St8 = driver.findElement(n1Standard8).getAttribute("innerText");
        Assert.assertTrue(n1St8.contains(n1));
    }

    public static void checkRegionIsFrankfurt(String isFrankfurt) {
        String frankfurt = driver.findElement(regionIsFrankfurt).getAttribute("innerText");
        Assert.assertTrue(frankfurt.contains(isFrankfurt));
    }

    public static void checkLocalSsdSpace2x375Gib(String localSsdSpace) {
        String ssdSpace = driver.findElement(localSsdSpace2x375Gib).getAttribute("innerText");
        Assert.assertTrue(ssdSpace.contains(localSsdSpace));
    }

    public static void checkCommitmentTermOneYear(String oneYear) {
        String commitmentTerm = driver.findElement(commitmentTermOneYear).getAttribute("innerText");
        Assert.assertTrue(commitmentTerm.contains(oneYear));
    }

    public static void checkEstimatedComponentCost(String expectedCost) {
        String estimatedCost = driver.findElement(By.xpath("//b[@class='ng-binding' and contains(text(), 'Estimated Component Cost:')]")).getAttribute("innerText");
        Assert.assertEquals(estimatedCost, expectedCost);
    }

    public static void browserTearDown() {
        driver.quit();
        driver=null;
    }

    public static void emailEstimate() {
        driver.findElement(By.xpath("//button[@aria-label='Add to Estimate']")).click();
    }

    public static void goTo10MinuteEmail() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10mail.org/");
    }

    public static void copyEmail() {
        driver.findElement(By.xpath("//span[@title='Скопировать адрес в буфер обмена']")).click();
    }

    public static void sendEmail() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        WebElement element = driver.findElement(newFirstFrame);
        driver.switchTo().frame(element);
        driver.switchTo().frame("myFrame");
        driver.findElement(By.xpath("//button[@aria-label='Email Estimate']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Keys.CONTROL+"v");
        driver.findElement(By.xpath("//button[@aria-label='Send Email']")).click();
    }

    public static void checkTotalEstimatedCost(String costInCalc) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String emailCost = driver.findElement(By.xpath("//pre[contains(text(), '1,082.77')]")).getAttribute("innerText");
        Assert.assertTrue(emailCost.contains(costInCalc));
    }
}