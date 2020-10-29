# yulatest

Из того что хотелось бы доделать, но не успел, стараясь уложиться в объявленый мною срок на решение задачи

* Хотел сначала валидировать подгрузку страницы, проверяя ключевые элементы на isDisplayed()
Затем, по тест-кейсу из задания понял, что задачи такой не стоит. Забыл удалить вебэлемент и метод по следующим референсам:
ru.fmordashev.page.YandexResultPage#seemsLikeTextHeader
ru.fmordashev.page.YandexResultPage#isSeemsLikeTextHeaderDisplayed

* Были проблемы с локатором ru.fmordashev.page.YandexResultPage#predictionBulletList
Я установил утилитку Xpath-Helper для Chrome, проверял валидность xpath-ов по ней.
Вроде бы локатор //div[@class='CbirItem']//div[@class='Tags']/a должен был сработать, но не получалось. Я не хотел слишком долго копать в эту сторону, поэтому сделал абсолютный путь до элемента
Можно было поступить красивее и сделать указатель по css
@FindBy(css = "div.CbirItem div.Tags a")
Я проверил - решение рабочее

* Столкнулся с тем, что клик по кнопке "Картинки" из заглавной страницы яндекса открывает новую вкладку. 
Решений у меня было 3, наверное - менять фокус вебдрайвера на новую вкладку, открывать ссылку в той же вкладке с помощью джаваскрипта или выставить проперти чтобы вебдрайвер запускал браузер в режиме открытия вкладов в той же страничке. Искать как выполнить джаваскрипт показалось долго, ровно как и с настройками ковыряться. Как с вкладками работать помнил по памяти, но, мне кажется, не самое изящный подход.

* Немного костыльным кажется мое решение по преобразованию кириллицы из configuration.properties. Было бы лучше декодирование в утилитный метод завернуть.
