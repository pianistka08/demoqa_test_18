package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestBase;
import utils.TestData;
import static utils.DataUtils.getDate;
import static utils.RandomUtils.*;
import java.util.Locale;

public class DemoqaWithFaker extends TestBase {
    @Test
    void practiceFormTestWithFaker() {

        Faker faker = new Faker(new Locale("en"));
        RegistrationPage registrationPage = new RegistrationPage();

        // переменные, значение которых получено с помощью Faker
        String userName = faker.name().firstName(),
            userLastName = faker.name().lastName(),
            userPhoneNumber = faker.phoneNumber().subscriberNumber(10),
            userEmail = faker.internet().emailAddress(),
            userAddress = faker.address().fullAddress();
        String userBirthday = getDate();
        // переменные, значение которых получено с помощью Random
        String userGender = getRandomValue(TestData.genderList),
            userSubject = getRandomValue(TestData.subjectList),
                userHobbies = getRandomValue(TestData.hobbiesList),
            userState = getRandomValue(TestData.stateList),
            userCity = getRandomCity(userState);

        registrationPage.openPage();
        registrationPage.setFirstName(userName);
        registrationPage.setLastName(userLastName);
        registrationPage.setUserEmail(userEmail);
        registrationPage.setUserNumber(userPhoneNumber);
        registrationPage.setGender(userGender);
        registrationPage.setUserAddress(userAddress);
        registrationPage.setUserHobbies(userHobbies);
        registrationPage.setUserSubject(userSubject);
        registrationPage.setState(userState);
        registrationPage.setCity(userCity);
        registrationPage.setUserPicture(TestData.userPicture);
        registrationPage.setUserBirthdayFromString(userBirthday);
        registrationPage.clickSubmit();

        registrationPage.modalDialog(TestData.modalDialogText);
        registrationPage.modalDialogCompare("Student Name", userName + " " + userLastName);
        registrationPage.modalDialogCompare("Student Email", userEmail);
        registrationPage.modalDialogCompare("Gender", userGender);
        registrationPage.modalDialogCompare("Mobile", userPhoneNumber);
        registrationPage.modalDialogCompare("Date of Birth", userBirthday);
        registrationPage.modalDialogCompare("Subjects", userSubject);
        registrationPage.modalDialogCompare("Hobbies", userHobbies);
        registrationPage.modalDialogCompare("Address", userAddress);
        registrationPage.modalDialogCompare("State and City", userState + " " + userCity);

        registrationPage.closeButton();
    }
}