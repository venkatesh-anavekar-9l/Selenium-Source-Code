setlocal enabledelayedexpansion
echo "Killing All Java Porcess..........."
taskkill /f /im java.exe
taskkill /f /im firefox.exe
echo "Waiting for 10 Sec.........."
call ping 127.0.0.1 /n 10 > NUL
echo "Killing All Java Porcess..........."
taskkill /f /im java.exe
taskkill /f /im firefox.exe
echo "Waiting for 10 Sec.........."
call ping 127.0.0.1 /n 10 > NUL


@echo off

Echo Done.
call ping 127.0.0.1 /n 10 > NUL
echo "Now modifying the pom.xml file to run tests from testNG.xml file"
cd "C:\LensesAutomationUsingTestng1"
set INTEXTFILE=pom.xml
set OUTTEXTFILE=pom_out.txt
set SEARCHTEXT=target/failsafe-reports/testng-failed.xml
set REPLACETEXT=resources/testng.xml
set OUTPUTLINE=
for /f "tokens=1,* delims=¶" %%A in ( '"type %INTEXTFILE%"') do (
SET string=%%A
SET modified=!string:%SEARCHTEXT%=%REPLACETEXT%!
echo !modified! >> %OUTTEXTFILE%
)
del %INTEXTFILE%
rename %OUTTEXTFILE% %INTEXTFILE%

cd "C:\LensesAutomationUsingTestng1"
call ping 127.0.0.1 /n 5 > NUL
echo "Deleteing  all class files & log files and folder"
cd "C:\LensesAutomationUsingTestng1\target\classes"
echo "Deleting All Class Files....."
del *.* /Q
FOR /D %%p IN ("C:\LensesAutomationUsingTestng1\target\*.*") DO rmdir "%%p" /s /q
echo "Cleaning All Logfiles Files....."
cd "C:\LensesAutomationUsingTestng1\logs"
del *.* /Q
FOR /D %%p IN ("C:\LensesAutomationUsingTestng1\logs\*.*") DO rmdir "%%p" /s /q
call ping 127.0.0.1 /n 10 > NUL
COPY C:\LensesAutomationUsingTestng1\batchToRun\logfile\debug.log "C:\LensesAutomationUsingTestng1\logs\"
echo "Now After 10 sec all test will run..."
call ping 127.0.0.1 /n 10 > NUL
cd "C:\LensesAutomationUsingTestng1"
echo "Test Started........"
call mvn -U integration-test
call ping 127.0.0.1 /n 10 > NUL

echo "Now replace the pom.xml file to run only failed test cases"
for /f "tokens=1,* delims=¶" %%A in ( '"type %INTEXTFILE%"') do (
SET string=%%A
SET modified=!string:%REPLACETEXT%=%SEARCHTEXT%!
echo !modified! >> %OUTTEXTFILE%
)
del %INTEXTFILE%
rename %OUTTEXTFILE% %INTEXTFILE%
@echo off

echo "Deleteing  all class files & log files and folder"
cd "C:\LensesAutomationUsingTestng1\target\classes"
echo "Deleting All Class Files....."
del *.* /Q
FOR /D %%p IN ("C:\LensesAutomationUsingTestng1\target\*.*") DO rmdir "%%p" /s /q

Echo Done.
cd "C:\LensesAutomationUsingTestng1"
call ping 127.0.0.1 /n 10 > NUL
echo "Running Failed test cases Run-1"
call mvn -U integration-test
call ping 127.0.0.1 /n 10 > NUL
echo "Deleting  all class files & log files and folder before running failed test cases"
cd "C:\LensesAutomationUsingTestng1\target\classes"
echo "Deleting All Class Files....."
del *.* /Q
FOR /D %%p IN ("C:\LensesAutomationUsingTestng1\target\*.*") DO rmdir "%%p" /s /q

echo "Cleaning All Logfiles Files....."
cd "C:\LensesAutomationUsingTestng1\logs"
del *.* /Q
FOR /D %%p IN ("C:\LensesAutomationUsingTestng1\logs\*.*") DO rmdir "%%p" /s /q
call ping 127.0.0.1 /n 10 > NUL
COPY C:\LensesAutomationUsingTestng1\batchToRun\logfile\debug.log "C:\LensesAutomationUsingTestng1\logs\"
cd "C:\LensesAutomationUsingTestng1"
echo "Running Failed test cases Run-2"
call mvn -U integration-test
call ping 127.0.0.1 /n 10 > NUL

echo "Now sending test cases Report to email..."
call ping 127.0.0.1 /n 10 > NUL
E:
cd "E:\InsightAutomationReport"
echo "Deleting All Old Attached Reports....."
del *.* /Q
FOR /D %%p IN ("E:\InsightAutomationReport\*.*") DO rmdir "%%p" /s /q
call ping 127.0.0.1 /n 5 > NUL
cd\
cd "E:\SendEmail-Automations\report"
echo "Deleting All Old TestNg-failed xml Files....."
del *.* /Q
FOR /D %%p IN ("E:\SendEmail-Automations\report\*.*") DO rmdir "%%p" /s /q
call ping 127.0.0.1 /n 2 > NUL
echo "Copying new Result files....."
COPY C:\LensesAutomationUsingTestng1\result "E:\SendEmail-Automations\report\"
call ping 127.0.0.1 /n 5 > NUL
cd ..
echo "Zip report folder"
CScript zip.vbs E:\SendEmail-Automations\report E:\InsightAutomationReport\resultReport2.zip
cd "E:\SendEmail-Automations"

call ping 127.0.0.1 /n 15 > NUL
echo "Send attached email to recepient"
wscript Auto_email.vbs 
call ping 127.0.0.1 /n 2 > NUL
::cd "C:\LensesAutomationUsingTestng1"
echo "Run Over and failed test cases also emailed....Thank You"