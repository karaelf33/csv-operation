TECH STACK=>
JAVA 11,
SPRING BOOT,
APACHE

How the app works=>

While the application is running, the "ReadFile Scheduler" service creates a TimeZone Data.xlsx file every minute.
After creating each File it reads this file and when Lagos time zone matches inside the file it takes an action for it.

In the image below, there is the path where the file was created.

File Path=>
![file](https://user-images.githubusercontent.com/26492690/162231477-91203bbc-85d5-4704-b46c-20ddb5258b2c.png)


The following image contains the Action list.

Action =>
![action](https://user-images.githubusercontent.com/26492690/162231058-d53d4050-dedc-4e14-a6b6-e7fb96c6d987.png)

