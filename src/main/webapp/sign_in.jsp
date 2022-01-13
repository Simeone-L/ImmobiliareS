<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
 
<!doctype html>
<html lang="it">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<title>Registrazione</title>

<link rel="canonical"



<!-- CSS di Bootstrap -->
<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.bottone-arready {
	background-color: #be9447;
	border-color: #be9447;
}
</style>


<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">
</head>


<body class="text-center">

	<!-- MAIN -->

	<main class="form-signin">
		<form action="sign-in" method="post">
			<img class="mb-4" src="logo_img/logo_signin.png" alt="" height="57">
			<h1 class="h3 mb-3 fw-normal">Registrazione</h1>

			<div class="form-floating">
				
					<label for="floatingText">Nome </label>
					<input type="text" class="form-control" name="nome" id="nome"
					placeholder="Nome" >
					<c:when test="${not empty errorCognome}">
					<c:out value="${errorCognome}"/>
					</c:when>
					
			</div>
			<div class="form-floating">
					
					<label for="floatingText">Cognome </label>
					<input type="text" class="form-control" name="cognome" id="cognome"
					placeholder="Cognome">
					<c:when test="${not empty errorUsername}">
					<c:out value="${errorUsername}"/>
					</c:when>
					
			</div>
			<div class="form-floating">
				    
				    <label for="floatingText">Username</label>
				    <input type="text" class="form-control" name="username"
					id="username" placeholder="Username"> 
					<c:when test="${not empty errorEmail}">
					<c:out value="${errorEmail}"/>
					</c:when>	
					
					
			</div>
			<div class="form-floating">
				    
					<label for="floatingInput">Email </label>
					<input type="email" class="form-control" name="email" id="email"
					placeholder="name@example.com">
				 	
					
					
			</div>
			<div class="form-floating">
				 
					<label for="floatingPassword">Password </label>
					<c:set value="${utente.password}" var="password"/>
					<input type="password" class="form-control" name="password"
					id="password" placeholder="Password"> 
					<c:when test="${not empty errorPassword}">
					<c:out value="${errorPassword}"/>
					</c:when>
			
				
			
					
			</div>

			<div class="checkbox mb-3">
				<label> <input type="checkbox" name="ricordami"
					value="remember-me"> Ricordami
				</label>
			</div>

			<input class="w-100 btn btn-lg btn-primary bottone-arready"
				type="submit" value="Registrati" ></input>

		</form>
	</main>

</body>

</html>