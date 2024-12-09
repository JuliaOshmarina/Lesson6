package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;



public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void registrationFullTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Julia")
                .setLastName("Oshmarina")
                .setUserEmail("juffgdfgd@gmail.com")
                .setGenter("Male")
                .setUserNumber("4544263545")
                .setDateOfBirth("18", "April", "2001")
                .setSubjectsInput("English")
                .setHobbiesWrapper("Sports")
                .setUploadPicture("test.jpg")
                .setCurrentAddress("Russia")
                .setState("Rajasthan")
                .setCity("Jaiselmer")
                .submit();

        registrationPage.checkResult("Student Name", "Julia Oshmarina");
        registrationPage.checkResult("Student Email", "juffgdfgd@gmail.com");
        registrationPage.checkResult("Gender", "Male");
        registrationPage.checkResult("Mobile", "4544263545");
        registrationPage.checkResult("Date of Birth", "18 April,2001");
        registrationPage.checkResult("Subjects", "English");
        registrationPage.checkResult("Hobbies", "Sports");
        registrationPage.checkResult("Picture", "test.jpg");
        registrationPage.checkResult("Address", "Russia");
        registrationPage.checkResult("State and City", "Rajasthan Jaiselmer");
    }

    @Test
    void registrationMinTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Julia")
                .setLastName("Oshmarina")
                .setGenter("Male")
                .setUserNumber("4544263545")
                .submit();

        registrationPage.checkResult("Student Name", "Julia Oshmarina");
        registrationPage.checkResult("Gender", "Male");
        registrationPage.checkResult("Mobile", "4544263545");
    }


    @Test
    void registrationNegativLastNameTest() {
        registrationPage.openPage()
                .removeBanner()
                .setLastName("Oshmarina")
                .setGenter("Male")
                .setUserNumber("4544263545")
                .submit()
                .checkResultNegativ();
    }
}
