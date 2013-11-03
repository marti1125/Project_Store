package enums;

public enum Estado {
	V("Vacio"), P("5 Productos");

	public String descripcion;

	private Estado(String descripcion) {
		this.descripcion = descripcion;
	}
}
