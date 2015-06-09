package de.video2brain.json;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public class StringReader {

	public static void main(String[] args) throws FileNotFoundException {
		
		JsonParser parser = Json.createParser(new FileInputStream("movies.json"));
		
		boolean isReadingActors = false;
		boolean isReadingYear = false;
		boolean isReadingName = false;
		
		
		StringBuilder actors = new StringBuilder();
		String name = "";
		int year = 0;
		
		while(parser.hasNext()){
			Event event = parser.next();
			
			switch(event){
				
				case VALUE_FALSE:
				case VALUE_TRUE:
				case VALUE_NUMBER:
				case VALUE_STRING:
					
					if(isReadingActors){
						String actor = parser.getString();
						actors.append(actor+"\n");
					}else{
						if(isReadingYear){
							year = parser.getInt();
						}else{
							if(isReadingName){
								name = parser.getString();
							}
						}
					}
					isReadingName = false;
					isReadingYear = false;
					break;
				case START_ARRAY:
					isReadingActors = true;
					break;
				case END_ARRAY:
					isReadingActors = false;
					break;
				case KEY_NAME:
					String nameOfField = parser.getString();
					if(nameOfField.equals("year")){
						isReadingYear = true;
					}else{
						if(nameOfField.equals("name")){
							isReadingName = true;
						}
					}
					break;
			}
			
		}
		System.out.println("FILMNAME");
		System.out.println(name);
		System.out.println("SCHAUSPIELER");
		System.out.println(actors.toString());
		System.out.println("JAHR");
		System.out.println(year);
	}

}
