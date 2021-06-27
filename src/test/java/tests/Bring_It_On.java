package tests;

import org.testng.annotations.Test;
import page_object.OpenPage;

public class Bring_It_On {

    @Test
    public void Test() throws InterruptedException {
        OpenPage.browserSetup();
        OpenPage.openPastebin("https://pastebin.com");
        OpenPage.bashCode("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");
        OpenPage.titleBringItOn("how to gain dominance among developers");
        OpenPage.syntaxBash();
        OpenPage.pasteExpiration();
        OpenPage.createNewPaste("how to gain dominance among developers");
        OpenPage.syntaxOk("Bash");
        OpenPage.equalsCode("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");
        OpenPage.browserTearDown();
    }

}