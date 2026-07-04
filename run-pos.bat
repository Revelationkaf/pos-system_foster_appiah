@echo off
setlocal
cd /d "%~dp0"
set JAVA_HOME=C:\Program Files\Java\jdk-26.0.1
set PATH=%JAVA_HOME%\bin;%PATH%
mvn -q -DskipTests javafx:run
