Домашнее задание
1. открыть dns-shop
2. в поиске найти playstation
3. кликнуть по playstation 4 slim black
4. запомнить цену
5. Нажать Купить
6. выполнить поиск Detroit
7. запомнить цену
8. нажать купить
9. перейти в корзину
10. проверить цену каждого из товаров и сумму
11. В корзине для playstation Доп.гарантия - выбрать 24 месяца
12. дождаться изменения цены и запомнить цену с гарантией
13. удалить из корзины Detroit
14. проверить что Detroit нет больше в корзине и что сумма уменьшилась на цену Detroit
15. добавить еще 2 playstation (кнопкой +) и проверить что сумма верна (равна 3*(цена playstation+гарантия))
16. удалить (кнопка "удалить") Playstation из корзины
17. нажать вернуть удаленный товаров
18. проверить что 3 playstation снова в корзине и выбрана гарантия 24 месяца
Подсказки:
Отдельные PageObject -поиск, страница с результатами, карточка товара, корзина, (и, возможно, позиция товара)
Следует создать отдельный класс Product -который будет являться моделью купленного товара (с полями цена, гарантия, описание и что-то еще)
Методы должны быть максимально параметризируемые, позволяющие проверить любой товар, и выполнить с ним любые шаги из данного теста.