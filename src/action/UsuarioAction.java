package action;

import java.util.Date;
import java.util.List;




import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import persistencia.TipoUsuarioDao;
import persistencia.UsuarioDao;
import model.Persona;
import model.TipoUsuario;
import model.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//import jdk.nashorn.internal.runtime.ListAdapter;


public class UsuarioAction extends ActionSupport {
	String usuarioId;
	String usuarioI; //username
	String passwI;
	
	int dni;
	String personaID;
	
	String personaNom;
	String personape;
	
	String personafot;
	String personacom;
	int tipousuario;
	
	Usuario usuario;
	
	String idBusqueda;
	
	public String getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getIdBusqueda() {
		return idBusqueda;
	}
	public void setIdBusqueda(String idBusqueda) {
		this.idBusqueda = idBusqueda;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getPersonafot() {
		return personafot;
	}
	public void setPersonafot(String personafot) {
		this.personafot = personafot;
	}
	public String getPersonacom() {
		return personacom;
	}
	public void setPersonacom(String personacom) {
		this.personacom = personacom;
	}
	public int getTipousuario() {
		return tipousuario;
	}
	public void setTipousuario(int tipousuario) {
		this.tipousuario = tipousuario;
	}
	public String getPersonaID() {
		return personaID;
	}
	public void setPersonaID(String personaID) {
		this.personaID = personaID;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getPersonaNom() {
		return personaNom;
	}
	public void setPersonaNom(String personaNom) {
		this.personaNom = personaNom;
	}

	public String getPersonape() {
		return personape;
	}
	public void setPersonape(String personape) {
		this.personape = personape;
	}
	public String getUsuarioI() {
		return usuarioI;
	}
	public void setUsuarioI(String usuarioI) {
		this.usuarioI = usuarioI;
	}
	public String getPasswI() {
		return passwI;
	}
	public void setPasswI(String passwI) {
		this.passwI = passwI;
	}
	
	public String InsertarUsuarioAction()throws Exception{
		
		boolean respuesta = false;
		
		try {
			
			Usuario usuario = new Usuario();
			usuario.setUsuarioNombre(usuarioI);
			usuario.setUsuarioPassw(passwI);
			
			Persona p = new Persona();
			p.setPersonaNombre(personaNom);
			p.setPersonaApellidos(personape);			
			p.setPersonaDni(dni);
			
			usuario.setPersona(p);
			
			UsuarioDao usuariodao = new UsuarioDao();
			respuesta = usuariodao.InsertarUsuarios(usuario);
			System.out.println("Usuario ok Action");
		} catch (Exception e) {
			System.out.println("Usuario fallo Action");
		}
		
		if (respuesta==true){
			addActionMessage("Usted se ha registrado con éxito");
			return SUCCESS;
		}else{
			addActionError("Erro al registrarse intentelo nuevamente");
			return ERROR;
		}
	}
	

	
	

	public String validaUsuarioAction() throws Exception{
		//Usuario usuario = new Usuario();
		
		try{
			UsuarioDao usuarioDao= new UsuarioDao();
			usuario = usuarioDao.validaUsuarioDao(usuarioI, passwI);
			//user=usuarioDao.validaUsuarioDao(usuarioI, passwI);
			
			System.out.println("Exito valida UsuarioAction");			
		}catch(Exception e){
			System.out.println("Error valida UsuarioAction"+e.getMessage());
			e.printStackTrace();
		}
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		if(usuario.getUsuarioNombre()==null){
			usuarioI="";
			addActionError("Usuario o Clave Incorrectos.");
			return ERROR;
		}else if(usuario.getTipoUsuario().getTipoUsuarioNombre().equals("Administrador") || usuario.getTipoUsuario().getTipoUsuarioNombre().equals("Trabajador")){

			session.setAttribute("usuario",usuario);
			session.setAttribute("context", new Date());
			
			addActionMessage("Bienvenido al Sistema: "+usuario.getPersona().getPersonaNombre().toString().toUpperCase()+" "+usuario.getPersona().getPersonaApellidos().toString().toUpperCase());
			usuarioI="";
			return LOGIN;
		}else if(usuario.getTipoUsuario().getTipoUsuarioNombre().compareTo("Administrador") != 0){
			
			session.setAttribute("usuario",usuario);
			session.setAttribute("context", new Date());
			
			addActionMessage("Bienvenido al Sistema: "+usuario.getPersona().getPersonaNombre().toString().toUpperCase()+" "+usuario.getPersona().getPersonaApellidos().toString().toUpperCase());
			usuarioI="";
			return SUCCESS;
		}else{
			usuarioI="";
			addActionError(" Otro Problema");
			return ERROR;
		}
	}
	
	
	// Para TipoSelect(combo)
		private List<Usuario> listadoTipoUsuarioSelect = null;


		public List<Usuario> getListadoTipoUsuarioSelect() {
			return listadoTipoUsuarioSelect;
		}
		public void setListadoTipoUsuarioSelect(List<Usuario> listadoTipoUsuarioSelect) {
			this.listadoTipoUsuarioSelect = listadoTipoUsuarioSelect;
		}
	
		public String CargaDatosTipoUsuarioAction() throws Exception{
			TipoUsuarioDao tipoUsuarioDao=new TipoUsuarioDao();
			try {
				listadoTipoUsuarioSelect=tipoUsuarioDao.ListadoTipoUsuarioSelectDao();
				System.out.println("Exito al Cargar CargaDatosTipoUsuariosAction");
			} catch (Exception e) {
				System.out.println("Error al cargar CargaDatosTipoUsuariosAction"+e.getMessage());
				e.printStackTrace();
			}
			if(listadoTipoUsuarioSelect.isEmpty()==true){
				addActionError("Listado Tipo Usuario Incorrecto.");
				return ERROR;
			}else{
				addActionMessage("Listado Tipo Usuario Correcto.");
				return SUCCESS;
			}
		}
	
		public String InsertarAdminUsuarioAction()throws Exception{
			
			boolean respuesta = false;
			
			try {
				
				Usuario usuario = new Usuario();
				usuario.setUsuarioNombre(usuarioI);
				usuario.setUsuarioPassw(passwI);
				
				Persona p = new Persona();
				p.setPersonaNombre(personaNom);
				p.setPersonaApellidos(personape);			
				p.setPersonaDni(dni);
				p.setPersonaImagen(personafot);
				p.setPersonaComentario(personacom);
				
				usuario.setPersona(p);
				
				TipoUsuario t =new TipoUsuario();
				t.setTipoUsuarioID(tipousuario);
				
				usuario.setTipoUsuario(t);
				
				UsuarioDao usuariodao = new UsuarioDao();
				respuesta = usuariodao.InsertaAdminUsuarioDao(usuario);
				System.out.println("exito consulta InsertarAdminUsuarioAction");
			} catch (Exception e) {
				System.out.println("error consulta InsertarAdminUsuarioAction");
				e.printStackTrace();
			}
			
			CargaDatosTipoUsuarioAction();
			
			if (respuesta==true){
				System.out.print("ingreso el objeto usuario");
				addActionMessage("Usuario Ingresado Correctamente");
				
				tipousuario=1; usuarioI=""; passwI=""; personaNom="";
				personape=""; dni=0; personafot=""; personacom="";
				
				return SUCCESS;
			}else{
				System.out.print("Error al ingresar objeto usuario");
				addActionError("Error al Ingresar Usuario");
				return ERROR;
			}
		}
		
		
		List <Usuario> listadoUsuarios=null;

		public List<Usuario> getListadoUsuarios() {
			return listadoUsuarios;
		}
		public void setListadoUsuarios(List<Usuario> listadoUsuarios) {
			this.listadoUsuarios = listadoUsuarios;
		}
		
		public String cargaDatosDinamicosUsuario() throws Exception{
			UsuarioDao usuarioDao=new UsuarioDao();
			try {
				listadoUsuarios=usuarioDao.ListaUsuariosDao();
				System.out.println("Exito carga cargaDatosDinamicosUsuario");

			} catch (Exception e) {
				System.out.println("Error carga cargaDatosDinamicosLibrosDestacados" + e.getMessage());
				e.printStackTrace();
			}
			
			if(listadoUsuarios.isEmpty()==true){
				addActionError("Ningun Usuario Activo - Listado No Pasible");
				return ERROR;
			}else{
				addActionMessage("Listado de Usuarios Correcto");
				return SUCCESS;
			}
			
		}
		
		public String BuscaUsuarioAction() throws Exception {
			UsuarioDao usuarioDao=new UsuarioDao();
			try {
				listadoUsuarios=usuarioDao.BuscaUsuarioIdDao(idBusqueda);
				System.out.println("Exito BuscaUsuarioAction");
			} catch (Exception e) {
				System.out.println("Error BuscaUsuarioAction" + e.getMessage()); 
				e.printStackTrace();
			}
			
			if (listadoUsuarios.isEmpty()) {
				addActionError("Verificar Datos - No Se Encuentra Usuario");
				return ERROR;
			} else {
				addActionMessage("Usuario Encontrado");
				return SUCCESS;
			}
		}
		
		public String BuscaUsuarioObjetoAction() throws Exception {
			
			try {
				UsuarioDao usurioDao=new UsuarioDao();
				usuario=usurioDao.BuscaUsuarioIdObjetoDao(idBusqueda);
				tipousuario=usuario.getTipoUsuario().getTipoUsuarioID();
				System.out.println("Exito BuscaUsuarioObjetoAction");
			} catch (Exception e) {
				System.out.println("Error BuscaUsuarioObjetoAction" + e.getMessage());
				e.printStackTrace();
			}
			
			if(usuario.getUsuarioNombre()!=null){
				TipoUsuarioDao tipoUsuarioDao = new TipoUsuarioDao();
				listadoTipoUsuarioSelect=tipoUsuarioDao.ListadoTipoUsuarioSelectDao();
				addActionMessage(usuario.getUsuarioID().toString().toUpperCase()+": "+ usuario.getPersona().getPersonaNombre().toString().toUpperCase()+" "+usuario.getPersona().getPersonaApellidos().toString().toUpperCase()+" - BBWries ");
				return SUCCESS;
			}else{
				addActionError("Usuario No Existe");
				return ERROR;
			}
		}
		
		public String ActualizaUsuarioAction() throws Exception{
			boolean resultado = false;
			Usuario usuario= new Usuario();
			try {
				usuario.setUsuarioID(usuarioId);
				
				Persona persona=new Persona();
				persona.setPersonaNombre(personaNom);
				persona.setPersonaApellidos(personape);
				persona.setPersonaDni(dni);
				persona.setPersonaComentario(personacom);
				usuario.setPersona(persona);
				
				TipoUsuario tipoUsuario = new TipoUsuario();
				tipoUsuario.setTipoUsuarioID(tipousuario);
				usuario.setTipoUsuario(tipoUsuario);
				
				usuario.setUsuarioNombre(usuarioI);
				usuario.setUsuarioPassw(passwI);
				
				UsuarioDao usuarioDao=new UsuarioDao();
				resultado=usuarioDao.ActualizarUsuarioDao(usuario);
				System.out.println("Exito ActualizaUsuarioAction");
			} catch (Exception e) {
				System.out.println("Error ActualizaUsuarioAction"+e.getMessage());
				e.printStackTrace();
			}
			
			if(resultado==true){
				cargaDatosDinamicosUsuario();
				System.out.println("Exito Usuario Actualizado");
				addActionMessage("Usuario Actualizado");
				
				personaNom=""; personape=""; dni=0; personacom="";
				tipousuario=1; usuarioI=""; passwI="";
				
				return SUCCESS;
			}else{
				System.out.println("Problemas al Actualizar Usuario");
				addActionError("Error al Actualizar Usuario");
				return ERROR;
			}
		}
		
		public String EliminadoLogicoUsuarioAction() throws Exception{
			boolean resultado = false;
			try {
				UsuarioDao usuarioDao=new UsuarioDao();
				resultado=usuarioDao.EliminadoLogicoUsuarioDao(idBusqueda);
				System.out.println("Exito EliminadoLogicoUsuarioAction");
			} catch (Exception e) {
				System.out.println("Error EliminadoLogicoUsuarioAction"+e.getMessage());
				e.printStackTrace();
			}
			
			if(resultado == true){
				cargaDatosDinamicosUsuario();
				System.out.println("Exito Usuario Eliminado");
				addActionMessage("Usuario Eliminado");
				return SUCCESS;
			}else{
				System.out.println("Problemas al Eliminar Usuario");
				addActionError("Error al Eliminar Usuario");
				return ERROR;
			}
		}
		
		
		
}
