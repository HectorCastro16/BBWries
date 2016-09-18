<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page import="model.Usuario" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Administración Biblioteca GR</title>

<sj:head jqueryui="true" jquerytheme="black-tie" />

<script src="plugins/jQuery/jQuery-2.1.3.min.js"></script>
<script type="text/javascript" src="dropzone/downloads/dropzone.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="dropzone/downloads/css/dropzone.css">
<link href="Estilos/jquery-ui.css" rel="stylesheet" />

<script src="js/jquery-ui.js"></script>

<script>
	$(function() {
		$(document).tooltip(
				{
					track : true,
					position : {
						my : "center bottom-20",
						at : "center top",
						using : function(position, feedback) {
							$(this).css(position);
							$("<div>").addClass("arrow").addClass(
									feedback.vertical).addClass(
									feedback.horizontal).appendTo(this);
						}
					}
				});
	});
</script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						Dropzone.autoDiscover = false;
						$("#dropzone_archivo")
								.dropzone(
										{
											url : "subir_archivo.jsp",
											addRemoveLinks : true,
											minFileSize : 1,
											maxFileSize : 100000,
											dictResponseError : "Ha ocurrido un error en el server",
											acceptedFiles : 'application/pdf,.pdf,.docx,.doc',
											complete : function(file) {
												if (file.status == "success") {
													var nombrearchivosubido = file.name;
													var nom_archivo = document
															.getElementById("nom_archivo");
													nom_archivo.value = nombrearchivosubido;
													alert("El siguiente archivo ha subido correctamente: "
															+ nombrearchivosubido);
												}
											},
											error : function(file) {
												alert("Error subiendo el archivo "
														+ file.name);
											},

										});
					});
</script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						Dropzone.autoDiscover = false;
						$("#dropzone_portada")
								.dropzone(
										{
											url : "subir_portada.jsp",
											addRemoveLinks : true,
											minFileSize : 1,
											maxFileSize : 100000,
											dictResponseError : "Ha ocurrido un error en el server",
											acceptedFiles : 'image/*,.jpeg,.jpg,.png,.gif,.JPEG,.JPG,.PNG,.GIF',
											complete : function(file) {
												if (file.status == "success") {
													var nombrearchivosubido = file.name;
													var nom_archivo = document
															.getElementById("nom_portada");
													nom_archivo.value = nombrearchivosubido;
													alert("El siguiente archivo ha subido correctamente: "
															+ nombrearchivosubido);
												}
											},
											error : function(file) {
												alert("Error subiendo el archivo "
														+ file.name);
											},

										});
					});
</script>


<script type="text/javascript">
	$(document)
			.ready(
					function() {
						Dropzone.autoDiscover = false;
						$("#dropzone_foto")
								.dropzone(
										{
											url : "subir_foto.jsp",
											addRemoveLinks : true,
											minFileSize : 1,
											maxFileSize : 100000,
											dictResponseError : "Ha ocurrido un error en el server",
											acceptedFiles : 'image/*,.jpeg,.jpg,.png,.gif,.JPEG,.JPG,.PNG,.GIF',
											complete : function(file) {
												if (file.status == "success") {
													var nombrearchivosubido = file.name;
													var nom_archivo = document
															.getElementById("nom_foto");
													nom_archivo.value = nombrearchivosubido;
													alert("El siguiente archivo ha subido correctamente: "
															+ nombrearchivosubido);
												}
											},
											error : function(file) {
												alert("Error subiendo el archivo "
														+ file.name);
											},

										});
					});
</script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						Dropzone.autoDiscover = false;
						$("#dropzone_correo")
								.dropzone(
										{
											url : "subir_archivo_correo.jsp",
											addRemoveLinks : true,
											minFileSize : 1,
											maxFileSize : 100000,
											dictResponseError : "Ha ocurrido un error en el server",
											acceptedFiles : 'application/pdf,.pdf,.docx,.doc',
											complete : function(file) {
												if (file.status == "success") {
													var nombrearchivosubido = file.name;
													var nom_archivo = document
															.getElementById("nom_archivo_correo");
													nom_archivo.value = nombrearchivosubido;
													alert("El siguiente archivo ha subido correctamente: "
															+ nombrearchivosubido);
												}
											},
											error : function(file) {
												alert("Error subiendo el archivo "
														+ file.name);
											},

										});
					});
</script>


