/**
*  IRC Client Program
*  1)Get info from user
*  2)Receives 5 single line inputs
*  3)Attempt connection to IRC Server
*  4)Establish socket connection
*  5)Send server data
*  5)Wait for PING msg from server to the client
*  6)PONG msg back to the server from the client
*  7)Create/join chatroom
*  8)Self promotion
*  9)Listen for commands
*  10)/quit on command or kick
*
*  @author: Brandon Briseno & Alfonso Castanos
*  Email:  brise105@mail.chapman.edu & casta145@mail.chapman.edu
*  Date:  5/6/2018
*  @version: 3.6
*/
import java.io.BufferedReader;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.lang.NullPointerException;

import java.net.Socket;

import java.net.SocketException;
import java.net.UnknownHostException;


class Chat {
  public static void main(String[] args) throws Exception {
    //User Input:
    BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

    //standard delimiter for hostname:port number
    String portDelimiter = ":";

    //get user input
    System.out.print("Hostname (ex: irc.synirc.net:6667): ");
    String host; //instantize string holder for host name
    host = userInput.readLine(); //what the emails about

    int port; //instantize int holder for port number
    String[] parse = host.split(portDelimiter);
    host = parse[0]; //read line from beginning, up until ':' delimter is read
    int temp = 0;
    try {
      temp = Integer.parseInt(parse[1]); //read string array @index 0 after ':'
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("ERROR: the expected input is 'host:port#'");
      System.exit(0);
    }
    port = temp;

    System.out.print("Nickname: ");
    String nick; //instantize string holder for nickname/screen name
    nick = userInput.readLine(); //user's screen name
    if (nick.equals("")) {
      System.out.println("ERROR: no nickname given");
      System.exit(0);
    }

    System.out.print("Full name (optional): ");
    String name; //instantize string holder for custom/optional name
    name = userInput.readLine(); //user full name, optional. for customization
    if (name.equals("")) {
      name = nick;
    }

    System.out.print("User: ");
    String user; //instantize string holder for user sign-in name
    user = userInput.readLine(); //users sign in user name, can be password protected
    System.out.println();
    if (user.equals("")) {
      System.out.println("ERROR: no username given");
      System.exit(0);
    }

    //userInput.close();

    System.out.println("/***********************************************/");
    System.out.println("RECEIVED BY SERVER:");
    System.out.println("Hostname: " + host + "\nPort: " + port
            + "\nNickname: " + nick + "\nFull name: " + name
            + "\nUser: " + user);
    System.out.println("/***********************************************/");
    System.out.println();

    Socket clientSocket = null;
    BufferedReader inFromServer = null;
    DataOutputStream outFromClient = null;

    try {
      clientSocket = new Socket(host, port);
      inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      outFromClient = new DataOutputStream(clientSocket.getOutputStream());


      if (clientSocket != null
          && inFromServer != null
          && outFromClient != null) {

        outFromClient.writeBytes("\nNICK " + nick + "\r\n"); 
        outFromClient.writeBytes("\nUSER " + user + " " + host + " 69 :" + name + "\r\n");

        boolean joinF = true;
        String serverMsg;
        String key = "";
        while (((serverMsg = inFromServer.readLine()) != null) && (joinF == true)){
          if (serverMsg.startsWith("PING")) { 
            joinF = false;     
            System.out.println(serverMsg);
            String tempy = serverMsg.substring(5);
            key = tempy;
            System.out.println("PONG " + key);
            outFromClient.writeBytes("\nPONG " + key + "\r\n");
            //outFromClient.writeBytes("JOIN #TeamSameTeam :" 
            //                         + serverMsg + "\r\n");      
          } else {
            System.out.println(serverMsg);
          }
          if (serverMsg.contains("433")) {   
            System.out.println("ERROR: username is already in use!");
            System.exit(0);
          }
          if (joinF == false) {
            while (((serverMsg = inFromServer.readLine()) != null)) {
              System.out.println(serverMsg);
              if (serverMsg.contains("376")) {
                serverMsg = inFromServer.readLine();
                outFromClient.writeBytes("\nJOIN #TeamSameTeam :" + key + "\r\n");
                while (((serverMsg = inFromServer.readLine()) != null)) {
                  System.out.println(serverMsg);
                  if (serverMsg.contains("366")) {
                    break;
                  }
                }
                break;
              }
            }
            break;
          }
        }
        boolean isRunning = true; 
        boolean channelF = true;
        String serverMsgE = inFromServer.readLine();
        String channelMsg = null;
        while (isRunning) {
          if (!(channelMsg = userInput.readLine()).equals(null)) {        
            outFromClient.writeBytes("\nPRIVMSG #TeamSameTeam :" + channelMsg + "\r\n");
            System.out.println(channelMsg);
          }
          if (channelF == true) {
            System.out.println(serverMsgE);
            channelF = false; 
          } 
          if (serverMsgE.startsWith("PRIVMSG")) {
            System.out.println(serverMsgE);
          }
          if (serverMsgE.startsWith("PING")) {
            System.out.println(serverMsgE);
            System.out.println("PONG " + serverMsgE.substring(5));
            outFromClient.writeBytes("\nPONG " + serverMsgE.substring(5) + "\r\n");
          } 
        }
      } 
    } catch (NullPointerException e) {
      System.out.println("ERROR: a connection could not be established!");
    }
  }
}
