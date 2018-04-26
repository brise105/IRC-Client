import org.jibble.pircbot.*;
import java.lang.*;
import java.io.*;
import java.util.*;

public class Bot extends PircBot {
    public Bot() {
    this.setName("Gamabot");
    }
    public void onMessage(String channel, String sender,
                          String login, String hostname, String message) {
        if (message.equalsIgnoreCase("time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
	} else if (message.equalsIgnoreCase("fibonacci")) {
            int n1 = 0;
            int n2 = 1;
            int n3;
            int i;
            int count = 20;
            String sequence = "";
            sendMessage(channel, sender + ": The First " +  count + " Fibonacci numbers are: ");
            for (i = 2; i < count; i++) {
              n3 = n1 + n2;
              sequence = sequence + Integer.toString(n3) + " ";
              n1 = n2;
              n2 = n3;
            }
            sendMessage(channel, sender + ": " + sequence); 
       // }else if (message.equalsIgnoreCase("message")) {
	   // sendMessage(channel, sender + ": Enter Numbers");
            
            //sendMessage(channel, sender + ": " + numbers);
        }
    }
}
