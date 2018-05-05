//Name: Brandon Briseno & Alfonso Castanos
//SID: 1932124 & 2283681
//Class: CPSC 353-02 (Dr. Fahy)
//Program description: this is the entry point for the bot. there is where we instantiatize our connection info.
//Version: 1.2

import org.jibble.pircbot.*;
//import Bot;

public class BotMain {
    public static void main(String[] args) throws Exception {  
        Bot bot = new Bot(); //create a new bot object
        bot.setVerbose(true); //enable debugger
        bot.connect("irc.synirc.net"); //connect to server
        bot.joinChannel("#TeamSameTeam"); //join channel
    }
}
