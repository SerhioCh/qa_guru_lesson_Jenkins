package qa.guru.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import qa.guru.pages.RegistrationFormPage;

import static io.qameta.allure.Allure.step;


public class RegistrationFormWithPageObjectsTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @Test
    void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            registrationFormPage.openPage();
        });
        step("Заполняем поля валидными данными", () -> {
            registrationFormPage.setFirstName("Serega")
                    .setLastName("Romanovich")
                    .setEmail("Serega@romanovich.com")
                    .setGender("Other")
                    .setNumber("1234567890")
                    .setBirthDate("30", "July", "2008")
                    .setSubjects("Math")
                    .setHobbiesInTheCheckbox("Sports");
            registrationFormPage.uploadFile("img1.png")
                    .setCurrentAddress("Some address 1")
                    .setStateOnTheSelect("NCR")
                    .setCityOnTheSelect("Delhi");
        });

        step("Кликнуть по кнопке Submit", () -> {
            registrationFormPage.clickOnButtonSubmit();
        });
        step("Сопоставление заполненых полей с таблицей", () -> {
            registrationFormPage.checkResultsTableVisible()
                    .checkResult("Student Name", "Serega" + " " + "Romanovich")
                    .checkResult("Student Email", "Serega@romanovich.com")
                    .checkResult("Gender", "Other")
                    .checkResult("Mobile", "1234567890")
                    .checkResult("Date of Birth", "30" + " " + "July,2008")
                    .checkResult("Subjects", "Maths")
                    .checkResult("Hobbies", "Sports")
                    .checkResult("Picture", "img1.png")
                    .checkResult("Address", "Some" + " " + "address" + " " + "1")
                    .checkResult("State and City", "NCR" + " " + "Delhi");
        });

    }
    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebTest steps = new WebTest();

        steps.openMainPage();
        steps.fillForm();
        steps.clickOnButton();
        steps.checkResults();

    }
}
