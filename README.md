# WebUITest

The project is about functional UI test automation project includes tech stack: Java, TestNG, Allure Report, Maven, Jenkins, Log4J, IntelliJ.

## Getting Started

The project can be cloned from GitHub. Since it is a maven project, all the dependencies will be imported easily on your local machine for the enhancing the development and test. See deployment for notes on how to deploy the project on a live system.

### Prerequisites and Installation

```
Java installation should be done and added to the PATH. Beside of this MAVEN_HOME should be added to the path. 
Also, Java IDE. I have used IntelliJ Community Edition 2019, but you can choose an IDE whatever you want. For example, Eclipse.
Please note that, after cloning the repository there will be a Jenkins_Configuration.rar file located in the root. This file includes all the required configuration, and you should import this file to create a job the same as me. 
Note: JDK version: jdk1.8.0_211
```

## Running the tests

* Jenkins:

Please read this blog post [Build a maven project to run test](https://medium.com/@anusha.sharma3010/build-a-simple-maven-project-in-jenkins-da7a2a4ae202)

* TestNG: 
- Goto Edit Configuration and set the project as TestNG project.
* Maven: 
- Goto project root folder and for running all tests
```
mvn clean test
```
- for running all tests in a class
```
mvn -Dtest=Test_2_SignIn clean test
```
- for a running single test
```
mvn -Dtest=Test_2_SignIn#validSignInTest clean test
```

### Tests

Explain what these tests test and why

```
Give an example
```

## Built With

* [JAVA](https://docs.oracle.com/javase/8/docs/technotes/guides/language/index.html) - Programming Language
* [TestNG](https://testng.org/doc/) - The testing framework
* [Selenium](https://selenium.dev/) - Used to generate browser automation tests
* [Maven](https://maven.apache.org/) - It is a build automation tool used for Java projects
* [JavaFaker](http://dius.github.io/java-faker/) - Used to generate fake user data to be used in Signin and Login
* [Allure Report](http://allure.qatools.ru/) - Used to create test execution reports
* [Log4J](https://logging.apache.org/log4j/2.x/) - For inserting log statements into code 
* [Jenkins](https://jenkins.io/) - It is an open source automation server to build the job periodically with required plugins


## Authors

* **Ali Pala** - *Initial work* - [Ali Pala](https://github.com/alipala)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Please have a look how to migrate Jenkins job to your local. [Jenkins Job migration] (https://staxmanade.com/2015/01/how-to-migrate-a-jenkins-job-to-new-jenkins-server/)

