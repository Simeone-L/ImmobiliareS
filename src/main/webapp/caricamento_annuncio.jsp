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
  <title>Caricamento Annunci</title>

  <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/checkout/">



  <!-- Bootstrap core CSS -->
  <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="index_immobiliare.css" rel="stylesheet">

  <!--CSS for search bar-->
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>

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

    .bottone-arready-2 {
      border-color: #be9447;
      color: #be9447;
    }
  </style>

  <!-- Custom styles for this template -->
  <link href="form-validation.css" rel="stylesheet">
</head>

<body class="bg-light">

  <!-- HEADER DI TUTTE LE PAGINE -->
  <div class="sticky-top">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between   "
      style="background-color: #f8ebcd;">
      <!-- tolto -> py-3: altezza header fissa/ mb-4: padding tra header e pag -->
      <!--in href mettere link per tornare in cima home page-->
      <a href="index_immobiliare.html"
        class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none"
        style="padding-left: 15px;">
        <img src="logo_img/logo.png" style="height: 60px;" title="Homepage Arready">
      </a>
      <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
        <li><a href="#" class="nav-link px-2 link-secondary">Home</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">Features</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">Pricing</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">FAQs</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">About</a></li>
      </ul>
      <div class="col-md-3 text-end">
        <%String username = (String) session.getAttribute("username"); %>
      	<%if (username == null){ %>
        <a href="log_in.jsp">
          <button type="button" class="btn btn-outline-primary me-2 bottone-arready-2">Accedi</button>
        </a>
        <a href="sign_in.jsp">
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

  <div class="container">
    <main>
      <div class="py-5 text-center">

        <h2>CARICA IL TUO ANNUNCIO DI VENDITA</h2>
        <p class="lead">Compila tutti i campi sottostanti e premi "carica annuncio" una volta completata la procedura.
        </p>
      </div>


      <div class="col-md-7 col-lg-8">
        <h4 class="mb-3">Inserisci campi</h4>
        <form class="needs-validation" novalidate>
          <div class="row g-3">
            <div class="col-sm-6">
              <label for="città" class="form-label">Città</label>
              <input type="text" class="form-control" id="città" placeholder="" value="" required>
              <div class="invalid-feedback">
                Inserisci città
              </div>
            </div>

            <div class="col-sm-6">
              <label for="provincia" class="form-label">Provincia</label>
              <input type="text" class="form-control" id="provincia" placeholder="" value="" required>
              <div class="invalid-feedback">
                Inserisci provincia
              </div>
            </div>

            <div class="col-12">
              <label for="superficie" class="form-label">Superficie</label>
              <div class="input-group has-validation">
                <span class="input-group-text">mq</span>
                <input type="text" class="form-control" id="superficie" placeholder="" required>
                <div class="invalid-feedback">
                  Inserisci i metri quadri
                </div>
              </div>
            </div>

            <div class="col-md-4">
              <label for="numeroAmbienti" class="form-label">Numero ambienti</label>
              <select class="form-select" id="numeroAmbienti" required>
                <option value="">Scegli</option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>Più di 9</option>
              </select>
              <div class="invalid-feedback">
                Seleziona numero ambienti
              </div>
            </div>

            <div class="col-md-4">
              <label for="piano" class="form-label">Piano</label>
              <select class="form-select" id="piano" required>
                <option value="">Scegli</option>
                <option>Piano terra</option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>Più di 9</option>
              </select>
              <div class="invalid-feedback">
                Seleziona piano
              </div>
            </div>

            <div class="col-md-4">
              <label for="bagni" class="form-label">Bagni</label>
              <select class="form-select" id="bagni" required>
                <option value="">Scegli</option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>Più di 3</option>
              </select>
              <div class="invalid-feedback">
                Seleziona numero bagni
              </div>
            </div>

            <div class="col-12">
              <label for="indirizzo" class="form-label">Indirizzo</label>
              <input type="text" class="form-control" id="indirizzo" placeholder="Via Mario Rossi" required>
              <div class="invalid-feedback">
                Inserisci indirizzo
              </div>
            </div>

            <div class="col-md-4">
              <label for="statoImmobile" class="form-label">Stato immobile</label>
              <select class="form-select" id="statoImmobile" required>
                <option value="">Scegli</option>
                <option>Nuovo</option>
                <option>Ristrutturato</option>
                <option>Vecchio</option>
              </select>
              <div class="invalid-feedback">
                Seleziona stato immobile
              </div>
            </div>

            <div class="col-md-4">
              <label for="country" class="form-label">Regione</label>
              <select class="form-select" id="country" required>
                <option value="">Scegli</option>
                <option>Abruzzo</option>
                <option>Basilicata</option>
                <option>Calabria</option>
                <option>Campania</option>
                <option>Emilia Romagna</option>
                <option>Friuli-Venezia Giulia</option>
                <option>Lazio</option>
                <option>Lombardia</option>
                <option>Marche</option>
                <option>Molise</option>
                <option>Piemonte</option>
                <option>Puglia</option>
                <option>Sardegna</option>
                <option>Sicilia</option>
                <option>Toscana</option>
                <option>Trentino-Alto Adige</option>
                <option>Umbria</option>
                <option>Valle d'Aosta</option>
                <option>Veneto</option>
              </select>
              <div class="invalid-feedback">
                Seleziona una regione
              </div>
            </div>

            <div class="col-md-3">
              <label for="cap" class="form-label">CAP</label>
              <input type="text" class="form-control" id="cap" placeholder="12345" required>
              <div class="invalid-feedback">
                Inserisci CAP
              </div>
            </div>
          </div>
      </div>

      <hr class="my-4">

      <p>Carica un'immagine per il tuo annuncio:</p>

      <form action="/action_page.php">
        <input type="file" id="myFile" name="filename">
        <div style="padding-top: 25px;">
          <input type="submit" class="w-100 btn btn-primary btn-lg bottone-arready">
        </div>
      </form>


      <!--<button class="w-100 btn btn-primary btn-lg" type="submit">Carica annuncio</button>-->
      </form>
  </div>
  </div>
  </main>

  <footer>

  </footer>
  </div>


  <script src="assets/dist/js/bootstrap.bundle.min.js"></script>

  <script src="form-validation.js"></script>
</body>

</html>
<!-- <p>Carica un'immagine per il tuo annuncio:</p>

<form action="/action_page.php">
  <input type="file" id="myFile" name="filename">
  <input type="submit">
</form>-->