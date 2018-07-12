package commands;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;

import java.util.concurrent.ThreadLocalRandom;

public class RollCommand {

    public static void handleMessage(DiscordAPI api, Message message) {
        int firstNum = 1;
        int lastNum = 100;
        int randomNum = ThreadLocalRandom.current().nextInt(firstNum, lastNum);

        message.reply(Integer.toString(randomNum));
    }
}
