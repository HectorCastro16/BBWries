<%@ include file="mp_admin_1.jsp"%>

<section class="content">
	<div class="box">
	<s:form action="BusquedaLibroID">
		<div class="box-header">
			<h3 class="box-title">LISTADO GENERAL DE LIBROS REGISTRADOS</h3>
			<div class="box-tools">
				<div class="input-group">
					<input type="text" name="idBusqueda"
						class="form-control input-sm pull-right" style="width: 150px;"
						placeholder="Buscar libro...">
					<div class="input-group-btn">
						<button class="btn btn-sm btn-default">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
	</s:form>
		<!-- /.box-header -->
		<a  href="ListaLibrosTotalesXML" style="float: right; font-size: 13px" >Mostrar Todos los Libros</a>
		<s:actionmessage theme="jquery" />
		<br />
		<div class="box-body table-responsive no-padding">
			<table class="table table-hover">
				<tbody>
					<tr class="success">
						<th>ID</th>
						<th>Codigo</th>
						<th>Nombre</th>
						<th>Cantidad</th>
						<th>Autor</th>
						<th>Fecha Registro</th>
						<th>Estado</th>
						<th>Tipo Libro</th>
						<th>Imagen</th>
						<th>Pdf</th>
						<th></th>
						<th></th>
					</tr>
					<s:iterator value="listadoLibroDestacados">
						<tr>
							<td><s:property value="LibroID" /></td>
							<td><s:property value="LibroCodigo" /></td>
							<td><s:property value="LibroNombre" /></td>
							<td><s:property value="LibroCantidad" /></td>
							<td><s:property value="LibroAutor" /></td>
							<td><s:property value="LibroFechaRegistro" /></td>
							<td><span class="label label-success">Approved</span></td>
							<td><s:property value="tipolibro.TipoLibroNombre" /></td>
							<td><img
								src="images/portadas/<s:property value="LibroImagen"></s:property>"
								style="width: 50px; height: 50px" alt="User Image" />
							</td>
							
							<td><a href='Libros_PDF/<s:property value="LibroArchivoPdf"></s:property>'>Ver Libro</a></td>
							
							<td><s:url id="url1" action="BuscaLibroObjetoXML">
									<s:param name="idBusqueda">
									<s:property value="LibroID"></s:property>
									</s:param>
								</s:url> 
								<s:a href="%{url1}"><img title="Actualizar" alt="" style="width: 25px; height: 25px" src="images/refresh.png" /></s:a>
							</td>
							 
							<td><s:url id="url2" action="EliminadoLogicoLibroXML">
								<s:param name="idBusqueda">
								<s:property value="LibroID"></s:property>
								</s:param>
							</s:url><s:a href="%{url2}"><img title="Eliminar" alt="" style="width: 25px; height: 25px" src="images/delete.png">
							</s:a></td> 
							
						</tr>
						
					</s:iterator>
				</tbody>
			</table>  
		</div>
	</div>




</section>

<%@ include file="mp_admin_2.jsp"%>