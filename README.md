JUST EAT Test Automation Engineer Recruitment Test
==================================

In order to run the tests you will need [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html), [Google Chrome](https://www.google.co.uk/chrome/browser/desktop/), [Chromedriver](https://sites.google.com/a/chromium.org/chromedriver/) and [Maven](https://maven.apache.org/download.cgi). Please ensure that these applications are installed within your path and available from the command line.

Once you have them all installed you can run:

```mvn clean test```

Alternatively, the RunCukesTest class can be run as a jUnit test from within an IDE. For example, in IntelliJ you can right-click on the name of the class and select 'Run RunCukesTest'.

Comments
==================================

I have tried to keep the scenarios as simple as possible and have ensured that the code reuse is high. The step definitions are not particularly beautiful are instead trying to avoid overhead like multiple page object instantiations, reflection or dependency injection.
