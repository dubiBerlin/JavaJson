package de.video2brain.json;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonStructure;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;

public class ObjectWriter {

	
	
	
	public static void main(String[] args) throws FileNotFoundException {
			
		JsonArrayBuilder builder = Json.createArrayBuilder();
		
		builder.add(
				Json.createObjectBuilder().
					add("name", "The Matrix").
					add("actors", 
							Json.createArrayBuilder().
								add("Keanu Reeves").
								add("Laurence Fishburne").
								add("Carrie-Ann Moss")
							).
					add("year", "1999").
					add("isGood", true)
				
				).add(
						Json.createObjectBuilder().
						add("name", "The Matrix Reloaded").
						add("actors", 
								Json.createArrayBuilder().
									add("Keanu Reeves").
									add("Laurence Fishburne").
									add("Carrie-Ann Moss")
								).
						add("year", "2003").
						add("isGood", false)
		);
		
		
		JsonStructure result =  builder.build();
		
		
		Map<String, Object> config = new HashMap<String, Object>();
		config.put(JsonGenerator.PRETTY_PRINTING, true);
		JsonWriterFactory factory = Json.createWriterFactory(config);
		
		JsonWriter writer = factory.createWriter(new FileOutputStream("written_json_movie.json"));
		writer.write(result);
		writer.close();
		
	}

}
