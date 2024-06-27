package es.tiendazara.web.common.exception;

public class ServicioException extends Exception {
	
	private String code;

	public ServicioException(String code) {
		super();
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}

}
