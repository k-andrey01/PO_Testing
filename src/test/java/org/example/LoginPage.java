package org.example;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    @Step
    public void LogIn(){
        $(By.id("passp-field-login")).shouldBe(Condition.exist).sendKeys(ConfProperties.getProperty("login"));
        $(By.id("passp:sign-in")).shouldBe(Condition.visible).click();
        $(By.id("passp-field-passwd")).shouldBe(Condition.exist).sendKeys(ConfProperties.getProperty("password"));
        $(By.id("passp:sign-in")).shouldBe(Condition.visible).click();
    }

//    public void pressEnter(){
//        $(By.id("passp:sign-in")).shouldBe(Condition.visible).click();
//    }
//
//    public void inputPassword(String pass){
//        $(By.id("passp-field-passwd")).shouldBe(Condition.exist).sendKeys(pass);
//    }
}
