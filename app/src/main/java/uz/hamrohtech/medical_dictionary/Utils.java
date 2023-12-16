package uz.hamrohtech.medical_dictionary;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Word> loadWordsFromJSON(Context context, String searchText) {
        List<Word> wordsList = new ArrayList<>();

        try {
            String json = loadJSONFromAsset(context, "words.json");
            JSONObject jsonObject = new JSONObject(json);
            JSONArray wordsArray = jsonObject.getJSONArray("words");

            for (int i = 0; i < wordsArray.length(); i++) {
                JSONObject wordObject = wordsArray.getJSONObject(i);
                String word = wordObject.getString("word");
                String definition = wordObject.getString("definition");

                // Check if the word contains the search text
                if (word.toLowerCase().contains(searchText.toLowerCase())) {
                    Word newWord = new Word(word, definition);
                    wordsList.add(newWord);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return wordsList;
    }



    private static String loadJSONFromAsset(Context context, String filename) {
        String json;
        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


}

