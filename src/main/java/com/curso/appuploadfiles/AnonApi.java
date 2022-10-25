/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.appuploadfiles;

import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import java.io.*;
import java.net.URL;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;

/**
 * 
 * @author miromero
 */
public class AnonApi {
    /*
     * API Token for account uploading or anything of the sort.
     */
    private String apiToken;
    /**
     * GSON instantiation
     */
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Constructor which passes Apitoken
     * @param apiToken
     */
    public AnonApi(String apiToken) {
            this.apiToken = apiToken;
        }
    

    /**
     * Contact's AnonAPI with a 'post' request to upload the specified file.
     * @param file - File to upload
     * @return - URL which can be reformed into a string.
     */
    public String upload(File file) {
       try {
           /* Creating response */
           HttpResponse<JsonNode> response = Unirest.post("https://api.anonfiles.com/upload").field("file", file).asJson();
           System.out.println("Successful upload");
           /* Instantiating body as a JSONObject */
           JSONObject object = response.getBody().getObject();
           /* Creating a new string combining the data, file, url, with the string short */
           String url = object.getJSONObject("data")
                   .getJSONObject("file")
                   .getJSONObject("url")
                   .getString("full");
           /* returning the body */
           return new URL(url).toString();
       }catch(Exception e) {
           throw new PostRequestException();
       }
    }

}
