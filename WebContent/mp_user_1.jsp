<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>

<%@page import="model.Usuario"%>

    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html; charset=ISO-8859-1">
    <title>Administración Biblioteca GR</title>   
    
    <sj:head jqueryui="true" jquerytheme="black-tie" />
     
    <link href="Estilos/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />    
    <link href="Estilos/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <link href="Estilos/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
    <link href="Estilos/propio.css" rel="stylesheet" type="text/css" />
    
  </head>
  <body class="skin-red">
  
  <%
  String nom="dfhdfhdfhdfh";
   %>
    <!-- Site wrapper -->
    <div class="wrapper">
      
      <header class="main-header">
        <a href="panel.jsp" class="logo"><b>Biblioteca </b>GR</a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              <!-- User Account: style can be found in dropdown.less -->
              <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <%
                HttpSession ses = request.getSession();
                Usuario u = (Usuario) ses.getAttribute("usuario");
                String foto=u.getPersona().getPersonaImagen();
                String apellidos=u.getPersona().getPersonaApellidos();
                %>
                  <img src="images/fotos/<%=foto%>" class="user-image" alt="User Image"/>
                  <span class="hidden-xs"><% 	out.print("" + u.getPersona().getPersonaNombre()); %></span>
                </a>
                <ul class="dropdown-menu">
                  <!-- User image -->
                  <li class="user-header">
                    <img src="images/fotos/<%=foto%>" class="img-circle" alt="User Image" />
                    <p>
                      <% out.print("" + u.getPersona().getPersonaNombre()); %>
                      <small><%=apellidos%></small>
                    </p>
                  </li>
                  <!-- Menu Footer-->
                  <li class="user-footer">
                    <div class="pull-left">
                      <a href="#" class="btn btn-default btn-flat">Perfil</a>
                    </div>
                    <div class="pull-right">
                      <a href="login.jsp" class="btn btn-default btn-flat">Salir</a>
                    </div>
                  </li>
                </ul>
              </li>
            </ul>
          </div>
        </nav>
      </header>
      
      

      <!-- =============================================== -->

      <!-- Left side column. contains the sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="images/fotos/<%=foto%>" class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
            
              <p><% out.print("" + u.getPersona().getPersonaNombre()); %></p>

              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          <!-- /.search form -->
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">Navegacion</li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-dashboard"></i> <span>Libros</span> <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="ListadoLibrosDestacadosXML"><i class="fa fa-circle-o"></i>Libros Destacados</a></li>
<!--                 
                <li><a href="listalibroreserva.jsp"><i class="fa fa-circle-o"></i> Libros separados</a></li>
                <li><a href="listalibroreserva.jsp"><i class="fa fa-circle-o"></i> Prueba Include Panel</a></li>
-->                
              </ul>
            </li>            
            <li class="header">Sobre el sistema</li>
            <li><a href="#"><i class="fa fa-circle-o text-info"></i> Información</a></li>
          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>

      <!-- =============================================== -->

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper" style="min-height: 1068px;">
        <!-- Content Header (Page header) -->