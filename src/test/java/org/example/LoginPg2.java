package org.example;

import com.codeborne.selenide.Condition;
import org.example.ConfProperties;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPg2 {
    public void inputLogin(){
        $(By.id("passp-field-login")).shouldBe(Condition.exist).sendKeys(ConfProperties.getProperty("login"));
    }

    public void pressEnter(){
        $(By.id("passp:sign-in")).shouldBe(Condition.visible).click();
    }

    public void inputPassword(){
        $(By.id("passp-field-passwd")).shouldBe(Condition.exist).sendKeys(ConfProperties.getProperty("password"));
    }
}
