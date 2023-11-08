<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Create</title>
</head>
<body>
	<!-- Cabeçalho -->
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark  bg-dark text-light">
			<div class="container">
				
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNav" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="#">CADASTRO</a>
						</li>
				
						<li class="nav-item"><a class="nav-link" href="ReadController">LISTAR</a>
						</li>
						
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-4">
				<h1 class="mt-5">Cadastro de Cliente</h1>
				<form class="mt-5" action="CreateController" method="post">
					<div class="form-group">
						<label for="nome">Nome:</label> <input type="text"
							class="form-control" id="nome" name="nome" required>
					</div>
					<div class="form-group">
						<label for="cpf">CPF:</label> <input type="text"
							class="form-control" id="cpf" name="cpf" required>
					</div>
					<div class="form-group">
						<label for="email">Email:</label> <input type="text"
							class="form-control" id="email" name="email" required>
					</div>
					<div class="form-group">
						<label for="telefone">Telefone:</label> <input type="text"
							class="form-control" id="telefone" name="telefone" required>
					</div>
					<div class="form-group">
						<label for="login">Login:</label> <input type="text"
							class="form-control" id="login" name="login" required>
					</div>
					<div class="form-group">
						<label for="senha">Senha:</label> <input type="password"
							class="form-control" id="senha" name="senha" required>
					</div>
					<button type="submit" class="btn btn-primary">Cadastrar</button>
				</form>
			</div>
		</div>
	</div>
	<!-- Rodapé -->
	<footer class="bg-dark text-light text-center py-3">
		&copy; 2023 Recode Turismo. Todos os direitos reservados. </footer>

	<!-- Inclua os scripts do Bootstrap via CDN -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>