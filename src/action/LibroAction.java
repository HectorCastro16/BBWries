package action;
import java.util.List;










//import jdk.nashorn.internal.runtime.ListAdapter;
import persistencia.LibroDao;
import persistencia.TipolibroDao;
import persistencia.UsuarioDao;
import model.Tipolibro;
import model.Libro;
import model.Usuario;

import com.opensymphony.xwork2.ActionSupport;
//import com.sun.org.apache.bcel.internal.generic.RETURN;
public class LibroAction extends ActionSupport{
	
	List<Libro>listadoLibros = null;
	List<Tipolibro>listadoTipoLibro = null;

	public List<Tipolibro> getListadoTipoLibro() {
		return listadoTipoLibro;
	}

	public void setListadoTipoLibro(List<Tipolibro> listadoTipoLibro) {
		this.listadoTipoLibro = listadoTipoLibro;
	}

	public List<Libro> getListadoLibros() {
	return listadoLibros;
	}

	public void setListadoLibros(List<Libro> listadoLibros) {
	this.listadoLibros = listadoLibros;
	}

	public String cargaDatosLibros() throws Exception{
		LibroDao libroDao = new LibroDao();
		TipolibroDao tipoLibroDao = new TipolibroDao();
		try {
			listadoLibros = libroDao.listaLibroDao();
			listadoTipoLibro = tipoLibroDao.listaTipoLibroDao();
			System.out.println("Exito carga listadoLibroAction");
		} catch (Exception e) {
			System.out.println("Error carga listadoLibroAction "+e.getMessage());
		}
		if(listadoLibros.isEmpty()==true){
			addActionError("No hay datos en el listado.");
			return ERROR;
		}else{
			addActionMessage("Listado de Libros Correcto.");
			return SUCCESS;
		}
	}
	/*----------------------------------------------------*/
	List<Libro>listadoTotalLibros = null;
	public List<Libro> getListadoTotalLibros() {
		return listadoTotalLibros;
	}
	public void setListadoTotalLibros(List<Libro> listadoTotalLibros) {
		this.listadoTotalLibros = listadoTotalLibros;
	}
	public String cargaDatosTotalLibros() throws Exception{
		LibroDao libroDao = new LibroDao();
		try {
			listadoTotalLibros = libroDao.listaLibroTotalDao();
			System.out.println("Exito al cargar listaTotalLibrosAction");
		} catch (Exception e) {
			System.out.println("Error al cargar listaTotalLibrosAction: "+e.getMessage());
		}
		if(listadoTotalLibros.isEmpty()==true){
			addActionError("No hay datos en el listado.");
			return ERROR;
		}else{
			addActionMessage("Listado de Libros Correcto.");
			return SUCCESS;
		}
	}

	/*----------------------------------------------------*/
	String LibroCodigoI;
	String LibroNombreI;
	String LibroDescripcionI;
	String Libroautor;
	int LibroCantidadI;
	Tipolibro TipoLibro;
	String LibroImagenI;
	String LibroArchivoPdfI;
	public String getLibroArchivoPdfI() {
		return LibroArchivoPdfI;
	}

	public void setLibroArchivoPdfI(String libroArchivoPdfI) {
		LibroArchivoPdfI = libroArchivoPdfI;
	}
	int idtipo;
	
	
	public String getLibroautor() {
		return Libroautor;
	}

	public void setLibroautor(String libroautor) {
		Libroautor = libroautor;
	}
	
	public int getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	public int getLibroCantidadI() {
		return LibroCantidadI;
	}

	public void setLibroCantidadI(int libroCantidadI) {
		LibroCantidadI = libroCantidadI;
	}

	public String getLibroImagenI() {
		return LibroImagenI;
	}

	public void setLibroImagenI(String libroImagenI) {
		LibroImagenI = libroImagenI;
	}
	
	public String getLibroCodigoI() {
		return LibroCodigoI;
	}

	public void setLibroCodigoI(String libroCodigoI) {
		LibroCodigoI = libroCodigoI;
	}

	public String getLibroNombreI() {
		return LibroNombreI;
	}

	public void setLibroNombreI(String libroNombreI) {
		LibroNombreI = libroNombreI;
	}

	public String getLibroDescripcionI() {
		return LibroDescripcionI;
	}

