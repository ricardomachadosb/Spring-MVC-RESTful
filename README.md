Spring MVC RESTful app
========

 This is an web application made with Spring MVC 4 and Angular with the objective to help you and your friends to 
 democratically choose the best restaurant to go at lunch time. It has scheduled tasks to start and stop the voting.
 The voting starts at 06:00 AM and finish at 11:00 AM every day.

Technologies 
----
* JAVA (Back end language)
* Spring MVC 4 (Back end framework)
* Gradle (Back end dependency management) 
* Mockito (Back end test framework)
* Bower (Front end dependency management)
* Twitter bootstrap (CSS framework)
* AngularJS (Front end JavaScript framework)

How to RUN 
----
* [Install JDK 1.8](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
* [Install Gradle](https://docs.gradle.org/current/userguide/installation.html)
* [Install Bower globally](http://bower.io/)
* [Clone this project](https://help.github.com/articles/cloning-a-repository/)
* Go to project root folder and execute the command: ```$bower install ```
* Still on root project folder run ```$gradle jettyRun ```
* Open your web browser and access [localhost:8080](http://localhost:8080/)

You can login with username "ricardo" and password "ricardo".
You can find/add more in memory users at SecurityConfig.java file.

If you want to import the project in eclipse run ```$gradle eclipse ``` at project root folder.

no database needed.

How to improve this project
----
* Remove in memory authentication to be possible to add new users and new attributes like email, name and userName.
* Build a restaurant CRUD.
* Build a routine to send email to the users when the voting is finished.
* Make possible to create different groups of Users to select multiples restaurant in the same day. 
* Build a better layout.