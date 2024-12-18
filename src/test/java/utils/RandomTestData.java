package utils;

import com.github.javafaker.Faker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class RandomTestData {

        private final Faker faker = new Faker(new Locale("ru"));

        private String firstName,
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




        public String getFirstName() {
            firstName = faker.name().firstName();
            return firstName;
        }


        public String getLastName() {
            lastName = faker.name().lastName();
            return lastName;
         }


        public String getUserEmail() {
            userEmail = faker.internet().emailAddress(String.valueOf(Locale.ENGLISH));
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

        public long randomTimestamp = ThreadLocalRandom.current().nextLong(
            new Date(0).getTime(),
            new Date().getTime());

        public RandomTestData() {
        // Форматирование дня
        DateFormat dayFormat = new SimpleDateFormat("dd", Locale.UK);
        this.birthDay = dayFormat.format(new Date(randomTimestamp));

        // Форматирование месяца
        DateFormat monthFormat = new SimpleDateFormat("MMMM", Locale.UK);
        this.birthMonth = monthFormat.format(new Date(randomTimestamp));

        // Форматирование года
        DateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.UK);
        this.birthYear = yearFormat.format(new Date(randomTimestamp));
    }


        public String getBirthDay() {
            return birthDay;
        }

        public String getBirthMonth() {
            return birthMonth;
        }

         public String getBirthYear() {
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

    private final String[] states = new String[]{"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

    private Map<String, List<String>> citiesMap = new HashMap<>() {{
        put("NCR", List.of("Delhi", "Gurgaon", "Noida"));
        put("Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut"));
        put("Haryana", List.of("Karnal", "Panipat"));
        put("Rajasthan", List.of("Jaipur", "Jaiselmer"));
    }};

    public String getState() {
        int randomNumber = getRandomNumber(0, states.length);
        state = states[randomNumber];
        return state;
    }

    public String getCity(String state) {
        List<String> cities = citiesMap.get(state);
        if (cities != null && !cities.isEmpty()) {
            int randomNumber = getRandomNumber(0, cities.size());
            city = cities.get(randomNumber);
            return city;
        }
        return null;
    }
    private int getRandomNumber(int numberStart, int numberEnd) {
        return faker.number().numberBetween(numberStart, numberEnd);
    }
}



