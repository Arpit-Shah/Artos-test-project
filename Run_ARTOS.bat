@echo off
set mypath=%cd%
@echo %mypath%
mvn exec:java -D"exec.mainClass"="com.tests.MasterRunner"
pause