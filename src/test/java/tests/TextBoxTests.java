package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;



public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void TextBoxTest() {
        textBoxPage.openPage()
                .removeBanner()
                .setUserName("Alex")
                .setUserEmail("alex@egorov.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .submit();

        textBoxPage.checkResult("Name:", "Alex");
        textBoxPage.checkResult("Email:", "alex@egorov.com");
        textBoxPage.checkResult("Current Address :", "Some street 1");
        textBoxPage.checkResult("Permananet Address :", "Another street 1");

    }
}