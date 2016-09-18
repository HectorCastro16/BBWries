<%@ include file="mp_user_1.jsp"%>

<section class="content-header">
	<h1>Libros Destacados</h1>
</section>

<section class="content">

<s:actionerror />
<s:actionmessage theme="jquery" />

<s:iterator value="listadoLibroDestacados">
	<div class="post">
	<section class="invoice">
	
		<div class="col-xs-12">
			<h2 class="page-header">
				<i class="fa fa-globe"></i> <s:property value="LibroNombre" /> <small class="pull-right">Género:
					<s:property value="tipolibro.TipoLibroNombre" /></small>
			</h2>
		</div>
		<img src='images/portadas/<s:property value="LibroImagen"></s:property>' class="LibroDetalleImagen"
			alt="User Image" />
		<p><s:property value="LibroDescripcion" /></p>
		<input type="submit" class="btn btn-block btn-info redimencion-boton"
			value="Ver Libro" OnClick="location.href='Libros_PDF/<s:property value="LibroArchivoPdf"></s:property>'" />
	
	</section>
	</div>	
</s:iterator>

<div align="right" class="pagination">
                
</div>

</section>

<%@ include file="mp_user_2.jsp"%>