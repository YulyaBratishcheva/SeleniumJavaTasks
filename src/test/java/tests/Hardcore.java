package tests;

import org.testng.annotations.Test;
import page_object.OpenGoogleCloud;


public class Hardcore {

    @Test
    public void hardcoreTest() throws InterruptedException{
        OpenGoogleCloud.openGoogleCloud("https://cloud.google.com/");
        OpenGoogleCloud.searchBtn("Google Cloud Platform Pricing Calculator");
        Thread.sleep(3000);
        OpenGoogleCloud.calcClick();
        Thread.sleep(3000);
        OpenGoogleCloud.sendKeyInToInstancesField("4");
        OpenGoogleCloud.selectSeriesOfMachine();
        OpenGoogleCloud.selectMachineType();
        OpenGoogleCloud.clickAddGpusCheckBox();
        OpenGoogleCloud.selectNumberOfGpus();
        OpenGoogleCloud.selectGpuType();
        OpenGoogleCloud.selectLocalSsd();
        OpenGoogleCloud.selectDataCenterLocation();
        OpenGoogleCloud.selectCommittedUsage();
        OpenGoogleCloud.estimateBtn();
        OpenGoogleCloud.emailEstimate();
        OpenGoogleCloud.goTo10MinuteEmail();
        Thread.sleep(2000);
        OpenGoogleCloud.copyEmail();
        Thread.sleep(2000);
        OpenGoogleCloud.sendEmail();
        Thread.sleep(2000);
        OpenGoogleCloud.checkTotalEstimatedCost("1,082.77");
        Thread.sleep(1000);
        OpenGoogleCloud.browserTearDown();
    }

}