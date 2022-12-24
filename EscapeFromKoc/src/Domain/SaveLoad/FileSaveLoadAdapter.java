package Domain.SaveLoad;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import Domain.Game.Building;
import com.google.gson.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

public class FileSaveLoadAdapter implements ISaveLoadAdapter {

    private FileSaveLoad fileSaveLoad;
    private SaveObject currSave;

    public FileSaveLoadAdapter() {
        this.fileSaveLoad = new FileSaveLoad();
        this.currSave = new SaveObject();
    }

    @Override
    public void save() {
        System.out.println("saved game after building mode... ");
        this.fileSaveLoad.write(currSave);
    }

    @Override
    public void load() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
        System.out.println("read  game after login completed... ");
        JsonObject jo = this.fileSaveLoad.read();

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        JsonPrimitive loginName = jo.getAsJsonPrimitive("playerName"); //shooter inventory
        System.out.println("login name is: " + loginName);

        JsonArray buildingsObj = (JsonArray) jo.getAsJsonArray("building_mode_data");
        //CopyOnWriteArrayList<Building> onScreenbuildingList = new CopyOnWriteArrayList<Building>();
        JsonObject first_building = buildingsObj.get(0).getAsJsonObject();
        System.out.println("buildingsObj is: " + first_building.get("buildingName"));


    }
}
