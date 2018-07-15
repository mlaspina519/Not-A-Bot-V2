package commands;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import java.util.Random;

public class RandomPrntscCommand {

    public static void handleMessage(DiscordAPI api, Message message) {
        String url = "https://prnt.sc/";
        String randomCharacters = "01234567890abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random();

        for(int i = 0; i < 6; i++) {
            int index = rand.nextInt(randomCharacters.length() - 1);
            url += randomCharacters.charAt(index);
        }

        message.reply(url);
    }
}
