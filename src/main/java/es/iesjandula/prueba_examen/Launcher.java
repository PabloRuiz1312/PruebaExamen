package es.iesjandula.prueba_examen;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.iesjandula.prueba_examen.exception.XMLException;
import es.iesjandula.prueba_examen.models.Competition;
import es.iesjandula.prueba_examen.utils.ParseJSON;
import es.iesjandula.prueba_examen.utils.ParseXML;

/**
 * 
 * @author Pablo Ruiz Canovas
 */
public class Launcher 
{
	/**Class logger */
	private static Logger log = LogManager.getLogger();
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String [] args)
	{
		ParseXML parseXML = new ParseXML();
		ParseJSON parseJson = null;
		try
		{
			List<Competition> comps = parseXML.parseList();
			parseJson = new ParseJSON(comps);
			parseJson.writeJson();
		}
		catch(XMLException ex)
		{
			log.error("Error",ex);
		}
		
	}
}
