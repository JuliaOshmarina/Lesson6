package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    private SelenideElement userNameInput = $("#userName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement currentAddressInput = $("#currentAddress");
    SelenideElement permanentAddressInput = $("#permanentAddress");
    SelenideElement submitPress = $("#submit");


    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage submit() {
        submitPress.click();
        return this;
    }

    public TextBoxPage checkResult(String key, String value) {
        $("#output").$(byText(key)).shouldHave(text(value));
        return this;
    }
}