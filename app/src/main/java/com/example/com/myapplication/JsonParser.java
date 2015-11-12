package com.example.com.myapplication;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
BY ABDUL KARIM
**/

	public class JsonParser {
	 
	    final String TAG = "JsonParser.java";
	 
	     InputStream is = null;
	     JSONObject jObj = null;
	     String json = "";
	 
	    public JSONObject getJSONFromUrl(String ul) {
	    	
	 
	    try{	URL url = new URL(ul);
	URLConnection connection = url.openConnection();
	//connection.addRequestProperty("Referer", "https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=%22mixorg.com%22&rsz=8");

	String line;
	StringBuilder builder = new StringBuilder();
	BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	while((line = reader.readLine()) != null) {
	 builder.append(line);
//	System.out.println(builder.toString());
	}
        json = builder.toString();
	 
	        } catch (Exception e) {
	            Log.e(TAG, "Error converting result " + e.toString());
	        }
	 
	        // try parse the string to a JSON object
	        try {
	            jObj = new JSONObject(json);
	        } catch (JSONException e) {
	            Log.e(TAG, "Error parsing data " + e.toString());
	        }catch(Exception e){
	        	
	        }
	 
	        // return JSON String
	      //  System.out.println(jObj.toString());
	        return jObj;
	    }
	}
    
