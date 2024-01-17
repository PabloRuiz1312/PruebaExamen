package es.iesjandula.prueba_examen.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Pablo Ruiz Canovas
 *
 */
public class Json 
{
	private static ObjectMapper mapper;
	
	public static ObjectMapper mapper()
	{
		if(Json.mapper!=null)
		{
			return Json.mapper;
		}
		Json.createJson();
		return Json.mapper;
	}
	
	private static void createJson()
	{
		Json.mapper = new ObjectMapper();
	}
}
