package tests;

import org.testng.annotations.Test;
import page_object.OpenGoogleCloud;


public class Hurt_Me_Plenty {

    @Test
    public void hurtMePlentyTest() throws InterruptedException{
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
        OpenGoogleCloud.checkVmClassIsRegular("regular");
        OpenGoogleCloud.checkN1Standard8("n1-standard-8");
        OpenGoogleCloud.checkLocalSsdSpace2x375Gib("2x375 GiB");
        OpenGoogleCloud.checkRegionIsFrankfurt("Frankfurt");
        OpenGoogleCloud.checkCommitmentTermOneYear("1 Year");
        OpenGoogleCloud.checkEstimatedComponentCost("Estimated Component Cost: USD 1,082.77 per 1 month");
        OpenGoogleCloud.browserTearDown();
    }

}