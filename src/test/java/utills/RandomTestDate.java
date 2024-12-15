package utills;

import com.github.javafaker.Faker;

import java.util.Locale;



public class RandomTestDate {

        private final Faker faker = new Faker(new Locale("ru"));

        private String firstName,
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


         public String getGenter() {
            genter = faker.options().option("Male","Female","Other");
            return genter;
         }

         public String getUserNumber() {
             userNumber = faker.phoneNumber().subscriberNumber(10);
             return userNumber;
        }

        public String getBirthOfDay() {
            birthOfDay = String.valueOf(faker.number().numberBetween(4,28));
            return birthOfDay;
        }

        public String getBirthOfMoth() {
            birthOfMoth = faker.options().option("January","February","March","April","May","June", "July", "August", "September", "October", "November", "December");
            return birthOfMoth;
        }

         public String getBirthOfYear() {
             birthOfYear = String.valueOf(faker.number().numberBetween(1994,2023));
             return birthOfYear;
        }

        public String getSubjectsInput() {
            subjectsInput = faker.options().option("English","Chemistry","Arts","Accounting");
            return subjectsInput;
    }

         public String getHobbiesWrapper() {
             hobbiesWrapper = faker.options().option("Sports","Reading","Music");
             return hobbiesWrapper;
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
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return city;
        }
    }

}



