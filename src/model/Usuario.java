package model;

public class Usuario {
	
	public String getUsuarioID() {
		return UsuarioID;
	}
	public void setUsuarioID(String usuarioID) {
		UsuarioID = usuarioID;
	}
	public String getUsuarioNombre() {
		return UsuarioNombre;
	}
	public void setUsuarioNombre(String usuarioNombre) {
		UsuarioNombre = usuarioNombre;
	}
	public String getUsuarioPassw() {
		return UsuarioPassw;
	}
	public void setUsuarioPassw(String usuarioPassw) {
		UsuarioPassw = usuarioPassw;
	}
	public String getUsuarioActivo() {
		return UsuarioActivo;
	}
	public void setUsuarioActivo(String usuarioActivo) {
		UsuarioActivo = usuarioActivo;
	}
	/*public int getTipoUsuarioID() {
		return TipoUsuarioID;
	}
	public void setTipoUsuarioID(int tipoUsuarioID) {
		TipoUsuarioID = tipoUsuarioID;
	}*/
	public TipoUsuario getTipoUsuario() {
		return TipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}
	public Persona getPersona() {
		return Persona;
	}
	public void setPersona(Persona persona) {
		Persona = persona;
	}
	public String getUsuarioCorreo() {
		return UsuarioCorreo;
	}
	public void setUsuarioCorreo(String usuarioCorreo) {
		UsuarioCorreo = usuarioCorreo;
	}
	
	String UsuarioID;
	String UsuarioNombre;
	String UsuarioPassw;
	String UsuarioActivo;
	String UsuarioCorreo;
	//int TipoUsuarioID;
	TipoUsuario TipoUsuario;
	Persona Persona;
}
