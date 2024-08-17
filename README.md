Для запуска просто используйте ./gradlew bootRun, перезапись файлов пока недоступна и тестов нет но всё остальное работает
Запросы доступны следующие:

POST:
http://localhost:8080/api/files
body:
{
  "title": название,
  "creationDate": дата-стринг,
  "description": описание,
  "data": закодированные в base64 данные
}
вернёт id файла

GET:
http://localhost:8080/api/files/{$ID}
вернёт json файла

GET:
http://localhost:8080/api/files?page=0&size=10&sortBy=description
вернёт лист файлов