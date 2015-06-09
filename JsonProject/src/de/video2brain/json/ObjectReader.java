package de.video2brain.json;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonString;
import javax.json.JsonStructure;
import javax.json.JsonValue;
import javax.json.JsonValue.ValueType;



public class ObjectReader {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		JsonReader reader = Json.createReader(new FileInputStream("movies.json"));
		JsonStructure root = reader.read();
		
		if(root.getValueType() == ValueType.OBJECT){
			
			JsonObject rootObject = (JsonObject)root;
			
			JsonValue name = rootObject.getJsonString("name");
			
			
			if(name != null && name.getValueType() == ValueType.STRING){
				
				System.out.println("NAME DES FILMS");
				System.out.println(((JsonString)name).getString());
				
			}
			
			/* Access to the actors */
			JsonArray actors = rootObject.getJsonArray("actors");
			
			if(actors!=null){
				for(int i = 0; i < actors.size(); i++){
					System.out.println(actors.getString(i));
				}
			}
			
			/* Access to the date */
			JsonNumber year = rootObject.getJsonNumber("year");
			
			if(year != null ){
				System.out.println("JAHR:");
				System.out.println(year.intValue());
			}
			
		}
		
		
	}

}