	public void setLibroDescripcionI(String libroDescripcionI) {
		LibroDescripcionI = libroDescripcionI;
	}

	
	public Tipolibro getTipoLibro() {
		return TipoLibro;
	}

	public void setTipoLibro(Tipolibro tipoLibro) {
		TipoLibro = tipoLibro;
	}
	
	public String IngresoLibro() throws Exception{
		boolean resultado =false;
		
		
		try {
			Libro libro = new Libro();
			Tipolibro tipolibro = new Tipolibro();
			tipolibro.setTipoLibroID(idtipo);
			libro.setLibroAutor(Libroautor.toUpperCase());
			libro.setLibroNombre(LibroNombreI.toUpperCase());
			libro.setLibroDescripcion(LibroDescripcionI.toUpperCase());
			libro.setLibroCantidad(LibroCantidadI);
			libro.setTipolibro(tipolibro);
			libro.setLibroImagen(LibroImagenI);
			libro.setLibroArchivoPdf(LibroArchivoPdfI);
			LibroDao libroDao = new LibroDao();
			resultado = libroDao.ingresoLibroDao(libro);
			System.out.print("Exito en al consulta IngresoLibro");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("Error en al consulta IngresoLibro");
			e.printStackTrace();
		}	
		cargaDatosTipoLibros();
		if(resultado == true){
			 LibroNombreI ="";
			 LibroDescripcionI ="";
			 Libroautor ="";
			 LibroCantidadI =0;			
			 LibroImagenI ="";
			 System.out.print("Ingreso el objeto Libro");
				addActionMessage("Libro Ingresado");
				return SUCCESS;
		}else {
			addActionError("Error al ingresar Libro ");
			return ERROR;
		}
	}
	
	 List<Tipolibro>lisTipolibros = null;
	 
	
	
	public List<Tipolibro> getLisTipolibros() {
		return lisTipolibros;
	}

	public void setLisTipolibros(List<Tipolibro> lisTipolibros) {
		this.lisTipolibros = lisTipolibros;
	}

	public String cargaDatosTipoLibros() throws Exception{
		TipolibroDao tipolibroDao= new TipolibroDao();
		try {
			lisTipolibros = tipolibroDao.listaTipoLibroDao();
			System.out.println("Exito al cargar listadoTipoLibroAction");
		} catch (Exception e) {
			System.out.println("Error al cargar listadoTipoLibroAction"+e.getMessage());
		}
		if(lisTipolibros.isEmpty()==true){
			addActionError("No hay datos en el listado tipo.");
			return ERROR;
		}else{
			addActionMessage("Listado de Tipo Libros Correcto");
			return SUCCESS;
		}
	}

	
	/*para libros destacados*/
	List <Libro> listadoLibroDestacados=null;

	public List<Libro> getListadoLibroDestacados() {
		return listadoLibroDestacados;
	}

	public void setListadoLibroDestacados(List<Libro> listadoLibroDestacados) {
		this.listadoLibroDestacados = listadoLibroDestacados;
	}
	
