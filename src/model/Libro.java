package model;

import java.sql.Date;

public class Libro {
	
	String LibroCodigo;
	String LibroNombre;
	String LibroDescripcion;
	int LibroCantidad;
	String LibroAutor;
	
	Date LibroFechaRegistro;
	String LibroActivo;
	/* int TipoLibro;*/
	int LibroID;	
	Tipolibro tipolibro;
	
	String LibroImagen;
	String LibroArchivoPdf;
	
	public String getLibroArchivoPdf() {
		return LibroArchivoPdf;
	}
	public void setLibroArchivoPdf(String libroArchivoPdf) {
		LibroArchivoPdf = libroArchivoPdf;
	}
	public String getLibroImagen() {
		return LibroImagen;
	}
	public void setLibroImagen(String libroImagen) {
		LibroImagen = libroImagen;
	}
	public int getLibroID() {
		return LibroID;
	}
	public void setLibroID(int libroID) {
		LibroID = libroID;
	}
	public String getLibroCodigo() {
		return LibroCodigo;
	}
	public void setLibroCodigo(String libroCodigo) {
		LibroCodigo = libroCodigo;
	}
	public String getLibroNombre() {
		return LibroNombre;
	}
	public void setLibroNombre(String libroNombre) {
		LibroNombre = libroNombre;
	}
	public String getLibroDescripcion() {
		return LibroDescripcion;
	}
	public void setLibroDescripcion(String libroDescripcion) {
		LibroDescripcion = libroDescripcion;
	}
	public int getLibroCantidad() {
		return LibroCantidad;
	}
	public void setLibroCantidad(int libroCantidad) {
		LibroCantidad = libroCantidad;
	}
	public String getLibroAutor() {
		return LibroAutor;
	}
	public void setLibroAutor(String libroAutor) {
		LibroAutor = libroAutor;
	}
	public Date getLibroFechaRegistro() {
		return LibroFechaRegistro;
	}
	public void setLibroFechaRegistro(Date libroFechaRegistro) {
		LibroFechaRegistro = libroFechaRegistro;
	}
	public String getLibroActivo() {
		return LibroActivo;
	}
	public void setLibroActivo(String libroActivo) {
		LibroActivo = libroActivo;
	}
	/*public int getTipoLibro() {
		return TipoLibro;
	}
	public void setTipoLibro(int tipoLibro) {
		TipoLibro = tipoLibro;
	}*/
	
	public Tipolibro getTipolibro() {
		return tipolibro;
	}
	public void setTipolibro(Tipolibro tipolibro) {
		this.tipolibro = tipolibro;
	}
	
}
