package tests;

import org.testng.annotations.Test;
import page_object.OpenPage;


public class I_Can_Win {

    @Test
    public void Test() throws InterruptedException{
        OpenPage.browserSetup();
        OpenPage.openPastebin("https://pastebin.com");
        OpenPage.helloWebDriver("Hello from WebDriver");
        OpenPage.titleICanWin("helloWeb");
        OpenPage.pasteExpiration();
        OpenPage.createNewPaste("helloWeb");
        Thread.sleep(2000);
        OpenPage.browserTearDown();
    }

}