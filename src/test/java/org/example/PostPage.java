package org.example;

import com.codeborne.selenide.WebDriverRunner;

public class PostPage {
    public boolean atPage()
    {
        return (WebDriverRunner.url().contains(ConfProperties.getProperty("postURL")));
    }
}
