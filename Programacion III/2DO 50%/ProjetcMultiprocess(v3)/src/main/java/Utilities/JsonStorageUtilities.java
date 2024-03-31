package Utilities;

import Model.Player;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonStorageUtilities {
    private Gson gson;
    private Type type;

    String FILEPATH = "/data.json";

    public JsonStorageUtilities(){
        gson = new GsonBuilder().setPrettyPrinting().create();
        type = new TypeToken<List<Player>>() {}.getType();
    }

    public List<Player> readContentFromFile() {
        List<Player> dataList = new ArrayList<>();

        try (InputStream inputStream = getClass().getResourceAsStream(FILEPATH);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            dataList = gson.fromJson(bufferedReader, type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public <Player> boolean saveDataToFile(List<Player> dataList, String fileName) {
        File file = new File(getClass().getResource(FILEPATH).getFile() + fileName + ".json");

        if (dataList == null) {
            dataList = new ArrayList<>();
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            gson.toJson(dataList, type, fileWriter);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}