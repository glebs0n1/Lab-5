package net.GLEB.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import net.GLEB.App.ObjectInterfaces.StoredType;

import java.io.*;

public class JSONWorker implements Workerable {
    private final Gson gson;
    public JSONWorker(JsonDeserializer<? extends Object> des) {
        GsonBuilder builder;
        builder = new GsonBuilder();
        gson = builder.create();
    }

    @SuppressWarnings("unchecked")
    public Object readValue(String json, Class cls){
        try {
            return (gson).fromJson(json, cls);
        }catch (NullPointerException e){
            return "File is broken";
        }
    }

    public String writeValue(Object object){
        return (new GsonBuilder().setPrettyPrinting().create()).toJson(object);
    }

    public Object load(String filename, Class cls){
        try {
            Object object;
            BufferedReader file = new BufferedReader(new FileReader(new File(filename)));
            StringBuilder jsonBuilder;
            jsonBuilder = new StringBuilder();
            int c;
            while(file.ready()){
                String string = Character.toString((char)(file.read()));
                jsonBuilder.append(string);
            }
            String json = jsonBuilder.toString();
            object =  cls.cast( readValue(json, cls));
            file.close();
            return object;
        }
        catch (FileNotFoundException e){
            return null;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassCastException e){
            return "File is broken";
        }
        return null;
    }

    public void save(Object objects, String filename) {
        try{
            BufferedOutputStream file = new BufferedOutputStream(new FileOutputStream(filename));
            String json;
            json = writeValue(objects);
            byte[] buffer = json.getBytes();
            file.write(buffer);
            file.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}