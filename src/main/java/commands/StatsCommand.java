package commands;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.embed.EmbedBuilder;

public class StatsCommand {

    public static void handleMessage(DiscordAPI api, Message message) {
        String[] splitMessage = message.getContent().split(" ", 3);
        String username = splitMessage[1];
        String backgroundImage = getBackgroundImage(splitMessage);
        String url = "http://www.07tracker.com/sig/" + username + "/" + backgroundImage + ".png";
        EmbedBuilder embed = new EmbedBuilder();

        embed.setImage(url);
        message.reply("Stats for " + username, embed);
    }

    public static String getBackgroundImage(String[] splitMessage) {
        String imageUrl = "varrock";

        if(splitMessage.length == 3) {
            imageUrl = splitMessage[2].replace(" ", "_");
        }

        return imageUrl;
    }
}
