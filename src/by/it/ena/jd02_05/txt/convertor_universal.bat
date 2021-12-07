set path=D:\Java\jdk-8\bin
FOR %%I In (*.txt) DO (
native2ascii.exe -encoding utf-8 %%I ../language/%%~nI.properties
)