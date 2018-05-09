# IRC-Client
* Name: Brandon Briseno & Alfonso Castanos
* SID: 1932124 & 2283681
* Class: CPSC 353-02 (Dr. Fahy)
* Protocol: https://tools.ietf.org/html/rfc2812#section-1.2
* API Documentation: http://www.jibble.org/javadocs/pircbot/index.html

## Program Description
This is an Internet Relay Chat client program which should follow the following protocol:
*  1)Get info from user (hostname, port, name, user)
*  2)USER/NICK info
*  3)Open sockets/data streams
*  5)Send user data to a server on the IRC network
*  5)Wait for PING msg + key from server to the client
*  6)PONG msg back to the server from the client w/ the key
*  7)Create/join chatroom w/ the key
*  8)Listen for commands/send messages
*  9)Ping/Pong to maintain connection
*  10)QUIT on command

This project consists of two parts: the main Bot client and the Chat client. The webclient (mibbit) listed below is for debugging and prototyping; functionally speaking, it is an idealized iteration of the ```Chat.java``` client. Furthermore, the Chat client is intended to serve as a built-in "controller" for interacting w/ the IRC Bot. It was built from scratch by analyzing IRC packets over wireshark with the intention to get a closer look at how the protocol works without the help of an API. 

## Instructions:
**Linux:**
1. Compile: ```javac -classpath pircbot.jar:. *.java```
2. Run: ```java -classpath pircbot.jar:. BotMain```

3a. Test-- Method 1: https://client00.chat.mibbit.com/?channel=%23TeamSameTeam&server=irc.synirc.net
  * The nickname you choose must be unique. Two users can't have same unique identifier on same server.
    
3b. Test-- Method 2 (requires JDK enviornment):
    * Compile: ```javac Chat.java```
  * Run: ```java Chat```
    * The nickname you choose must be unique. Two users can't have same unique identifier on same server.

**Windows:**
1. Compile: ```javac -classpath pircbot.jar;. *.java```
2. Run: ```java -classpath pircbot.jar;. BotMain```

3a. Test-- Method 1: https://client00.chat.mibbit.com/?channel=%23TeamSameTeam&server=irc.synirc.net
  * The nickname you choose must be unique. Two users can't have same unique identifier on same server.
  
3b. Test-- Method 2 (requires JDK enviornment):
  * Compile: ```javac Chat.java```
  * Run: ```java Chat```
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
- [x] Exception handling/backend feedback for bad inputs
- [x] Establish identity
- [x] Establish & maintain connection
- [ ] Multi-channel listening
- [x] Implement IRC protocol in a chat client
