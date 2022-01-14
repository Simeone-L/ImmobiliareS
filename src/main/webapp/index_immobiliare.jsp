<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <title>Arready Immobiliare</title>

  <!-- Bootstrap core CSS -->
  <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="index_immobiliare.css" rel="stylesheet">

  <!--CSS for search bar-->
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>

  <!-- Custom styles for Carousel -->
  <link href="carousel.css" rel="stylesheet">

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

    .parallasse {
      width: 100%;
      background-attachment: fixed;

      background-size: cover;
    }

    .img-blocco-1 {
      background-image: url('img/background1.png');
    }

    .form-control {
      padding-left: 2.375rem;
    }

    .spacer-searchbar {
      padding-left: 25%;

    }

    .back-top-button {
      position: fixed;
      bottom: 50px;
      right: 50px;
    }

    .disappear {
      display: none;
    }

    .bottone-arready {
      background-color: #be9447;
      border-color: #be9447;
    }

    .bottone-arready-2 {
      border-color: #be9447;
      color: #be9447;
    }
  </style>

</head>

<body>

  <!-- HEADER DI TUTTE LE PAGINE -->
  <div class="sticky-top">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between   "
      style="background-color: #f8ebcd;">
      <!--BBBBBB-->
      <!-- tolto -> py-3: altezza header fissa/ mb-4: padding tra header e pag -->
      <!--in href mettere link per tornare in cima home page-->
      <a href="#" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
        <img src="logo_img/logo.png" style=" height: 60px;" title="Homepage Arready">
      </a>
      <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
        <li><a href="#" class="nav-link px-2 link-secondary">Home</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">Features</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">Pricing</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">FAQs</a></li>
        <!--<li><a href="utente.html" class="nav-link px-2 link-dark">UTENTE</a></li>-->
      </ul>
      <div class="col-md-3 text-end">
      <%String username = (String) session.getAttribute("username"); %>
      <%if (username == null){ %>
        <a href="log_in.jsp">
          <button type="button" class="btn btn-outline-primary me-2 bottone-arready-2">Accedi</button>
        </a>
        <a href="sign_in.html">
          <button type="button" class="btn btn-primary bottone-arready">Registrati</button>
        </a>
        <%}else{%>
        <form action="logout" method="get">
        	<input class="btn btn-primary bottone-arready" type="submit" value="Esci"></input>
        </form>
        <%} %>

      </div>
    </header>
  </div>



  <!--blocco top page /tolto: container-->
  <section class="py-5 text-center img-blocco-1 parallasse"
    style="background-size: cover; background-position: bottom; ">
    <!--background-color: #be9447;-->
    <div class="row py-lg-5">
      <div class="col-lg-6 col-md-8 mx-auto" style="background-color: rgba(255, 255, 255, 0.5);">
        <h1 class="fw-light" style="font-family: Georgia; color: #3d3d3d;">BENVENUTI SU ARREADY</h1>
        <p class="lead text-muted">Qui ci scriveremo qualcosa dopo!</p>
        <p>
          <a href="tutti_annunci.html">
            <button class="btn btn-primary my-2 bottone-arready">
              Guarda tutte le offerte
            </button>
          </a>
          <a href="caricamento_annuncio.html" class="btn btn-secondary my-2 ">Inserisci la tua offerta</a>
        </p>
      </div>
    </div>
  </section>
  <br>

  <!--barra alt-->
  <div class="input-group bg-light container" style="padding-top: 10px; padding-bottom: 20px;">
    <div class="container text-center">
      <p style="font-size: 22px;">Cerca il tuo prossimo appartamento</p>
    </div>
    <div class="spacer-searchbar"></div>
    <input type="text" class="form-control" placeholder="Cerca per citt&agrave;">
    <div class="input-group-append">
      <a href="tutti_annunci.html">
        <button class="btn btn-secondary" type="button">
          <i class="fa fa-search"></i>
        </button>
      </a>
    </div>
    <div class="spacer-searchbar"></div>
  </div>

  <!--CORPO CAROSELLO-->
  <main>
    <div class="" style="margin-left: 400px ; margin-right: 400px; padding-top: 50px;">
      <div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true"
            aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner ">
          <div class="carousel-item active">
            <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg"
              aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false">
              <rect width="100%" height="100%" fill="#777" />
            </svg>
            <img src="img/foto1.png">
            <div class="container">
              <div class="carousel-caption text-start">
                <h1>Appartamento bilocale cazzi e mazzi</h1>
                <p>10 mq, 2 bagni, ecc.</p>
                <p><a class="btn btn-lg btn-primary bottone-arready" href="annuncio.html">Visualizza Annuncio</a></p>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg"
              aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false">
              <rect width="100%" height="100%" fill="#777" />
            </svg>
            <img src="img/foto2.png">
            <div class="container">
              <div class="carousel-caption">
                <h1>Appartamento bilocale razzi e pazzi</h1>
                <p>10 mq, 2 bagni, ecc.</p>
                <p><a class="btn btn-lg btn-primary bottone-arready" href="annuncio.html">Visualizza Annuncio</a></p>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg"
              aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false">
              <rect width="100%" height="100%" fill="#777" />
            </svg>
            <img src="img/foto3.png">
            <div class="container">
              <div class="carousel-caption text-end">
                <h1>Appartamento bilocale lazzi e bazzi</h1>
                <p>10 mq, 2 bagni, ecc.</p>
                <p><a class="btn btn-lg btn-primary bottone-arready" href="annuncio.html">Visualizza Annuncio</a></p>
              </div>
            </div>
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
    </div>
  </main>
  <script src="assets/dist/js/bootstrap.bundle.min.js"></script>


  <!--FOOTER-->
  <footer class="container py-5">
    <div class="row">
      <div class="col-12 col-md">
        <p>Arready Immobiliare S.R.L.</p>
        <small class="d-block mb-3 text-muted">&copy; 2017–2021</small>
        <a href="#">
          <img src="logo_img/logo.png" style="height: 62px;" title="Arready Immobiliare">
        </a>
      </div>

      <div class="col-6 col-md">
        <h5>Assistenza</h5>
        <ul class="list-unstyled text-small">
          <li><a class="link-secondary" href="#">Domande frequenti</a></li>
          <li><a class="link-secondary" href="#">Centro assistenza</a></li>
        </ul>
      </div>

      <div class="col-6 col-md">
        <h5>Informazioni</h5>
        <ul class="list-unstyled text-small">
          <li><a class="link-secondary" href="#">Informazioni sull'azienda</a></li>
          <li><a class="link-secondary" href="#">Vuoi lavorare con noi?</a></li>
        </ul>
      </div>

      <div class="col-6 col-md">
        <h5>Cagate Legali</h5>
        <ul class="list-unstyled text-small">
          <li><a class="link-secondary" href="#">Preferenze Cookie</a></li>
          <li><a class="link-secondary" href="#">Privacy</a></li>
          <li><a class="link-secondary" href="#">Condizioni d'uso</a></li>
        </ul>
      </div>
    </div>
  </footer>

  <!--tasto back to top-->
  <div class="back-top-button" id="back-top-button">
    <button class="btn btn-secondary"
      style="border-radius: 50%; width: 60px; height: 60px; padding: 10px 10px 10px 10px;">
      <a href="#">
        <img src="components/icon/arrow_upward_white_24dp.svg" alt="Arrow-upward" title="Torna in cima">
      </a>
    </button>
  </div>


  <!--SCRIPTING-->
  <script>
    back_top = document.getElementById('back-top-button');

    window.addEventListener("scroll", () => {
      var y = window.scrollY;

      try {
        if (y <= 100) {
          back_top.classList.add('disappear');
          return;
        } else {
          back_top.classList.remove('disappear');
          // note that this is a class defined in your CSS.
        }
      } catch (error) {
        console.error(error);
      }
    }
    );
  </script>
</body>

</html>

<!--
 OK tra blocco e ricerca mettere scritta centrata "cerca appartamento x regione + pannello ricerca"

 OK mettere footer con back top

 carosello di img con annunci recenti
-->