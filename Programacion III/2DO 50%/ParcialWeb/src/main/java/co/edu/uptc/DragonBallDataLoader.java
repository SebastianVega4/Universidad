package co.edu.uptc;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class DragonBallDataLoader {
    public static List<DragonBallCharacter> loadDragonBallCharacters(InputStream inputStream) throws IOException {
        Type type = new TypeToken<List<DragonBallCharacter>>() {}.getType();
        try (InputStreamReader reader = new InputStreamReader(inputStream)) {
            return new Gson().fromJson(reader, type);
        }
    }
    public static String toJson(List<DragonBallCharacter> characters) {
        return new Gson().toJson(characters);
    }
}