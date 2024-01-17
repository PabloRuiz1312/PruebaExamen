package es.iesjandula.prueba_examen.exception;

/**
 * 
 * @author Pablo Ruiz Canovas
 */
public class XMLException extends Exception
{
	/**Serial version UID */
	private static final long serialVersionUID = -4121231776169178842L;

	/**
	 * Constructor that creates a exception using a message and a exception object
	 * @param message
	 * @param ex
	 */
	public XMLException (String message,Exception ex)
	{
		super(message,ex);
	}
	
	/**
	 * Constructor that creates a exception using a message and a exception object
	 * @param message
	 * @param ex
	 */
	public XMLException (Exception ex)
	{
		super(ex);
	}
}
