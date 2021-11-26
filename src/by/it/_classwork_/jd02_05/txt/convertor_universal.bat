set path=C:\java\jdk1.8.0_181\bin
FOR %%I In (*.txt) DO (
native2ascii.exe -encoding utf-8 %%I ../language/%%~nI.properties
)
