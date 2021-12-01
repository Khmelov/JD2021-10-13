set path=C:\Program Files\Java\jdk1.8.0_301\bin
FOR %%I In (*.txt) DO (
native2ascii.exe -encoding utf-8 %%I ../language/%%~nI.properties
)
