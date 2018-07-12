package commands;

import org.json.JSONObject;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;

public class WikiCommand {

    public static void handleMessage(DiscordAPI api, Message message) {
        String[] splitMessage = message.getContent().split(" ", 3);
        String url = getLikelyResult(splitMessage[1]);
        message.reply(url);
    }

    public static String getLikelyResult(String name) {
        String urlBase = "http://oldschoolrunescape.wikia.com/api/v1/Search/List/";
        try {
            JSONObject jsonBody = Unirest
                    .get(urlBase)
                    .queryString("query", name)
                    .queryString("limit", "1")
                    .asJson()
                    .getBody()
                    .getObject();

            return (String) jsonBody.getJSONArray("items").getJSONObject(0).get("url");

        } catch(UnirestException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return name;
    }

}
