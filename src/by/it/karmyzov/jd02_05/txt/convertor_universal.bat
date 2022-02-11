set path=C:\Program Files\Java\jre1.8.0_251\bin
FOR %%I In (*.txt) DO (
native2ascii.exe -encoding utf-8 %%I ../language/%%~nI.properties
)
