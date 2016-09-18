package action;
import java.util.List;
//import jdk.nashorn.internal.runtime.ListAdapter;
import persistencia.TipolibroDao;
import model.Tipolibro;
import com.opensymphony.xwork2.ActionSupport;
public class TipoLibroAction extends ActionSupport{
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
			addActionMessage("Listado de tipo libros correcto.");
			return SUCCESS;
		}
	}
}
