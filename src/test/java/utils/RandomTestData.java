package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;



public class RandomTestData {

        private final Faker faker = new Faker(new Locale("ru"));

        private String firstName,
                lastName,
                userEmail,
                gender,
                mobile,
                birthDay = String.valueOf(new SimpleDateFormat("dd", Locale.UK)),
                birthMoth,
                birthYear,
                subject,
                hobby,
                uploadPicture,
                currentAddress,
                state,
                city;



        public String getFirstName() {
            firstName = faker.name().firstName();
            return firstName;
        }


        public String getLastName() {
            lastName = faker.name().lastName();
            return lastName;
         }


        public String getUserEmail() {
            Faker faker = new Faker(new Locale("en-US"));
            userEmail = faker.internet().emailAddress();
            return userEmail;
         }


         public String getGender() {
            gender = faker.options().option("Male","Female","Other");
            return gender;
         }

         public String getMobile() {
             mobile = faker.phoneNumber().subscriberNumber(10);
             return mobile;
        }

        public String getBirthDay() {
            birthDay = String.valueOf(faker.number().numberBetween(4,28));
            return birthDay;
        }

        public String getBirthMoth() {
            birthMoth = faker.options().option("January","February","March","April","May","June", "July", "August", "September", "October", "November", "December");
            return birthMoth;
        }

         public String getBirthYear() {
             birthYear = String.valueOf(faker.number().numberBetween(1994,2023));
             return birthYear;
        }

        public String getSubject() {
            subject = faker.options().option("English","Chemistry","Arts","Accounting");
            return subject;
    }

         public String getHobby() {
             hobby = faker.options().option("Sports","Reading","Music");
             return hobby;
    }

    public String getUploadPicture() {
        uploadPicture = faker.options().option("test.jpg","test2.jpg");
        return uploadPicture;
    }

    public String getCurrentAddress() {
        currentAddress = faker.address().streetAddress();
        return currentAddress;
    }

    public String getState() {
        state = faker.options().option("NCR","Uttar Pradesh","Haryana","Rajasthan");
        return state;
    }

    public String getCity() {
        switch (state) {
            case "NCR":
                return city = faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return city = faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return city =  faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return city =  faker.options().option("Jaipur", "Jaiselmer");
            default:
                return null;
        }
    }

}



