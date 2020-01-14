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

Beside of the running test on Jenkins, you can exeute the tests as TestNG or a Maven. 

* TestNG: Goto Edit Configuration and set the project as TestNG project.
* Maven: 
Goto project root folder and for running all tests
```
mvn clean test
```
Goto project root folder and for running all tests in a class
```
mvn -Dtest=Test_2_SignIn#validSignInTest clean test
```


### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Ali Pala** - *Initial work* - [Ali Pala](https://github.com/alipala)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc

