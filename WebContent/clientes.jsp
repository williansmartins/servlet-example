<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/custom.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <title>Clientes</title>
  </head>

  <body>
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.html">Frameworks</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="captcha.jsp">Captcha</a></li>
            <li><a href="importarXML.jsp">Importar XML</a></li>
            <li><a href="gerarBoletos.jsp">Gerar Boletos</a></li>
            <li><a href="#contact">Imprimir Boletos</a></li>
            <li><a href="quartzServlet">Quartz</a></li>
            <li><a href="#contact">Service</a></li>
            <li><a class="active" href="clientes.jsp">Clientes</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">
    	<form action="clientes" method="post">
	    	<div class="page-header">
			  <h1>Clientes</h1>
			</div>
			<div class="jumbotron">
				<div class="input-group">
					<span class="input-group-addon">Nome do Cliente</span>
					<input type="text" class="form-control" name="nomeCliente" id="nomeCliente" placeholder="Nome Cliente" />
				</div>
				<br />
				<p>
					<a class="btn btn-primary btn-lg buscar" href="#" >Buscar</a>
				</p>
			</div>
    	</form>
    	<div class="panel panel-default">
		  <div class="panel-heading">Resultados da busca</div>
		  <div class="panel-body" id="result">
		  </div>
		</div>
    </div><!-- /.container -->

    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    	$(function() {
    		$(".buscar").click(function() {
    			var nome = $("#nomeCliente").val();
   			 	$.ajax({
   			   	  url: ("clientes?nomeCliente=" + nome),
   			   	}).done(function( result ) {
   			   	  $("#result").html(result);
   			   	});
    		});
    	});    
    </script>
  </body>
</html>