# DB

Здесь хранятся мои решения задач по курсу Хранение и обработка информации.

Практикум по курсу
Базы данных и параллелизм 2020 г.

Задание N1:
Напишите программу, которая создаёт нить.
Родительская и вновь созданная нити должны распечатать десять строк текста.

Задание N2:
Модифицируйте программу из “Задания N1” так, чтобы вывод родительской нити
производился после завершения дочерней.

Задание N3:
Напишите программу, которая создаёт четыре нити, исполняющие один и тот же метод.
Этот метод должен распечатать последовательность текстовых строк, переданных
как параметр. Каждая из созданных нитей должна распечатать различные
последовательности строк.

Задание N4:
Дочерняя нить должна распечатывать текст на экран. Через две секунды после создания
дочерней нити, родительская нить должна прервать её.

Задание N5:
Модифицируйте программу из “Задания 4” так, чтобы дочерняя нить перед завершением
распечатывала сообщение об этом.

Задание N6
В приложении No1 находится код программы, которую вам необходимо доработать.
Легенда:
1. Класс Company характеризует компанию, разделённую на отделы.
2. Каждый отдел (класс Department) умеет вычислять сумму от 1 до n, где n — это
рандомное число от 1 до 6.
3. Каждая итерация суммирования занимает 1 секунду. Поэтому: если n равно 3, то на
вычисление суммы 0 + 1 + 2 уйдёт 3 секунды (метод performCalculations).
Вам необходимо дописать реализацию класса Founder, в котором:
1. У вас будет находиться список со всеми Worker’ами (Runnable).
2. За каждым Worker’ом должен быть закреплён свой Department.
3. Каждый Worker должен инициировать запуск вычислений.
4. После того как во всех нитях завершатся вычисления, нужно вывести результат (метод
showCollaborativeResult)
Примечание:
Следует разобраться как работают барьеры в Java.

Задание N7
Напишите программу, которая вычисляет число Пи при помощи ряда Лейбница
Количество потоков программы должно определяться параметром командной строки.
Количество итераций может определяться во время компиляции.


Задание N8
Модифицируйте программу из “Задания No7” так, чтобы сама по себе она не завершалась.
Вместо этого, после получения сигнала SIGINT программа должна как можно скорее
завершаться, собирать частичные суммы ряда и выводить полученное приближение числа.
Рекомендации:
Ожидаемое решение состоит в том, что вы установите обработчик SIGINT. Подумайте,
как минимизировать ошибку, обусловленную тем, что разные потоки к моменту завершения
успели пройти разное количество итераций. Скорее всего, такая минимизация должна
обеспечиваться за счет увеличения времени между получением сигнала и выходом.

Задание N9
Напишите программу, которая будет симулировать известную задачу про обедающих
философов. Пять философов сидят за круглым столом и едят спагетти. Спагетти едят
при помощи двух вилок. Каждые двое философов, сидящих рядом, пользуются общей
вилкой. Философ некоторое время размышляет, потом пытается взять вилки
и принимается за еду. Съев некоторое количество спагетти, философ освобождает вилки
и снова начинает размышлять. Еще через некоторое время он снова принимается за еду,
и т.д., пока спагетти не кончатся. Если одну из вилок взять не получается, философ ждет,
пока она освободится. Как вариант реализации: философы симулируются при помощи
нитей, периоды размышлений и еды – при помощи засыпаний, а вилки – при помощи
мьютексов. Философы всегда берут сначала левую вилку, а потом правую.
Дополнительно:
Объясните, при каких обстоятельствах это может приводить к мертвой блокировке.
Измените протокол взаимодействия философов с вилками таким образом, чтобы мертвых
блокировок не происходило.

Задание N10
Модифицируйте программу из “Задания No1” так, чтобы вывод родительской и дочерней
нитей был синхронизирован: сначала родительская нить выводила первую строку, затем
дочерняя, затем родительская вторую строку и т.д. Используйте мьютексы.
Примечание:
Явные и неявные передачи управления между нитями и холостые циклы разрешается
использовать только на этапе инициализации.


Задание N11
Решите “Задание No10” с использованием двух семафоров-счетчиков.
Задание N12
Родительская нить программы должна считывать вводимые пользователем строки
и помещать их в начало связанного списка. Строки длиннее 80 символов можно разрезать
на несколько строк. При вводе пустой строки программа должна выдавать текущее
состояние списка. Дочерняя нить пробуждается каждые пять секунд и сортирует список
в лексикографическом порядке (используйте пузырьковую сортировку).
Примечание:
Все операции над списком должны синхронизоваться при помощи синхронизованных
блоков на объектах головы.
