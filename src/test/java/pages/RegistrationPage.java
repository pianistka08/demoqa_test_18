package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import pages.components.CalendarComponent;
import pages.components.ModalComponent;

public class RegistrationPage {

    private SelenideElement
    firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    userEmailInput = $("#userEmail"),
    userNumberInput = $("#userNumber"),
    userGenterElement = $("#genterWrapper"),
    dateOfBirthElement = $("#dateOfBirthInput"),
    yearSelectElement = $(".react-datepicker__year-select"),
    currentAddressInput = $("#currentAddress"),
    userHobbiesInput = $("#hobbiesWrapper"),
    userSubjectInput = $("#subjectsInput"),
    userState = $("#state"),
    userStateCityWrapper = $("#stateCity-wrapper"),
    userCity = $("#city"),
    userPictureElement = $("#uploadPicture"),
    submitButtonElement = $("#submit"),
    calendarElement = $("#dateOfBirthInput"),
    modalDialogElement = $(".modal-dialog"),
    titleElement = $("#example-modal-sizes-title-lg"),
    closeButton = $("#closeLargeModal");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String genter) {
        userGenterElement.$(byText(genter)).click();

        return this;
    }

    public RegistrationPage setUserAddress(String address) {
        currentAddressInput.setValue(address);

        return this;
    }

    public RegistrationPage setUserHobbies(String hobbies) {
        userHobbiesInput.$(byText(hobbies)).click();

        return this;
    }

    public RegistrationPage setUserSubject(String subject) {
        userSubjectInput.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage setState(String state) {
        userState.click();
        userStateCityWrapper.$(byText(state)).click();

        return this;
    }

    public RegistrationPage setCity(String city) {
        userCity.click();
        userStateCityWrapper.$(byText(city)).click();

        return this;
    }

    public RegistrationPage setUserPicture(String picture) {
        userPictureElement.uploadFromClasspath(picture);

        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButtonElement.click();

        return this;
    }

    public RegistrationPage setUserBirthday(String year, String month, String day) {
        calendarElement.click();
        CalendarComponent.setDate(year, month, day);

        return this;
    }

    public RegistrationPage modalDialog(String value) {
        modalDialogElement.should(appear);
        titleElement.shouldHave(text(value));

        return this;
    }

    public RegistrationPage modalDialogCompare(String key, String value) {
        ModalComponent.verifyResult(key, value);

        return this;
    }

    public RegistrationPage closeButton() {
        closeButton.click();

        return this;
    }
}