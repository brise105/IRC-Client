Project name: IRC-Client
Programmers: Brandon Briseno & Alfonso Castanos
Code Reviewer: Dawson Jung

On a scale of 1 to 5, I give this code a rating of _5_ based on the following criteria:

1  I was not able to compile the program due to insufficient information in the README.md file.

2  At least one of the programs has syntax errors and does not compile

3  The programs compile successfully but at least one generates runtime errors

4  The programs compile and run but the project does not perform correctly and does not produce correct results.
Specifically:

5  The programs compile and produce technically correct results but does not perform according to the documentation or does not comply with Chapman Coding Standards.
Specifically:

The function !fib n does not work. It was listed in the documentation as a feature but it would not return anything. I got error messages in the console from that function,
specifically:

input: !fib 5

1525599865773 :Nickers!Mibbit@synIRC-CFD4EF9B.oc.oc.cox.net PRIVMSG #TeamSameTeam :!fib 5
1525599865773 ### Your implementation of PircBot is faulty and you have
1525599865773 ### allowed an uncaught Exception or Error to propagate in your
1525599865773 ### code. It may be possible for PircBot to continue operating
1525599865773 ### normally. Here is the stack trace that was produced: -
1525599865773 ###
1525599865773 ### java.lang.StringIndexOutOfBoundsException: String index out of range: 7
1525599865774 ###       at java.lang.String.substring(Unknown Source)
1525599865774 ###       at Bot.onMessage(Bot.java:67)
1525599865774 ###       at org.jibble.pircbot.PircBot.handleLine(PircBot.java:990)
1525599865774 ###       at org.jibble.pircbot.InputThread.run(InputThread.java:92)
1525599900330 PING :sirocco.tx.us.synirc.net
1525599900330 >>>PONG :sirocco.tx.us.synirc.net

Also small formatting issues such as:
!fahr 100
Nickers: 100.0 degrees Celcius equals212.0 degrees Fahrenheit

Checkstyle passed with no issues.

6  The program produces correct output and is well written and well documented, following the Chapman Coding Standards.

Suggestions for improving the code (for extra credit!):

Can clean the text output from the bot, and get !fib n to work.
Also, it would keep rejecting my chosen nickname. Maybe an error message as to why?
And by the way, Celcius is spelled Celsius :)
