Запускать с помощью следующего скрипта с правами суперпользователя и ключем -Е что бы передать переменную окружения PWD.
#!/bin/bash
git clone https://github.com/tw1911/test1.git ./tests
cd ./tests
docker pull selenoid/firefox
docker pull selenoid/chrome
docker-compose up

Когда на экране отобразится строка:
Server started at <http://172.17.0.3:41528/>. Press <Ctrl+C> to exit
Открыть URL в браузере для просмотра Allure отчета.
