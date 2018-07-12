package commands;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;

public class PingPongCommand {
    public static void handleMessage(DiscordAPI api, Message message) {
        message.reply("pong");
    }
}
