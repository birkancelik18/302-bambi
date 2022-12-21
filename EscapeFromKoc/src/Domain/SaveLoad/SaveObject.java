package Domain.SaveLoad;

import Domain.Controllers.LoginController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Domain.Controllers.GameController;

import java.util.List;

public class SaveObject {

    private GameController currentGame;
    private LoginController login;
    private List<String> userNames;

    public SaveObject() {
        GameController game = GameController.getInstance();
        this.login = new LoginController(game);
        this.currentGame = game;
        this.userNames = login.getUsernameList();
    }

    public JsonObject generateSaveJson() {
        JsonObject save = new JsonObject();
        Gson gsonBuilder = new GsonBuilder().create();
        JsonParser jsonParser = new JsonParser();

        String onScreenPowerUpList = gsonBuilder.toJson(userNames);
        JsonArray onScreenPowerUpListJsonArray = JsonParser.parseString(onScreenPowerUpList).getAsJsonArray();
        save.add("userNames", onScreenPowerUpListJsonArray);

        return save;
    }

}
