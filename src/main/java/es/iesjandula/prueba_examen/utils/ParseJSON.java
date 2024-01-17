package es.iesjandula.prueba_examen.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectWriter;

import es.iesjandula.prueba_examen.models.Competition;

/**
 * 
 * @author Pablo Ruiz Canovas
 */
public class ParseJSON 
{
	/**Class logger */
	Logger log = LogManager.getLogger();
	/**Json file that write the comopetitions */
	private final File file; 
	/**List of competitions */
	private final List<Competition> comps;
	
	/**
	 * Constructor that initialize the list of competitions and creates the json file
	 * @param comps
	 */
	public ParseJSON(List<Competition> comps)
	{
		this.file = new File("src/main/resources/competitions.json");
		this.comps = comps;
	}
	/**
	 * Method that write the list of competitions to a json file
	 */
	public void writeJson() 
	{
		try
		{
			ObjectWriter writer = Json.mapper().writer(new DefaultPrettyPrinter());
			writer.writeValue(this.file, this.comps);
		}
		catch(IOException ex)
		{
			log.error("Error al escribir el json");
		}
	}
}
