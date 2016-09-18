<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<%@ page import="net.sf.jasperreports.engine.JasperRunManager" %>
<%@ page import="java.io.*" %> 
<%@ page import="java.sql.Connection" %> 
<%@ page import="java.sql.DriverManager" %> 
<%@ page import="java.util.HashMap" %> 
<%@ page import="java.util.Map" %> 
<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="persistencia.conexion" %>

<html>
<% 
/*Parametros para realizar la conexión*/
Connection conn; 
conn=conexion.getConnection();
/*Establecemos la ruta del reporte*/ 
File reportfile = new File(application.getRealPath("//reportes//reporte_usuarios.jasper"));
/* No enviamos parámetros porque nuestro reporte no los necesita */ 
Map parameter= new HashMap();

//parameter.put("Nombre_Parametro","Valor_Parametro");
/*Enviamos la ruta del reporte, los parámetros y la conexión*/ 
byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath (), null,conn); 
/*Indicamos que la respuesta va a ser en formato PDF*/ 
response.setContentType("application/pdf"); 

response.setHeader ("Content-disposition", "inline; filename=Reporte General Usuarios.pdf");
response.setHeader ("Cache-Control", "max-age=30");
response.setHeader ("Pragma", "No-cache");
response.setDateHeader ("Expires", 0);

response.setContentLength(bytes.length); 
ServletOutputStream outputStream= response.getOutputStream(); 
outputStream.write(bytes,0,bytes.length); 
/*Limpiamos y cerramos flujos de salida*/ 
outputStream.flush(); 
outputStream.close(); %>
</html>