1. В любом проекте использовать properties для версий зависимостей
2. Создать в корневой директории проекта SauceDemo файл README.md в котором разместить, команды для следующих операций:
    1. Обновить версии всех библиотек в проекте и ее вывод, например
    - mvn versions:display-dependency-updates
    - mvn versions:use-latest-versions
    - [INFO] The following dependencies in Dependencies have newer versions:
    - [INFO]   org.seleniumhq.selenium:selenium-java ...... 3.141.59 -> 4.0.0-alpha-5
    2. Запустить тесты используя mvn clean test команду и ее вывод, например
    - mvn clean test -Dsuite="SmokeSuite"
    - mvn clean test -Dsuite="TestNG"
    - Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 11.302 sec <<< FAILURE!
    3. Использовать параметры для запуска конкретных тестов и методов (может быть затык с запуск нескольких методов, здесь документация https://maven.apache.org/surefire/maven-surefire-plugin/examples/single-test.html , для работы необходим обновленный maven-surefire-plugin, как обновить написано здесь http://maven.apache.org/surefire/maven-surefire-plugin/usage.html )
    - mvn clean test -Dsuite="SmokeSuite" -Dbrowser="CHROME"
    - mvn -f {path-to-another/pom.xml} test (запуск через любое место в консоли)
    - mvn clean test -Dsuite=SmokeSuite -Dusername=standard_user -Dpassword=secret_sauce (запуск с кредами)
    - mvn clean -Dtest="LoginTest" -Dusername=standard_user -Dpasscode=secret_sauce
3. Пробросить параметр из mvn command line внутрь теста
4. mvn allure:serve
5. mvn allure:report

