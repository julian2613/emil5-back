package co.com.emil5.test.excepcion;

public class DatosExcepcion extends Exception {

	private static final long serialVersionUID = 7741044191045786425L;

	public DatosExcepcion(String msg) {
		super(msg);
	}

	public DatosExcepcion(Throwable cause) {
		super(cause);
	}

}
