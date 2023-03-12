import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTest {

    @BeforeAll
    static void beforeAll() {
        open("https://demoqa.com/automation-practice-form");
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    @Test
    void practiceFormTest() {
        String userName = "Marina";
        String userLastName = "Ivanova";
        String userPhoneNumber = "9995554499";
        String userEmail = "marinaivanova@mail.ru";
        String userAddress = "High Road 33";

        $("#firstName").setValue(userName);
        $("#lastName").setValue(userLastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue(userPhoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.jpg");
        $("#currentAddress").setValue(userAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text(userLastName),
                text(userEmail), text(userPhoneNumber));
    }
}