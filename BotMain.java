import org.jibble.pircbot.*;

public class BotMain {
    public static void main(String[] args) throws Exception {  
        Bot bot = new Bot(); //create a new bot object
        bot.setVerbose(true); //enable debugger
        bot.connect("irc.synirc.net"); //connect to server
        bot.joinChannel("#TeamSameTeam"); //join channel
    }
}
