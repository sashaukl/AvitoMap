# AvitoMap
* [Задание](#task)
* [Особености](#features)
* [Технологии](#tech)
* [Скриншоты](#sreens)
* [Ссылки](#links)
<a name="task"><h2>Задание</h2></a>

### Фильтр точек на карте
Дан JSON-объект в файле *pins.json*. Объект содержит массив "сервисов" и массив точек с координатами. Каждая точка относится к какому-либо сервису.

##### Необходимо написать приложение, которое:
1. Умеет преобразовывать заданный JSON-объект в Kotlin-/Java- объект.
2. Содержит экран с картой (*MapActivity*), на которой отображаются точки. 
3. На экране с картой есть кнопка, которая открывает второй экран со списком сервисов (*FilterActivity*). 
4. На *FilterActvity* можно выбрать сервисы (один или несколько), по которым будут отображаться точки на *MapActivity*.

##### Примечания:
1. Задание желательно выполнять на Kotlin.
2. Неважно какие карты использовать (Google, Яндекс или что-то другое).
3. Библиотека для десериализации JSON в объект выбирается на ваше усмотрение.
4. Выполненное задание нужно загрузить на github.

<a name="features"><h2>Особености</h2></a>
1. Мне показалось, что задание неполное, и парсинг Json локально странная идея. Поэтому я вынес json файл [pins.json](https://sashaukl.github.io/tasks_api/pins.json)
отдельно
2. В задании указывется, что все делать через разные Activity. Мне кажется такой подход неправильным и сделал задание в стиле SingleActivity,
где всесто все описаные Activity используется в качестве Fragments
3. Вместо кнопки сделал обычную BottomNavigationView
4. Не стал разбивать проект на три разных модуля(app, domain, data), сделал все в одном модуле просто рабив по папкам. 
5. В качестве карт взял GoogleMaps

<a name="tech"><h2>Технологии</h2></a>
1. Клиет-сервер - Retrofit + OkHttp
2. Десериализация Json - Gson
3. Навигация - Jetpack Navigation Component
4. Асинхронная работа - Kotlin Coroutines
5. Dependency Injection - Dagger 2
6. MVVM - liveData

<a name="sreens"><h2>Скриншоты</h2></a>
<div>
  <img src="https://github.com/sashaukl/AvitoMap/blob/master/screens/Screenshot_1.png" width="200" height="400">
  <img src="https://github.com/sashaukl/AvitoMap/blob/master/screens/Screenshot_2.png" width="200" height="400">
</div>


<a name="links"><h2>Ссылки</h2></a>
Тут лежит json файл [pins.json](https://github.com/sashaukl/sashaukl.github.io/blob/master/tasks_api/pins.json)
