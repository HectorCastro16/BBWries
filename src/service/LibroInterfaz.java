package service;
import java.util.List;

import model.Libro;

public interface LibroInterfaz {
	/*LISTAS*/
	public List listaLibroDao() throws Exception;
	public List listaLibroTotalDao() throws Exception;
	/*INGRESOS*/
	public boolean ingresoLibroDao(Libro libro) throws Exception;
	
	/*Lista Destacados*/
	public List listadoLibrosDestacadosDao() throws Exception;
	
	// busca libro objeto 
	public Libro BuscaLibroIdObjetoDao(int id) throws Exception;
	// para actualizar libro
	public boolean ActualizarLibroDao(Libro libro) throws Exception;
	// para eliminar libro
	public boolean EliminadoLogicoLibroDao(int id) throws Exception;
	
	// para buscar por id
	public List BuscaLibroIdDao(int id) throws Exception;
}
