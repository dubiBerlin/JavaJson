package de.video2brain.json;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;

public class StreamingWriter {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		Map<String, Object> config = new HashMap<String, Object>();
		config.put(JsonGenerator.PRETTY_PRINTING, true);
		
		JsonGeneratorFactory factory = Json.createGeneratorFactory(config);
		JsonGenerator generator = factory.createGenerator(new FileOutputStream("written_json_movie2.json"));
			
		generator.writeStartArray().
			writeStartObject().
				write("name", "The Matrix").
				writeStartArray("actors").
					write("Keanu Reeves").
					write("Laurence Fishbourne").
					write("Carrie-Ann Moss").
					writeEnd().
				write("year", 1999).
				write("isGood", true).
				writeEnd().
			writeStartObject().
			write("name", "The Matrix Reloaded").
			writeStartArray("actors").
				write("Keanu Reeves").
				write("Laurence Fishbourne").
				write("Carrie-Ann Moss").
				writeEnd().
			write("year", 2003).
			write("isGood", false).
			writeEnd().
		writeEnd();	
		
		generator.close();
	}		

}
