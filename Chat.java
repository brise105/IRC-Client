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
*  @version: 1.1
*/
import java.io.BufferedReader;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import java.net.UnknownHostException;

class Chat {
  public static void main(String[] args) throws Exception {
    //User Input:
    BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

    //standard delimiter for hostname:port number
    String portDelimiter = ":";

    //get user input
    System.out.print("Hostname (ex: irc.synirc.net:6697): ");
    String host; //instantize string holder for host name
    host = userInput.readLine(); //what the emails about
    int port; //instantize int holder for port number
    String[] parse = host.split(portDelimiter);

    host = parse[0]; //read line from beginning, up until ':' delimter is read
    port = Integer.parseInt(parse[1]); //read string array @index 0 after ':'

    System.out.print("Nickname: ");
    String nick; //instantize string holder for nickname/screen name
    nick = userInput.readLine(); //user's screen name

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

        outFromClient.writeBytes("NICK " + nick + "\r\n"); 
        outFromClient.writeBytes("USER " + user + " 0 * :" + name + "\r\n");
        outFromClient.writeBytes("JOIN #hellchannel \r\n");  

        String serverMsg;
        while ((serverMsg = inFromServer.readLine()) != null) {
          System.out.println(serverMsg);
          if (serverMsg.startsWith("PING")) {
            String pingContents = serverMsg.split(" ",2)[1];
            outFromClient.writeBytes("PONG" + pingContents);
          }
        }
        String clientMsg;

        outFromClient.close();
        inFromServer.close();
        clientSocket.close();
      }
    } catch (UnknownHostException e) {
      e.printStackTrace();
      System.out.println("ERROR: Hostname could not be found!");
    }
  }
}