	public String cargaDatosDinamicosLibrosDestacados() throws Exception{
		LibroDao libroDao=new LibroDao();
		
		try{
			
			listadoLibroDestacados=libroDao.listadoLibrosDestacadosDao();
			System.out.println("Exito carga cargaDatosDinamicosLibrosDestacados");
			
		}catch(Exception e){
			System.out.println("Error carga cargaDatosDinamicosLibrosDestacados" + e.getMessage());
			e.printStackTrace();
		}
		//evaluacion si hay datos del listado
		if(listadoLibroDestacados.isEmpty()==true){
			addActionError("Ningun Libro Activo - Listado No Pasible");
			return ERROR;
		}else{
			addActionMessage("Listado de Libros Correcto");
			return SUCCESS;
		}
		
	}
	
Libro libro;	
int idBusqueda; 

	
public int getTip() {
	return tip;
}

public void setTip(int tip) {
	this.tip = tip;
}

public Libro getLibro() {
	return libro;
}

public void setLibro(Libro libro) {
	this.libro = libro;
}



public int getIdBusqueda() {
	return idBusqueda;
}

public void setIdBusqueda(int idBusqueda) {
	this.idBusqueda = idBusqueda;
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCod() {
	return cod;
}

public void setCod(String cod) {
	this.cod = cod;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getDes() {
	return des;
}

public void setDes(String des) {
	this.des = des;
}

public int getCan() {
	return can;
}

public void setCan(int can) {
	this.can = can;
}

public String getAut() {
	return aut;
}

public void setAut(String aut) {
	this.aut = aut;
}

public String getAct() {
	return act;
}

public void setAct(String act) {
	this.act = act;
}

public String getImg() {
	return img;
}

public void setImg(String img) {
	this.img = img;
}

public String getPdf() {
	return pdf;
}

public void setPdf(String pdf) {
	this.pdf = pdf;
}

int id;
int tip;
String cod;
String nom;
String des;
int can;
String aut;
String act;
String img;
String pdf;

public String BuscaLibroAction() throws Exception {
	LibroDao libroDao=new LibroDao();
	try {
		listadoLibroDestacados=libroDao.BuscaLibroIdDao(idBusqueda);
		System.out.println("Exito BuscaLibroAction");
	} catch (Exception e) {
		System.out.println("Error BuscaLibroAction" + e.getMessage()); 
		e.printStackTrace();
	}
	if (listadoLibroDestacados.isEmpty()) {
		addActionError("Verificar Datos - No Se Encuentra el Libro");
		return ERROR;
	} else {
		addActionMessage("Libro Encontrado");
		return SUCCESS;
	}
}

public String BuscaLibroObjetoAction() throws Exception {
		
		try {
			LibroDao libroDao = new LibroDao();
			libro = libroDao.BuscaLibroIdObjetoDao(idBusqueda);
			// para el combo dinamico
			tip = libro.getTipolibro().getTipoLibroID();
			System.out.println("Exito BuscaLibroObjetoAction");
		} catch (Exception e) {
			System.out.println("Error BuscaLibroObjetoAction"+ e.getMessage());
			e.printStackTrace();
		}

		if (libro.getLibroNombre() != null) {
			TipolibroDao tipoLibroDao = new TipolibroDao();
			// Se carga el listado del Select Dinamico
			listadoTipoLibro = tipoLibroDao.listaTipoLibroDao();
			
			addActionMessage("LIBRO: "+ libro.getLibroNombre().toString().toUpperCase()+" - BBWries ");
			return SUCCESS;
		} else {
			addActionError("Libro No Existe");
			return ERROR;
		}
	}
	
public String ActualizaLibroAction() throws Exception{
	boolean resultado = false;
	Libro libro =new Libro();
	
	try {
		libro.setLibroID(id);
		libro.setLibroNombre(nom.toUpperCase());
		
		Tipolibro tipoLibro = new Tipolibro();
		tipoLibro.setTipoLibroID(tip);
		libro.setTipolibro(tipoLibro);
				
		libro.setLibroAutor(aut.toUpperCase());
		libro.setLibroCantidad(can);
		libro.setLibroDescripcion(des);
		
		LibroDao libroDao = new LibroDao();
		resultado = libroDao.ActualizarLibroDao(libro);
		System.out.println("Exito ActualizaLibroAction");
		
	} catch (Exception e) {
		System.out.println("Error ActualizaLibroAction"+e.getMessage());
		e.printStackTrace();
	}
	
	if(resultado == true){
		cargaDatosDinamicosLibrosDestacados();
		System.out.println("Exito Libro Actualizado");
		addActionMessage("Libro Actualizado");
		tip=1;
		nom = "";
		aut = "";
		can = 0;
		des="";
		return SUCCESS;
	}else{
		System.out.println("Problemas al Actualizar Libro");
		addActionError("Error al Actualizar Libro");
		return ERROR;
	}
	
}


public String EliminadoLogicoLibroAction() throws Exception{
	boolean resultado = false;
	try {
		LibroDao libroDao = new LibroDao();
		resultado=libroDao.EliminadoLogicoLibroDao(idBusqueda);
		System.out.println("Exito EliminadoLogicoLibroAction");
	} catch (Exception e) {
		System.out.println("Error EliminadoLogicoLibroAction"+e.getMessage());
		e.printStackTrace();
	}
	
	if(resultado == true){
		cargaDatosDinamicosLibrosDestacados();
		System.out.println("Exito Libro Eliminado");
		addActionMessage("Libro Eliminado");
		return SUCCESS;
	}else{
		System.out.println("Problemas al Eliminar Libro");
		addActionError("Error al Eliminar Libro");
		return ERROR;
	}
}


}
