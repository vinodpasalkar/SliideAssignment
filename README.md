#### Sliide Assignment
Created using Java, Appium and Cucumber BDD framework for News mobile application

#### Prerequisite for this project
Should have Java 11.X, gradle 6.X, appium 1.22.0 
Android SDK
adb

#### Initial investigation - To find the app package and the app activity to add to the appium capabilities 
Install  and launch the app on the emulator or real device , and execute below adb command
adb shell dumpsys window | grep -E 'mCurrentFocus' 

#### To simulate the internet connection on /off
adb shell svc wifi disable
adb shell svc data disable

#### Step-by-Step guide 📜 <br>

1.Take a clone of the repo from the github link

2.Run ```gradle build``` command to get all the dependency for the project and run the test from test runner

3.Start the appium server

4.Run the scenario straight from cucumber feature file via context click
To run single scenario , right click on the specific scenario level and click on Run scenario
To run the entire feature , right click on the feature level and click on Run scenario


#### Reporting ✅

For the run you should be able to see the reports as enlisted below

![Report](mobile_report.png)



