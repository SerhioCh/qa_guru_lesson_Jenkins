package qa.guru.tests;

import io.qameta.allure.Step;
import qa.guru.pages.RegistrationFormPage;

public class WebTest {
RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @Step("Открываем главную страницу")
     public  void  openMainPage () { registrationFormPage.openPage();
    }

    @Step ("Заполняем поля валидными данными")
            public void fillForm () {
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
    }

    @Step ("Кликнуть по кнопке Submit")
            public  void  clickOnButton() {
        registrationFormPage.clickOnButtonSubmit();
    }
    @Step ("Сопоставление заполненых полей с таблицей")
            public void  checkResults(){
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
    }
}
