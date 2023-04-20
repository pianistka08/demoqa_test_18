package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class DemoqaTestPageObject extends TestBase {

    @Test
    void practiceFormTest() {
        RegistrationPage registrationPage = new RegistrationPage();
        String userName = "Marina";
        String userLastName = "Ivanova";
        String userPhoneNumber = "9995554499";
        String userEmail = "marinaivanova@mail.ru";
        String userAddress = "High Road 33";
        String userGender = "Female";
        String userDay = "30";
        String userMonth = "October";
        String userYear = "1990";
        String userSubject = "English";
        String userHobbies = "Music";
        String userState = "NCR";
        String userCity = "Delhi";
        String userPicture = "img/1.jpg";
        String modalDialogText = "Thanks for submitting the form";

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
        registrationPage.setUserPicture(userPicture);
        registrationPage.setUserBirthday(userYear, userMonth, userDay);
        registrationPage.clickSubmit();

        registrationPage.modalDialog(modalDialogText);
        registrationPage.modalDialogCompare("Student Name", userName + " " + userLastName);
        registrationPage.modalDialogCompare("Student Email", userEmail);
        registrationPage.modalDialogCompare("Gender", userGender);
        registrationPage.modalDialogCompare("Mobile", userPhoneNumber);
        registrationPage.modalDialogCompare("Date of Birth", userDay + " " + userMonth + "," + userYear);
        registrationPage.modalDialogCompare("Subjects", userSubject);
        registrationPage.modalDialogCompare("Hobbies", userHobbies);
        registrationPage.modalDialogCompare("Address", userAddress);
        registrationPage.modalDialogCompare("State and City", userState + " " + userCity);

        registrationPage.closeButton();
    }
}