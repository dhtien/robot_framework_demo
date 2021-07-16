### What is this repository for? ###

* Robot framework - api test
* Selenium - web test

### Installation ###

JDK 1.8
Maven 3.6.3
Python 3
NewMan


### Installation ###
For run Robot FrameWork test
Remember to install: pip install robotframework-requests

```
cd demo-project
robot TestCase/DemoTestCase.robot
```

For run Newman test 

```
newman run collection.postman_collection.json
```
stop when validation fail

```
newman run collection.postman_collection.json --bail
```

For run Selenium Test
```
mvn clean test
```
