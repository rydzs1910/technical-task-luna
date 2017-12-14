# technical-task-luna
In order to run the project :
# Firefox browser(I used gecodriver v0.19.0 and Firefox 55.0):
1. Clone the repository
2. Download geckodriver from https://github.com/mozilla/geckodriver/releases and put the file to src/main/resources  
3. From technical-task-luna(main project folder) folder open command line and execute:
for Windows : mvn clean test -Durl=https://akamaijobs.referrals.selectminds.com/ -Ddriver=geckodriver.exe -Dbrowser=firefox
for Mac :	  mvn clean test -Durl=https://akamaijobs.referrals.selectminds.com/ -Ddriver=geckodriver -Dbrowser=firefox
# Chrome browser(I used ChromeDriver 2.34 and Chrome 63.0.3239.84):
1. Clone the repository
2. Download geckodriver from https://sites.google.com/a/chromium.org/chromedriver/downloads and put the file to src/main/resources 
3. From technical-task-luna(main project folder) folder open command line and execute:
for Windows : mvn clean test -Durl=https://akamaijobs.referrals.selectminds.com/ -Ddriver=chromedriver.exe -Dbrowser=chrome
for Mac :	  mvn clean test -Durl=https://akamaijobs.referrals.selectminds.com/ -Ddriver=chromedriver -Dbrowser=chrome
