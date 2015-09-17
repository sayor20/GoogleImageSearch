package com.sayor.org.googleimagesearcher.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Sayor on 9/11/15.
 */
public class ImageResult {
    public String fullURL;
    public String thumbURL;
    public String title;

    public ImageResult(JSONObject object){
        try {
            this.fullURL = object.getString("url");
            this.thumbURL = object.getString("tbUrl");
            this.title = object.getString("title");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    static public ArrayList<ImageResult> fromJSONArray(JSONArray array ){
        ArrayList<ImageResult> result = new ArrayList<ImageResult>();
        for(int i=0;i<array.length();i++){
            try {
                result.add(new ImageResult(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
