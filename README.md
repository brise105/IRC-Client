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

This project consists of two parts: the main Bot client and the Chat client. 

DISCLAIMER: the ```Chat.java``` client is simply an extra addon to this project, it is by no means a finished product. Furthermore, the Chat client is intended to serve as a built-in "controller" for interacting w/ the IRC Bot. It was built from scratch by analyzing IRC packets over wireshark with the intention to get a closer look at how the protocol works without the help of an API. However, the main focus of this project was placed upon the actual IRC Bot. 

For an idealized chat client, feel free to test out the free web IRC client called [Mibbit](https://client00.chat.mibbit.com/?channel=%23TeamSameTeam&server=irc.synirc.net)!

## Instructions:
**Linux:**

* Method 1: (requires JDK enviornment)

    * 1a. Compile Bot Client: ```javac -classpath pircbot.jar:. *.java```

    * 2a. Run Bot Client: ```java -classpath pircbot.jar:. BotMain```

    * 3a. Test w/ Chat Client:
      * Compile: ```javac Chat.java```
      * Run: ```java Chat```
        * The nickname you choose must be unique. Two users can't have same unique identifier on same server.

    

**Windows:**

* Method 1: (requires JDK enviornment)

    * 1a. Compile Bot Client: ```javac -classpath pircbot.jar;. *.java```

    * 2a. Run Bot Client: ```java -classpath pircbot.jar;. BotMain```

    * 3a. Test w/ Chat Client:
      * Compile: ```javac Chat.java```
      * Run: ```java Chat```
        * The nickname you choose must be unique. Two users can't have same unique identifier on same server.

**Commands:**
* ```!time```: tells current time for user
* ```!cat```: returns a random image of a cat
* ```!rev```: s: reverses string s
* ```!fib``` n: returns fibonnacci sequence up to n
* ```!facto``` n: factorial of n
* ```!cel``` n: converts n degrees fahrenheit to celsius
* ```!fahr``` n: converts n degrees celsius to fahrenheit
* ```!cal```: performs basic arthmetic upon two values: n & m
  * *!cal+space+n+operator+m*
  * *Single operations only!*
* ```!bin``` n: converts decimal number n to binary
* ```!dec``` n: converts binary number n to decimal
* ```!palin``` s: checks if string s is a palindrome
* ```!ctdown``` n: countdown starting from n
  * *Limit 60 seconds!*
* ```!help``` list of the commands with required input
* ```!cmdinfo``` list of the commands with descriptions

**Checkstyles:**
```java -jar checkstyle-8.8-all.jar -c google_checks.xml *.java```

## To Do List:

- [x] Brainstorm bot operations
- [x] Implement 3 bot operations
- [x] Implement 10 bot operations
- [x] Exception handling/backend feedback for bad inputs
- [x] Establish identity
- [x] Establish & maintain connection
- [x] Implement IRC protocol in a chat client
