# Diplom_1

[Задание 1: юнит-тесты](task_1.md)

Для запуска тестов выполнить команду
```
mvn clean test
```

Для генерации отчета о покрытии кода с помощью Jacoco тестами выполнить команду
```
mvn verify
```
Отчет будет сгенерирован в папку target/site/jacoco/

Добавить папку с отчетом Jacoco к отслеживаемым файлам. Добавить ключ -f, если папка target указана в .gitignore.
```
git add -f .\target\site\jacoco\.
git commit -m "add jacoco report"
git push
```