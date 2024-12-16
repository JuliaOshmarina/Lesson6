package tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomTestData;


public class RegistrationWithTestsFaker extends TestBase {
    String firstName,
            lastName,
            userEmail,
            gender,
            mobile,
            birthDay,
            birthMoth,
            birthYear,
            subject,
            hobby,
            uploadPicture,
            currentAddress,
            state,
            city;

    RegistrationPage registrationPage = new RegistrationPage();
    RandomTestData randomTestData = new RandomTestData();

    @BeforeEach
    void  prepareTestData() {
      firstName = randomTestData.getFirstName();
      lastName = randomTestData.getLastName();
      userEmail = randomTestData.getUserEmail();
        gender = randomTestData.getGender();
        mobile = randomTestData.getMobile();
        birthDay = randomTestData.getBirthDay();
        birthMoth = randomTestData.getBirthMoth();
        birthYear = randomTestData.getBirthYear();
        subject = randomTestData.getSubject();
        hobby = randomTestData.getHobby();
        uploadPicture = randomTestData.getUploadPicture();
        currentAddress = randomTestData.getCurrentAddress();
        state = randomTestData.getState();
        city = randomTestData.getCity();
    }


    @Test
    void registrationFullTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGenter(gender)
                .setUserNumber(mobile)
                .setDateOfBirth(birthDay,birthMoth, birthYear)
                .setSubjectsInput(subject)
                .setHobbiesWrapper(hobby)
                .setUploadPicture(uploadPicture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName);
        registrationPage.checkResult("Student Email", userEmail);
        registrationPage.checkResult("Gender", gender);
        registrationPage.checkResult("Mobile", mobile);
        registrationPage.checkResult("Date of Birth", birthDay + " "+ birthMoth+ ","+birthYear);
        registrationPage.checkResult("Subjects", subject);
        registrationPage.checkResult("Hobbies", hobby);
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
                .setGenter(gender)
                .setUserNumber(mobile)
                .submit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName);
        registrationPage.checkResult("Gender", gender);
        registrationPage.checkResult("Mobile", mobile);
    }


    @Test
    void registrationNegativLastNameTest() {
        registrationPage.openPage()
                .removeBanner()
                .setLastName(lastName)
                .setGenter(gender)
                .setUserNumber(mobile)
                .submit()
                .checkResultNegativ();
    }
}
