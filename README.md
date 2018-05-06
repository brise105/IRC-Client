# IRC-Client
* Name: Brandon Briseno & Alfonso Castanos
* SID: 1932124 & 2283681
* Class: CPSC 353-02 (Dr. Fahy)
* Protocol: https://tools.ietf.org/html/rfc2812#section-1.2
* API Documentation: http://www.jibble.org/javadocs/pircbot/index.html

## Program Description
This is an Internet Relay Chat client program which should follow the following protocol:
*  1)Get identity data
*  2)Attempt connection to an IRC Server
*  3)Establish a socket connection
*  4)Send server identity data
*  5)Wait for PING echo request from server to the client
*  6)PONG echo response back to the server from the client
*  7)Repeat 5-6 throughout to maintain connection

Currently, we are working on two parts: the bot client and the chat client. The webclient listed below is currently only for debugging and prototyping. The final result will hopefully be able to be tested completely in console.

## Instructions:
**Linux:**
1) Compile: ```javac -classpath pircbot.jar:. *.java```
2) Run: ```java -classpath pircbot.jar:. BotMain```
3) Test: https://client00.chat.mibbit.com/?channel=%23TeamSameTeam&server=irc.synirc.net
    * Disclaimer: We are working on a client to interact w/ the Bot, but main focus of this project was on the Bot
    * The nickname you choose must be unique. Two users can't have same unique identifier on same server.

**Windows:**
1) Compile: ```javac -classpath pircbot.jar;. *.java```
2) Run: ```java -classpath pircbot.jar;. BotMain```
3) Test: https://client00.chat.mibbit.com/?channel=%23TeamSameTeam&server=irc.synirc.net
    * Disclaimer: We are working on a client to interact w/ the Bot, but main focus of this project was on the Bot
    * The nickname you choose must be unique. Two users can't have same unique identifier on same server.

**Commands:**
* ```!time```: tells current time for user
* ```!cat```: returns a random image of a cat
* ```!fib``` n: returns fibonnacci sequence up to n
* ```!facto``` n: factorial of n
* ```!cel``` n: converts n degrees fahrinheight to celcius
* ```!fahr``` n: converts n degrees celcius to fahrinheight
* ```!rev``` s: reverses string s
* ```!cal```: performs basic arthmetic upon two values: n & m
  * *!cal+space+n+operator+m*
  * *Single operations only!*
  * ```!bin``` n: converts decimal number n to binary

**Checkstyles:**
```java -jar checkstyle-8.8-all.jar -c google_checks.xml *.java```

## To Do List:

- [x] Brainstorm bot operations
- [x] Implement 3 bot operations
- [x] Implement 9 bot operations
- [ ] Implement 20 bot operations
- [ ] Exception handling/backend feedback for bad inputs
- [x] Establish identity
- [x] Establish & maintain connection
- [ ] Multi-channel listening
- [ ] Allow chat functionality on chat client
