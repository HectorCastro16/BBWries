package model;

public class Persona {
	
	public int getPersonaID() {
		return PersonaID;
	}
	public void setPersonaID(int personaID) {
		PersonaID = personaID;
	}
	public String getPersonaNombre() {
		return PersonaNombre;
	}
	public void setPersonaNombre(String personaNombre) {
		PersonaNombre = personaNombre;
	}
	public String getPersonaApellidos() {
		return PersonaApellidos;
	}
	public void setPersonaApellidos(String personaApellidos) {
		PersonaApellidos = personaApellidos;
	}
	public int getPersonaDni() {
		return PersonaDni;
	}
	public void setPersonaDni(int personaDni) {
		PersonaDni = personaDni;
	}
	public Usuario getUsuario() {
		return Usuario;
	}
	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}
	public String getPersonaActivo() {
		return PersonaActivo;
	}
	public void setPersonaActivo(String personaActivo) {
		PersonaActivo = personaActivo;
	}
	
	public String getPersonaImagen() {
		return PersonaImagen;
	}
	public void setPersonaImagen(String personaImagen) {
		PersonaImagen = personaImagen;
	}
	public String getPersonaComentario() {
		return PersonaComentario;
	}
	public void setPersonaComentario(String personaComentario) {
		PersonaComentario = personaComentario;
	}
	
	int PersonaID;
	String PersonaNombre;
	String PersonaApellidos;
	int PersonaDni;
	Usuario Usuario;
	String PersonaActivo;
	String PersonaImagen;
	String PersonaComentario;
}
