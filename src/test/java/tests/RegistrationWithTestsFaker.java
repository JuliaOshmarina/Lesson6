package tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomTestData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class RegistrationWithTestsFaker extends TestBase {
    String firstName,
            lastName,
            userEmail,
            gender,
            mobile,
            birthDay,
            birthMonth,
            birthYear,
            subject,
            hobby,
            uploadPicture,
            currentAddress,
            state,
            city;

    RegistrationPage registrationPage = new RegistrationPage();
    RandomTestData randomTestData = new RandomTestData();
    DateFormat dateFormat = new SimpleDateFormat("dd MMMMM,yyyy", Locale.UK);
    String timeToDay = dateFormat.format(new Date());

    @BeforeEach
    void  prepareTestData() {
      firstName = randomTestData.getFirstName();
      lastName = randomTestData.getLastName();
      userEmail = randomTestData.getUserEmail();
        gender = randomTestData.getGender();
        mobile = randomTestData.getMobile();
        birthDay = randomTestData.getBirthDay();
        birthMonth = randomTestData.getBirthMonth();
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
                .setDateOfBirth(birthDay,birthMonth, birthYear)
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
        registrationPage.checkResult("Date of Birth",birthDay + " "+ birthMonth+ ","+birthYear);
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
