<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="it">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.88.1">
  <title>Accesso</title>

  <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">



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

    @media (min-width: 768px) {
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
  <link href="login.css" rel="stylesheet">
</head>


<body class="text-center">

  <!-- MAIN -->

  <main class="form-signin">
    <form action="login" method="post" autocomplete="on">
      <img class="mb-4" src="logo_img/logo_login.png" alt="" >
      <h1 class="h3 mb-3 fw-normal">Accedi</h1>

      <div class="form-floating">
        <input type="text" class="form-control" name="username" id="username" placeholder="username">
        <label for="floatingInput">Username</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" name="password" id="password" placeholder="Password">
        <label for="floatingPassword">Password</label>
      </div>

      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" name="ricordami" value="remember-me"> Ricordami
        </label>
      </div>

      <input class="w-100 btn btn-lg btn-primary bottone-arready" type="submit" value="Accedi"></input>

    </form>
  </main>

</body>

</html>