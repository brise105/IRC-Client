/**
*  this program this is the entry point for the bot. 
*  there is where the bot sets its connection info.
*
*  @author: Brandon Briseno & Alfonso Castanos
*  Email:  brise105@mail.chapman.edu & casta145@mail.chapman.edu
*  Date:  5/6/2018
*  @version: 2.0
*/

import org.jibble.pircbot.IrcException;
//import org.jibble.pircbot.NickAlreadyInUseException;
import org.jibble.pircbot.OutputThread;
import org.jibble.pircbot.PircBot;
//import org.jibble.pircbot.ReplyConstants;
//import org.jibble.pircbot.User;

class BotMain {
  public static void main(String[] args) throws Exception {  
    Bot bot = new Bot(); //create a new bot object
    bot.setVerbose(true); //enable debugger
    bot.connect("irc.synirc.net"); //connect to server
    bot.joinChannel("#TeamSameTeam"); //join channel
  }
}