<link href="Estilos/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="Estilos/AdminLTE.min.css" rel="stylesheet" type="text/css" />
<link href="Estilos/skins/_all-skins.min.css" rel="stylesheet"
	type="text/css" />
<link href="Estilos/propio.css" rel="stylesheet" type="text/css" />


<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/app.min.js" type="text/javascript"></script>


<link href="Estilos/jquery-ui.css" rel="stylesheet" />
<script src="js/jquery-ui.js"></script>



</head>
<body class="skin-red">
	<!-- Site wrapper -->
	<div class="wrapper">

		<header class="main-header"> <a href="padministracion.jsp"
			class="logo"><b>Biblioteca </b>GR</a> <!-- Header Navbar: style can be found in header.less -->
		<nav class="navbar navbar-static-top" role="navigation"> <!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span> <span
			class="icon-bar"></span> <span class="icon-bar"></span> <span
			class="icon-bar"></span>
		</a>
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!-- User Account: style can be found in dropdown.less -->
				<li class="dropdown user user-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown">
					<%
					HttpSession ses = request.getSession();
                    Usuario u = (Usuario) ses.getAttribute("usuario");
                    String foto=u.getPersona().getPersonaImagen();
                    String apellidos=u.getPersona().getPersonaApellidos();
                     
					%> <img
						src="images/fotos/<%=foto%>" class="user-image" alt="User Image" />
						<span class="hidden-xs">
						<% out.print("" + u.getPersona().getPersonaNombre()); %>
						</span>
				</a>
					<ul class="dropdown-menu">
						<!-- User image -->
						<li class="user-header"><img src="images/fotos/<%=foto%>"
							class="img-circle" alt="User Image" />
							<p><% out.print("" + u.getPersona().getPersonaNombre()); %>
							<small><%=apellidos%></small>
							</p></li>
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="#" class="btn btn-default btn-flat">Perfil</a>
							</div>
							<div class="pull-right">
								<a href="login.jsp" class="btn btn-default btn-flat">Salir</a>
							</div>
						</li>
					</ul></li>
			</ul>
		</div>
		</nav> </header>

		<!-- =============================================== -->

		<!-- Left side column. contains the sidebar -->
		<aside class="main-sidebar"> <!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar"> <!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="images/fotos/<%=foto%>" class="img-circle"
					alt="User Image" />
			</div>
			<div class="pull-left info">
				<p><% out.print("" + u.getPersona().getPersonaNombre()); %></p>

				<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>
		<!-- /.search form --> <!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">Administracion</li>

			<li class="treeview"><a href="#"> <i class="fa fa-dashboard"></i>
					<span>Libros</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="ListaLibrosTotalesXML"><i
							class="fa fa-circle-o"></i>Libros Registrados</a></li>
					<li><a href="ListaTipoLibroXML"><i class="fa fa-circle-o"></i>Ingresar
							Nuevo Libro</a></li>
					<li><a href="ReporteLibros.jsp"><i class="fa fa-circle-o"></i>Reporte
							General de Libros</a></li>
				</ul></li>
			<!-- 
			<li class="treeview"><a href="#"> <i class="fa fa-dashboard"></i><span>Prestamos</span> <i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="listapedido.jsp"><i class="fa fa-circle-o"></i>Prestamos Realizados</a></li>
					<li><a href="#"><i class="fa fa-circle-o"></i>Ingresar Nuevo Prestamo</a></li>
					<li><a href="#"><i class="fa fa-circle-o"></i>Reporte General de Prestamos</a></li>
				</ul>
			</li> 
 -->
			<li class="treeview"><a href="#"> <i class="fa fa-dashboard"></i><span>Usuarios</span>
					<i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<li><a href="ListadoUsuariosXML"><i class="fa fa-circle-o"></i>Usuarios
							Registrados</a></li>
					<li><a href="ListaTipoUsuarioXML"><i
							class="fa fa-circle-o"></i>Ingresar Nuevo Usuario</a></li>
					<li><a href="ReporteUsuarios.jsp"><i
							class="fa fa-circle-o"></i> Reporte General de Usuarios</a></li>
				</ul></li>
			<li class="header">Sobre el sistema</li>
			<li class="treeview"><a href="#"> <i
					class="fa fa-dashboard"></i><span>Informacion</span> <i
					class="fa fa-angle-left pull-right"></i></a></li>
		</ul>
		</section> <!-- /.sidebar --> </aside>

		<div class="content-wrapper" style="min-height: 1068px;">