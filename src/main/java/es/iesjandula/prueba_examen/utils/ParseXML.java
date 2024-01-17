package es.iesjandula.prueba_examen.utils;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import es.iesjandula.prueba_examen.exception.XMLException;
import es.iesjandula.prueba_examen.models.Competition;

/**
 * 
 * @author Pablo Ruiz Canovas
 */
public class ParseXML 
{
	/**Class logger */
	Logger log = LogManager.getLogger();
	/**XML file */
	private final File file;
	/**List that stores competitions */
	private List<Competition> competitions;
	
	/**
	 * Public constructor that creates a file to parse a xml
	 */
	public ParseXML()
	{
		this.file = new File("src/main/resources/competitions.xml");
		this.competitions = new LinkedList<Competition>();
	}
	
	public List<Competition> parseList() throws XMLException
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try
		{			
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			Document doc = db.parse(this.file);
			
			Element root = doc.getDocumentElement();
			
			NodeList node = root.getElementsByTagName("competition");
			
			for(int i = 0;i<node.getLength();i++)
			{
				Competition comp = null;
				Element nodeCompe = (Element) node.item(i);
				
				int id = Integer.parseInt(nodeCompe.getElementsByTagName("competition_id").item(0).getTextContent());
				int seasonId = Integer.parseInt(nodeCompe.getElementsByTagName("season_id").item(0).getTextContent());
				String countryName = nodeCompe.getElementsByTagName("country_name").item(0).getTextContent();
				String competitionName = nodeCompe.getElementsByTagName("competition_name").item(0).getTextContent();
				String competitionGender = nodeCompe.getElementsByTagName("competition_gender").item(0).getTextContent();
				boolean competitionYouth = Boolean.parseBoolean(nodeCompe.getElementsByTagName("competition_youth").item(0).getTextContent());
				boolean  international = Boolean.parseBoolean(nodeCompe.getElementsByTagName("competition_international").item(0).getTextContent());
				String seasonName = nodeCompe.getElementsByTagName("season_name").item(0).getTextContent();
				String matchUpdate = nodeCompe.getElementsByTagName("match_updated").item(0).getTextContent();
				String matchUpdate360 = nodeCompe.getElementsByTagName("match_updated_360").item(0).getTextContent();
				String available360 = nodeCompe.getElementsByTagName("match_available_360").item(0).getTextContent();
				String available = nodeCompe.getElementsByTagName("match_available").item(0).getTextContent();
				
				comp = new Competition(id,seasonId,countryName,competitionName,competitionGender,competitionYouth,international,seasonName,matchUpdate,matchUpdate360,available360,available);
				this.competitions.add(comp);
			}
		}
		catch(ParserConfigurationException | SAXException | IOException ex)
		{
			log.error("Error parsing the xml file",ex);
			throw new XMLException("Error parsing the xmk", ex);
		}
		return this.competitions;
	}
}
