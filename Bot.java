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
        if (MSG.substring(0,5).equals("!time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": the time is now " + time);
	      }
        else if (MSG.substring(0,7).equals("!facto ")) {
            int n = 1;
            int m = 1;
            int facto = 1;
            n = Integer.parseInt(MSG.substring(7,MSG.length())); 
            if (n < 0) {
               sendMessage(channel, sender + ": the number should not be negative!");
            } else {
                for (m = 1; m <= n; m++)
                 facto = facto*m;
 
                 sendMessage(channel, sender + ": the factorial of " + n + " is " + facto);
            }             
        }
        else if (MSG.substring(0,5).equals("!fib ")) {
            int n1 = 0;
            int n2 = 1;
            int n3;
            int i;
            String sequence = "";
            int count = Integer.parseInt(MSG.substring(5,MSG.length()));
            if (count >= 48) {
              String error = "Error: Enter a number less than 48.";
              sendMessage(channel,sender + ": " + error);
            } else {
              sendMessage(channel, sender + ": the first " +  count + " Fibonacci numbers are: ");
              for (i = 2; i < count; i++) {
                n3 = n1 + n2;
                sequence = sequence + Integer.toString(n3) + " ";
                n1 = n2;
                n2 = n3;
              }
            }
            sendMessage(channel, sender + ": " + sequence); 
         }
         else if (MSG.substring(0,6).equals("!fahr ")) {
	           float temp = Float.parseFloat(MSG.substring(6,MSG.length()));
             temp = ((temp-32)*5)/9;
             String cel = "temperature in Celsius: " + temp;
             sendMessage(channel, sender + ": " + cel);
         }
         else if (MSG.substring(0,5).equals("!cel ")) {
             float temp = Float.parseFloat(MSG.substring(5,MSG.length()));
             temp = 9*(temp/5)+32;
             String fahr = "temperature in Fahrenheit: " + temp;
             sendMessage(channel, sender + ": " + fahr);
         }
         else if (MSG.substring(0,7).equals("!palin ")) {
             String orig = MSG.substring(7,MSG.length());
             String rev = "";
             String senOut;
             int len = orig.length();
             for (int i = len - 1; i >= 0; i--) {
               rev = rev + orig.charAt(i);
             }
             if (orig.equals(rev)) {
               senOut = orig + " is a palindrome.";
               sendMessage(channel, sender + ": " + senOut);
             } else {
               senOut = orig + " is not a palindrome.";
               sendMessage(channel, sender + ": " + senOut);
             }
        }
        else if (MSG.substring(0,5).equals("!rev ")) {
             String orig = MSG.substring(5,MSG.length());
             String rev = "";
             int len = orig.length();
             for (int i = len - 1; i >= 0; i--) {
               rev = rev + orig.charAt(i);
             }
             sendMessage(channel, sender + ": " + rev);
        }
        else if (MSG.substring(0,5).equals("!cal ")) {
             String equation = MSG.substring(5,MSG.length());
             if (equation.contains("+")) {
               String[] parts = equation.split("\\+");
               //how do i make it to iterate through multiple parts to not just have only two numbers               
               Float num1 = Float.parseFloat(parts[0].toString());
               Float num2 = Float.parseFloat(parts[1].toString());
               String ans = Float.toString(num1 + num2);
               sendMessage(channel, sender + ": " + ans);
             } else if (equation.contains("-")) {
               String[] parts = equation.split("\\-");
               //iterate
               Float num1 = Float.parseFloat(parts[0].toString());
               Float num2 = Float.parseFloat(parts[1].toString());
               String ans = Float.toString(num1 - num2);
               sendMessage(channel, sender + ": " + ans);
             } else if (equation.contains("/")) {
               String[] parts = equation.split("\\/");
               //iterate
               Float num1 = Float.parseFloat(parts[0].toString());
               Float num2 = Float.parseFloat(parts[1].toString());
               String ans = Float.toString(num1/num2);
               sendMessage(channel, sender + ": " + ans);
             } else if (equation.contains("%")) {
               String[] parts = equation.split("\\%");
               //iterate
               Float num1 = Float.parseFloat(parts[0].toString());
               Float num2 = Float.parseFloat(parts[1].toString());
               String ans = Float.toString(num1 % num2);
               sendMessage(channel, sender + ": " + ans);
             } else if (equation.contains("*")) {
               String[] parts = equation.split("\\*");
               //iterate
               Float num1 = Float.parseFloat(parts[0].toString());
               Float num2 = Float.parseFloat(parts[1].toString());
               String ans = Float.toString(num1 * num2);
               sendMessage(channel, sender + ": " + ans);
             } else {
               String error = "Error: Enter correct parameters";
               sendMessage(channel, sender + ": " + error);
             }
        }




   }
}
