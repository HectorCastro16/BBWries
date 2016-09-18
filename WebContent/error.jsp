<%@ include file="mp_admin_1.jsp"%>

		<section class="content-header">
          <h1>
            500 Página de error
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Biblioteca</a></li>
            <li><a href="#">Problemas</a></li>
            <li class="active">500 error</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">

          <div class="error-page">
            <h2 class="headline text-red">500</h2>
            <div class="error-content">
              <h3><i class="fa fa-warning text-red"></i> ¡Huy! Algo salió mal.</h3>
              <p>
                Vamos a trabajar en la fijación de eso de inmediato. Mientras tanto, es posible <a href='ira.html'> volver a Dashboard</a> o intente utilizar el buscador.
                <s:actionerror theme="jquery" />
                <br/>
				<s:actionmessage theme="jquery"/>
              </p>
              <form class='search-form'>
                <div class='input-group'>
                  <input type="text" name="search" class='form-control' placeholder="Search"/>
                  <div class="input-group-btn">
                    <button type="submit" name="submit" class="btn btn-danger btn-flat"><i class="fa fa-search"></i></button>
                  </div>
                </div><!-- /.input-group -->
              </form>
            </div>
          </div><!-- /.error-page -->

        </section><!-- /.content -->
        

<%@ include file="mp_admin_2.jsp"%>