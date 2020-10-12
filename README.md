selenium-cucumber-java-maven
=================

selenium-cucumber : Automation Testing Using Java

selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web.
It enables you to write and execute automated acceptance/unit tests.
It is cross-platform, open source and free.
Automate your test cases with minimal coding.
[More Details](http://seleniumcucumber.info/)

Documentation
-------------
* [Installation](https://github.com/selenium-cucumber/selenium-cucumber-java/blob/master/doc/installation.md)
* [Predefined steps](https://github.com/selenium-cucumber/selenium-cucumber-java/blob/master/doc/canned_steps.md)

Download a Framework
--------------
* Maven - https://github.com/selenium-cucumber/selenium-cucumber-java-maven-example

Framework Architecture
--------------
	Project-Name
		|
		|_src/main/java
		|	|_appUnderTest
		|		|...
		|_src/main/resources
		|_src/test/java
		|	|_env
		|	|	|_DriverUtil.java
		|	|	|_Hooks.java
		|	|	|_RunCukeTest.java
		|	|_userStepDefinitions
		|	|	|_loginSteps.java
		|	|	|_signUpSteps.java
		|	|	|...
		|_src/test/resources
		|	|_features
		|	|	|to_do.feature
		|	|	|weather_forecast.feature

* **src/test/resources/features** - all the cucumber features files (files .feature ext) goes here.
* **src/test/java/userStepDefinition** - you can define step defintion under this package for your feature steps.
* **src/test/java/env** - this package contains cucumber runner (RunCukeTest.java) where you can configure your glue code location (step defintions), define test result output format.(html, json, xml). Hooks where you can configure all before and after test settings Hooks.java, DriverUtil.java contains code for intializing driver instances for respective driver.


Writing a test
--------------

The cucumber features goes in the `features` library and should have the ".feature" extension.

You can start out by looking at `features/to_do.feature`. You can extend this feature or make your own features using some of the [predefined steps](https://github.com/selenium-cucumber/selenium-cucumber-java/blob/master/doc/canned_steps.md) that comes with selenium-cucumber.


Predefined steps
-----------------
By using predefined steps you can automate your test cases more quickly, more efficiently and without much coding.
[More Details](https://github.com/selenium-cucumber/selenium-cucumber-java/blob/master/src/main/java/info/seleniumcucumber/stepdefinitions/PredefinedStepDefinitions.java)


Running test
--------------

Go to your project directory from terminal and hit following commands
* `mvn test (default will run on local firefox browser) against both to_do feature and weather api feature`
* `mvn test -Dcucumber.options="classpath:features/to_do.feature"` to run specific feature.
* `mvn test -Dcucumber.options="–-plugin html:target/result-html"` to generate a HTML report.
* `mvn test -Dcucumber.options="–-plugin json:target/result-json"` to generate a JSON report.

Driver Dependency
-----------------
If you run into issues with ghecko driver not found, download the latest from [here](https://github.com/mozilla/geckodriver/releases)
extract the driver to a local path and add this path into your PATH variable. On a Mac you can edit your `~/.bash_profile`
with the following lines: `export PATH=$PATH:/your-path-to-ghecko-driver`

Then saved and reload your bash with the following command: `source ~/.bash_profile` you can now re-run the `mvn test` commands


Maven/Gradle Dependency
-----------------------
See https://jitpack.io/#selenium-cucumber/selenium-cucumber-java .

Credits
-------
In completing this exercise, I modeled after the GitHub project of Sameer Sawant Seleniun-Cucumber-Java which can be
found [here](https://github.com/selenium-cucumber/selenium-cucumber-java)
# SignalPath-Cucumber-Framework
