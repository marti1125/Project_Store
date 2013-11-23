package enums;

public enum Estado {
	V("Vacio"), P("Por Agotarse(mayor o igual a 5)");

	public String descripcion;

	private Estado(String descripcion) {
		this.descripcion = descripcion;
	}
}
