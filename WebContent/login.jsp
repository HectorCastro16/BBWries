<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Ingreso al sistema</title>
<sj:head jqueryui="true" jquerytheme="black-tie" />

<link href="Estilos/stylelog.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="App Loction Form,Login Forms,Sign up Forms,Registration Forms,News latter Forms,Elements"./>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<!--//webfonts-->
</head>
<body>
	<h1> </h1>
	<div class="app-location">
		<h2>Bienvenido a GR Biblioteca Virtual</h2>
		<div class="line">
			<span></span>
		</div>
		
		<s:form action="validaUsuarioXML">
			<s:textfield name="usuarioI" placeholder="Usuario" ></s:textfield>
			<s:password name="passwI" placeholder="Contraseña"></s:password>	
			<div class="submit"><s:submit value="Ingresar"></s:submit></div>		
		</s:form>
		
		<div class="clear">
		<s:actionerror theme="jquery" />
		</div>
		
		<div class="new">
		
			<h4>
				<a href="registrarse.jsp">¿Eres nuevo? ¡Registrate!</a>
			</h4>
			<div class="clear"></div>
		</div>
	</div>
		
	<!--start-copyright-->
   		<div class="copy-right">
				<p>Copyright &copy; 2015  Derechos Reservados | GR Ingreso</p>
		</div>
	<!--//end-copyright-->
</body>
</html>