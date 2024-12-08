package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName");
            SelenideElement lastNameInput = $("#lastName");
            SelenideElement userEmailInput = $("#userEmail");
            SelenideElement genterWrapper = $("#genterWrapper");
            SelenideElement userNumberInput = $("#userNumber");
            SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
            SelenideElement subjectsInput = $("#subjectsInput");
            SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
            SelenideElement uploadPicture = $("#uploadPicture");
            SelenideElement currentAddressInput = $("#currentAddress");
            SelenideElement stateWrapper = $("#state");
            SelenideElement stateDropdown = $("#stateCity-wrapper");
            SelenideElement cityWrapper = $("#city");
            SelenideElement cityDropdown = $("#stateCity-wrapper");
            SelenideElement submitPress = $("#submit");

            CalendarComponent calendarComponent = new CalendarComponent();
            TableComponent tableComponent = new TableComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGenter(String value) {
        genterWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbiesWrapper(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateWrapper.click();
        stateDropdown.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityWrapper.click();
        cityDropdown.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submit () {
        submitPress.click();
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        tableComponent.checkResultTest(key, value);
        return this;
    }

    public RegistrationPage checkResultNegativ() {
        firstNameInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

}
