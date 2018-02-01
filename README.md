# robot

Prerequisites
-------------
- Set up JAVA_HOME env variable to point to JDK home dir
- Ensure JAVA_HOME/bin is on PATH environment variable

Build
-----
- From the root of project , execute below :
  - WINDOWS :  mvnw clean install 
  - Linux   : ./mvnw clean install


- Execute using the generated jar as :
     java -jar robot-1.0-SNAPSHOT.jar

OR

- Execute directly using maven as : 
  - WINDOWS : mvnw exec:java
  - LINUX : ./mvnw exec:java

OR

- Execute from IDE by Running Java main class=> com.launch.robot.Main


Tests
-----
- Run mvnw test
