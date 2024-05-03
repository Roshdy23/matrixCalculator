# matrixCalculator
It's is a web application using Java and servlets with user interface to ask the user for the square matrix and the user can check which  operation to be performed.

#Running the program
1-Download Tomcat 9.0.  
---
2-Navigate to webapps/ROOT and add the html page which is in the repo.
3-Navigate to WEB-INF and open .xml file and this code .
```
  <servlet>
  <servlet-name>MatrixCalc</servlet-name>
  <servlet-class>matrixClc</servlet-class>
  </servlet>
  <servlet-mapping>
  <servlet-name>MatrixCalc</servlet-name>
  <url-pattern>/MatrixForm</url-pattern>
  </servlet-mapping>
 ```
4-Change the compiler output path to :apache-tomcat-9.0.88/webapps/ROOT/WEB-INF/classes.
5-Add this lib -> Apache Software Foundation\Tomcat 9.0\lib\servlet-api.jar.
6-To run your local host:8080  -> Navigate to bin folder inside apache-tomcat-9.0.88/ and run this command on terminal.
```
./startup.bat
```
Now the program is runnig .

Note:
if you encountered problems running the server :
-Make sure the you includes JRE_HOME AND JAVA_HOME in your environment variables.
-Try to change the local host to 2525::localhost.

Thank you.




