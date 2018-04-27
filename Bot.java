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
        String MSG = message.toLowerCase();
        if (MSG.substring(1,5).equals("time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
	} else if (MSG.substring(1,4).equals("fib")) {
            int n1 = 0;
            int n2 = 1;
            int n3;
            int i;
            String sequence = "";
            int count = Integer.parseInt(MSG.substring(4,MSG.length()));
            if (count >= 48) {
              String error = "Error: Enter a number less than 48.";
              sendMessage(channel,sender + ": " + error);
            } else {
              sendMessage(channel, sender + ": The First " +  count + " Fibonacci numbers are: ");
              for (i = 2; i < count; i++) {
                n3 = n1 + n2;
                sequence = sequence + Integer.toString(n3) + " ";
                n1 = n2;
                n2 = n3;
              }
            }
            sendMessage(channel, sender + ": " + sequence); 
         } else if (MSG.substring(1,5).equals("fahr")) {
	     float temp = Float.parseFloat(MSG.substring(5,MSG.length()));
             temp = ((temp-32)*5)/9;
             String cel = "Temperature in Celsius: " + temp;
             sendMessage(channel, sender + ": " + cel);
         } else if (MSG.substring(1,4).equals("cel")) {
             float temp = Float.parseFloat(MSG.substring(4,MSG.length()));
             temp = 9*(temp/5)+32;
             String fahr = "Temperature in Fahrenheit: " + temp;
             sendMessage(channel, sender + ": " + fahr);
         } else if (MSG.substring(1,6).equals("palin")) {
             String orig = MSG.substring(6,MSG.length());
             String rev = "";
             String senOut;
             int len = orig.length();
             for (int i = len - 1; i >= 0; i--) {
               rev = rev + orig.charAt(i);
             }
             if (orig.equals(rev)) {
               senOut = "Entered string is a palindrome.";
               sendMessage(channel, sender + ": " + senOut);
             } else {
               senOut = "Entered string is not a palindrome.";
               sendMessage(channel, sender + ": " + senOut);
             }
        } else if (MSG.substring(1,4).equals("rev")) {
             String orig = MSG.substring(4,MSG.length());
             String rev = "";
             int len = orig.length();
             for (int i = len - 1; i >= 0; i--) {
               rev = rev + orig.charAt(i);
             }
             sendMessage(channel, sender + ": " + rev);
        }
   }
}
