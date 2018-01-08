***
HOW TO RUN PROJECT

You will need:
- Maven 
- MySQL
- JDK8

After you have installed all necessary tools:
- clone this repo: https://github.com/ViktoriyaRyazhska/Lv-279.Java.git
- Properties file: Lv-279.Java/RAS/server/web/src/main/resources/application.properties
- Open console in folder Lv-279.Java/ and run :
	* 	mysql -u YOUR_USER_NAME -pYOUR_PASSWORD < Dump/FullDump.sql
- Open console in folder Lv-279.Java/RAS/server/ and run :
	*	mvn clean install
	*	mvn -f ./web/pom.xml spring-boot:run
- navigate to http://localhost:8080/ in your browser
***
