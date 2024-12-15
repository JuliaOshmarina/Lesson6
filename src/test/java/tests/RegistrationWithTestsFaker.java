package tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utills.RandomTestDate;


public class RegistrationWithTestsFaker extends TestBase {
    String firstName,
            lastName,
            userEmail,
            genter,
            userNumber,
            birthOfDay,
            birthOfMoth,
            birthOfYear,
            subjectsInput,
            hobbiesWrapper,
            uploadPicture,
            currentAddress,
            state,
            city;

    RegistrationPage registrationPage = new RegistrationPage();
    RandomTestDate randomTestDate = new RandomTestDate();

    @BeforeEach
    void  prepareTestData() {
      firstName = randomTestDate.getFirstName();
      lastName = randomTestDate.getLastName();
      userEmail = randomTestDate.getUserEmail();
        genter = randomTestDate.getGenter();
        userNumber = randomTestDate.getUserNumber();
        birthOfDay = randomTestDate.getBirthOfDay();
        birthOfMoth = randomTestDate.getBirthOfMoth();
        birthOfYear = randomTestDate.getBirthOfYear();
        subjectsInput = randomTestDate.getSubjectsInput();
        hobbiesWrapper = randomTestDate.getHobbiesWrapper();
        uploadPicture = randomTestDate.getUploadPicture();
        currentAddress = randomTestDate.getCurrentAddress();
        state = randomTestDate.getState();
        city = randomTestDate.getCity();
    }


    @Test
    void registrationFullTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGenter(genter)
                .setUserNumber(userNumber)
                .setDateOfBirth(birthOfDay,birthOfMoth, birthOfYear)
                .setSubjectsInput(subjectsInput)
                .setHobbiesWrapper(hobbiesWrapper)
                .setUploadPicture(uploadPicture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName);
        registrationPage.checkResult("Student Email", userEmail);
        registrationPage.checkResult("Gender", genter);
        registrationPage.checkResult("Mobile", userNumber);
        registrationPage.checkResult("Date of Birth", birthOfDay + " "+ birthOfMoth+ ","+birthOfYear);
        registrationPage.checkResult("Subjects", subjectsInput);
        registrationPage.checkResult("Hobbies", hobbiesWrapper);
        registrationPage.checkResult("Picture", uploadPicture);
        registrationPage.checkResult("Address", currentAddress);
        registrationPage.checkResult("State and City", state + " " + city);
    }

    @Test
    void registrationMinTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGenter(genter)
                .setUserNumber(userNumber)
                .submit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName);
        registrationPage.checkResult("Gender", genter);
        registrationPage.checkResult("Mobile", userNumber);
    }


    @Test
    void registrationNegativLastNameTest() {
        registrationPage.openPage()
                .removeBanner()
                .setLastName(lastName)
                .setGenter(genter)
                .setUserNumber(userNumber)
                .submit()
                .checkResultNegativ();
    }
}
