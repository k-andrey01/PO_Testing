Feature: Открытие страниц на "passport.yandex.ru"
  Scenario: Открыть "Мои сервичы"
    Given Открыть passport.yandex.ru
    When Ввести в поле "Телефон или почта" текст
    And Нажать на кнопку "Войти"
    And Ввести в поле "Введите пароль" текст
    And Нажать на кнопку "Войти"
    And Нажать на кнопку "Мои сервисы"
    Then На странице "Мои сервисы"
  Scenario: Открыть "Почту"
    Given Открыть passport.yandex.ru
    When Ввести в поле "Телефон или почта" текст
    And Нажать на кнопку "Войти"
    And Ввести в поле "Введите пароль" текст
    And Нажать на кнопку "Войти"
    And Нажать на кнопку "Аватарка"
    And Нажать на кнопку "Почта"
    Then На странице "Почта"