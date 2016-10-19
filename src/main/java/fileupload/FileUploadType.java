package fileupload;

public enum FileUploadType {

	GROUPS("Clientes"), 
	PROFESSORS("Pagos"),
	STUDENTS("Estudiantes"),
	PROGRAM("Programa");
	
	private final String value;

	private FileUploadType (String value) {
		this.value = value;
	}

	public String getValue () {
		return value;
	}
}
