package Domain.SaveLoad;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

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

    }
}
