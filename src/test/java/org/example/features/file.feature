Feature: Работа с файлами на "passport.yandex.ru"
  Scenario: Загрузка файла на диск
    Given Открыть passport.yandex.ru
    When Ввести в поле "Телефон или почта" текст
    And Нажать на кнопку "Войти"
    And Ввести в поле "Введите пароль" текст
    And Нажать на кнопку "Войти"
    And Нажать на кнопку "Мои сервисы"
    And Нажать на кнопку "Диск"
    And Загрузить файл на диск
    Then Файл появился на диске
  Scenario: Загрузка и проверка файла с диска
    Given Открыть passport.yandex.ru
    When Ввести в поле "Телефон или почта" текст
    And Нажать на кнопку "Войти"
    And Ввести в поле "Введите пароль" текст
    And Нажать на кнопку "Войти"
    And Нажать на кнопку "Мои сервисы"
    And Нажать на кнопку "Диск"
    And Нажать на кнопку "Значок файла"
    Then Скачать и проверить файл