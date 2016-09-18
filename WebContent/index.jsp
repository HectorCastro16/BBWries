<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<head>

<title>Biblioteca Virtual</title>
<meta http-equiv="refresh" content="120">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
 
<link href="Estilos/propio.css" rel="stylesheet" type="text/css" media="all" />
 
<link href="Estilos/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="Estilos/slider.css" rel="stylesheet" type="text/css" media="all" />
<link href="Estilos/jquery-ui.css" rel="stylesheet"  />

<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript" src="js/jquery.nivo.slider.js"></script> 

<script src="js/jquery-ui.js"></script>

<script type="text/javascript">
	$(window).load(function() {
		$('#slider').nivoSlider();
	});
</script>

<script>
  $(function() {
	  $( document ).tooltip({
		  
	      position: {
	        my: "center bottom-20",
	        at: "center top",
	        using: function( position, feedback ) {
	          $( this ).css( position );
	          $( "<div>" )
	            .addClass( "arrow" )
	            .addClass( feedback.vertical )
	            .addClass( feedback.horizontal )
	            .appendTo( this );
	        }
	      }
	    });
  });
</script>
  
<style>
  .ui-tooltip, .arrow:after {
    background: Coral;
    border: 2px solid LemonChiffon;
  }
  .ui-tooltip {
    padding: 10px 20px;
    color: black;
    font: bold 14px "Helvetica Neue", Sans-Serif;
    text-transform: uppercase;
    box-shadow: 0 0 7px black;
  }
  .arrow {
    width: 70px;
    height: 16px;
    overflow: hidden;
    position: absolute;
    left: 50%;
    margin-left: -35px;
    bottom: -16px;
  }
  .arrow.top {
    top: -16px;
    bottom: auto;
  }
  .arrow.left {
    left: 20%;
  }
  .arrow:after {
    content: "";
    position: absolute;
    left: 20px;
    top: -20px;
    width: 25px;
    height: 25px;
    box-shadow: 6px 5px 9px -9px black;
    -webkit-transform: rotate(45deg);
    -ms-transform: rotate(45deg);
    transform: rotate(45deg);
  }
  .arrow.top:after {
    bottom: -20px;
    top: auto;
  }
  </style> 
</head>
<body>

		
	<div class="header">
		<div class="headertop_desc">
			<div class="wrap">
				<div class="nav_list">
					<ul>
						<li><a href="ira.html">Inicio</a></li>
					</ul>
				</div>
				<div class="account_desc">
					<ul>
						<li><a href="login.jsp">Ingreso</a></li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="wrap">
			<div class="header_top">
				<div class="logo">
					<a href="#"><img src="images/logo.png" alt="" /></a>
				</div>
				<div class="header_top_right">
					<div class="clear"></div>
				</div>
				<script type="text/javascript">
					function DropDown(el) {
						this.dd = el;
						this.initEvents();
					}
					DropDown.prototype = {
						initEvents : function() {
							var obj = this;

							obj.dd.on('click', function(event) {
								$(this).toggleClass('active');
								event.stopPropagation();
							});
						}
					}

					$(function() {

						var dd = new DropDown($('#dd'));

						$(document).click(function() {
							// all dropdowns
							$('.wrapper-dropdown-2').removeClass('active');
						});

					});
				</script>
				<div class="clear"></div>
			</div>
			<div class="header_bottom">
				<div class="header_bottom_left">
					<div class="categories">
						<ul>
							<h3>Categorias</h3>
							<s:iterator value="listadoTipoLibro">
								<li><a href="#"><s:property value="TipoLibroNombre" /></a></li>
							</s:iterator>
						</ul>
					</div>
				</div>
				<div class="header_bottom_right">
					<!------ Slider ------------>
					<div class="slider">
						<div class="slider-wrapper theme-default">
							<div id="slider" class="nivoSlider">
								<img src="images/1.jpg" data-thumb="images/1.jpg" alt="" /> <img
									src="images/2.jpg" data-thumb="images/2.jpg" alt="" /> <img
									src="images/3.jpg" data-thumb="images/3.jpg" alt="" /> <img
									src="images/4.jpg" data-thumb="images/4.jpg" alt="" /> <img
									src="images/5.jpg" data-thumb="images/5.jpg" alt="" />
							</div>
						</div>
					</div>
					<!------End Slider ------------>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<!------------End Header ------------>
	<div class="main">
		<div class="wrap">
			<div class="content">
				<div class="content_top">
					<div class="heading">
						<h3>Últimos libros</h3>
					</div>
				</div>
				<div class="section group">
					<s:iterator value="listadoLibros">
						<div  class="grid_1_of_5 images_1_of_5">
							<a href="login.jsp" ><img title="Libro: <s:property value='LibroNombre' />" src="images/portadas/<s:property value='LibroImagen'/>"  /></a>
							
							<div class="price-details">
								<div class="add-cart">
									<h4>
										<a href="login.jsp">Leer</a>
									</h4>
								</div>
							</div>
						</div>
					</s:iterator>
				</div>
				<div class="content_bottom">
					<div class="heading">
						<h3>Más libros</h3>
					</div>
				</div>
				<div class="section group">
					<s:iterator value="listadoLibros">
						<div class="grid_1_of_5 images_1_of_5">
							<a href="login.jsp"><img src="images/portadas/<s:property value='LibroImagen'/>"  onmouseover="this.height=260;" onmouseout="this.height=240;" /></a>
							<h2>
								<s:property value="LibroNombre" />
							</h2>
							<div class="price-details">
								<div class="add-cart">
									<h4>
										<a href="login.jsp">Leer</a>
									</h4>
								</div>
								<div class="clear"></div>
							</div>
						</div>
					</s:iterator>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="wrap">
			<div class="section group">
				<div class="col_1_of_4 span_1_of_4">
					<h4>Information</h4>
					<ul>
						<li><a href="#">Acerca de nosotros</a></li>
						<li><a href="#">Politica del estado</a></li>
					</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>Informate</h4>
					<ul>
						<li><a href="#">Acerca de nosotros</a></li>
						<li><a href="#">Politica de privacidad</a></li>
					</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>Condiciones</h4>
					<ul>
						<li><a href="#">Terminos y condiciones</a></li>
					</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>Contactanos</h4>
					<ul>
						<li><span>+044-212252</span></li>
					</ul>
					<div class="social-icons">
						<h4>Follow Us</h4>
						<ul>
							<li><a href="#" target="_blank"><img
									src="images/facebook.png" alt="" /></a></li>
							<li><a href="#" target="_blank"><img
									src="images/twitter.png" alt="" /></a></li>
							<li><a href="#" target="_blank"><img
									src="images/skype.png" alt="" /> </a></li>
							<li><a href="#" target="_blank"> <img
									src="images/linkedin.png" alt="" /></a></li>
							<div class="clear"></div>
						</ul>
					</div>
				</div>
			</div>
			<div class="copy_right">
				<p>CopyRight © Todos los derechos reservados | GR Biblioteca
					Virtual</p>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<a href="#" id="toTop"><span id="toTopHover"> </span></a>



</body>
</html>

