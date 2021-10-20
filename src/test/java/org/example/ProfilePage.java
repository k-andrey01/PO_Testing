package org.example;

import com.codeborne.selenide.Condition;
import org.mvel2.ast.Contains;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    public void goServices(){
        $(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/nav/ul/li[3]")).shouldHave(Condition.exactText("Мои сервисы")).click();
    }

    public void goProfileIcon(){
        $(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/header/div[2]/div[2]/div/div/a[1]")).click();
    }

    public void goPost(){
        $(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/header/div[2]/div[2]/div/div/div/ul/ul/li[1]")).shouldHave(Condition.text("Почта")).click();
    }
}
