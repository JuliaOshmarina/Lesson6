package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;



public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void TestRegistrationFull() {
        registrationPage.openPage()
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
    void TestRegistrationMin() {
        registrationPage.openPage()
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
    void TestRegistrationNegativLastName() {
        registrationPage.openPage()
                .setLastName("Oshmarina")
                .setGenter("Male")
                .setUserNumber("4544263545")
                .submit()
                .checkResultNegativ();
    }
}
