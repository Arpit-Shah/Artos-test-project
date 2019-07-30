@echo off
set mypath=%cd%
@echo %mypath%
mvn exec:java -Dexec.mainClass="com.tests.MasterRunner" -Dexec.args="-v -p=dev"
pause