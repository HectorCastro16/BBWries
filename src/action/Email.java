package action;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.sql.DataSource;






import model.Usuario;
import persistencia.TipoUsuarioDao;
import persistencia.UsuarioDao;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.handlers.multipart_mixed;


public class Email extends ActionSupport {

	String de;
	String para;
	String pass;
	String asunto;
	String mensaje;
	String archivoMail;
	Usuario usuario;
	String idBusqueda;
	

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

	public String getArchivoMail() {
		return archivoMail;
	}

	public void setArchivoMail(String archivoMail) {
		this.archivoMail = archivoMail;
	}

	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public String getPara() {
		return para;
	}


	public void setPara(String para) {
		this.para = para;
	}

	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String EnvioCorreo(){
		
		boolean envio = false;
		
		try {
			
			String host ="smtp.gmail.com";
			Properties prop = System.getProperties();
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host",host);
			prop.put("mail.smtp.user","dennis.eu01@gmail.com");
			prop.put("mail.smtp.password","wifizone01");
			prop.put("mail.smtp.port",587);
			prop.put("mail.smtp.auth","true");
			
			Session sesion = Session.getDefaultInstance(prop,null);
			MimeMessage message = new MimeMessage(sesion);
			message.setFrom(new InternetAddress("dennis.eu01@gmail.com"));
			
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(para));
			message.setSubject(asunto);
			
			
			// archivo del e-mail- tiene que incluir el mensaje-
		     MimeBodyPart CuerpoMensaje = new MimeBodyPart();
		     CuerpoMensaje.setText(mensaje);
		     Multipart multipart = new MimeMultipart();
		     multipart.addBodyPart(CuerpoMensaje);
		     
		     
		     CuerpoMensaje = new MimeBodyPart();
		     //colocar ruta final de archivos a enviar
		     String ruta = "D:\\ProyectoPIT\\BBWries\\WebContent\\Libros_PDF\\"+archivoMail;
		     javax.activation.DataSource origendatos = new FileDataSource(ruta);
		     CuerpoMensaje.setDataHandler(new DataHandler(origendatos));
		     
		    CuerpoMensaje.setFileName(ruta);
		   
		     multipart.addBodyPart(CuerpoMensaje);
		     
		     // llenar el cuerpo del mensaje co el archivo
		     message.setContent(multipart);
		     
		     // enviar todo con el transport
			Transport transport = sesion.getTransport("smtp");
			transport.connect(host,"dennis.eu01@gmail.com","wifizone01");
			transport.sendMessage(message, message.getAllRecipients());
			
			transport.close();
			
			envio = true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			envio=false;
		}
		if(envio == true){
			System.out.println("Correo Enviado de manera correcta ");		
			addActionMessage("Correo Enviado Satisfactoriamente");
		   return SUCCESS;	
		}else{
			System.out.println("Erro al enviar correo");
			addActionError("Error al Enviar Correo");
			return ERROR;
		}
		
		
	}
	
	
	
	public String BuscaUsuarioEnviarCorreo() throws Exception {
		
		try {
			UsuarioDao usurioDao=new UsuarioDao();
			usuario=usurioDao.BuscaUsuarioIdObjetoDao(idBusqueda);
			
			System.out.println("Exito BuscaUsuarioObjetoAction");
		} catch (Exception e) {
			System.out.println("Error BuscaUsuarioObjetoAction" + e.getMessage());
			e.printStackTrace();
		}
		
		if(usuario.getUsuarioNombre()!=null){		
			addActionMessage("Enviar Correo A : "+ usuario.getPersona().getPersonaNombre().toString().toUpperCase()+" "+usuario.getPersona().getPersonaApellidos().toString().toUpperCase()+" - BBWries ");
			return SUCCESS;
		}else{
			addActionError("Usuario No Existe");
			return ERROR;
		}
	}
	
	
	
	
	
	
}
