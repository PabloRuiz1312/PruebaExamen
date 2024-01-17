package es.iesjandula.prueba_examen.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Pablo Ruiz Canovas
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Competition 
{
	/**Competition id */
	private int id = 0;
	/**Season id */
	private int seasonId = 0;
	/**Country name */
	private String countryName;
	/**Competition name */
	private String competitionName;
	/**Competition gender */
	private String competitionGender;
	/**Competition youth */
	private boolean competitionYouth;
	/**International */
	private boolean international;
	/**Season name */
	private String seasonName;
	/**Match updated */
	private String updated;
	/**Match updated 360 */
	private String updated360;
	/**Available 360 */
	private String available360;
	/**Available match */
	private String availableMatch;
}
