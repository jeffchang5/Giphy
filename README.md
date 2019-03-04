# OpenTable Challenge

This project is an implementation of the specs required by the OpenTable challenge criteria. The app requires Android 5.1 and above.

### Getting Started

1. Clone the Github repo.
2. Open the project in Android Studio.
3. Build and run the project.

### Goals
* Demonstrate a good understanding of software architecture and tooling that are important in maintaining a modern codebase.
* Demonstrate create logical seperation between a reusable base module and more granular feature modules. This structure paves the way to have more cross-team development and converting the app into an Instant app.
* Using Kotlin to write more succinct and readable code.
* Use dependency injection with Dagger 2 to produce decoupled modules and services. Relying on Dagger-Android to avoid writing boilerplate code.
* Use MVVM to separate responsibilities from the view and create more easily testable classes.
* Use Architecture Components as a baseline for introducing Android best practices.
* Sensible package and module organization.
* Demonstrate the use of community supported Android libraries for scalable codebases.
* Error handling to create better UX for predictable conditions.
* Handle an array of device definitions.
* Using Git flow to create a readable git history for product owners.

### Features

* Displays a list of movie reviews from NYT movie reviews API
* Displays movie review headline, title, byline, multimedia,  and publication date.
* Support phone and tablet device definitions

### TODOs

* The scroll position can be saved when rotated.
* Add testing to ensure integrity of being handle different edge cases.

### Third Party Libraries

* Picasso is used to load and cache images from the network.
* Architecture Components LiveModel is used to have a lifecycle aware (and safe) place to hold data as well as convenient for writing a CLEAN architecture.
* RxJava 2 is used to provide a reactive stream method of presenting of data. It is easier to handle and manipulate different transactions.
* Retrofit is a great network abstraction library to convert JSON to POJO classes.
* Dagger 2 is used to reduce boilerplate and create testable services and components.
* Timber for more powerful logging. 

### Screenshots
<table>
    <tr>
        <td><img style="width: 350px: height:auto; margin: 0 50px" src="/screenshots/phone-horizontal.png"></img></td>
        <td><img src="/screenshots/phone-vertical.png"></img></td>
        <td><img src="/screenshots/tablet-vertical.png"></img></td>
    </tr>
        <tr>
        <td align="center"><b>Phone Horizontal<b></td>
        <td align="center"><b>Phone Vertical</b></img></td>
        <td align="center"><b>Tablet Vertical</b></img></td>
    </tr>
</table>


