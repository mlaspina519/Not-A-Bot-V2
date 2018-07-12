package core;

import commands.WikiCommand;
import org.json.simple.JSONObject;
import com.google.common.util.concurrent.FutureCallback;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

import commands.PingPongCommand;
import commands.RollCommand;
import commands.StatsCommand;

public class Bot {

    public Bot() {
        JSONObject jsonObject = Utils.getJsonObjectFromFile("apiKeys.json");

        final String discordKey = (String) jsonObject.get("discord");
        //final String twitchKey = (String) jsonObject.get("twitch");

        DiscordAPI api = Javacord.getApi(discordKey, true);

        // connect
        api.connect(new FutureCallback<DiscordAPI>() {
            public void onSuccess(DiscordAPI api) {

                api.registerListener(new MessageCreateListener() {
                    @Override
                    public void onMessageCreate(DiscordAPI api, Message message) {
                        String[] splitMessage = message.getContent().toLowerCase().split(" ", 3);
                        switch (splitMessage[0]) {
                            case "!ping":
                                PingPongCommand.handleMessage(api, message);
                                break;
                            case "!roll":
                                RollCommand.handleMessage(api, message);
                                break;
                            case "!stats":
                                StatsCommand.handleMessage(api, message);
                                break;
                            case "!wiki":
                                WikiCommand.handleMessage(api, message);
                                break;
                        }

                    }
                });
            }

            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }
}


