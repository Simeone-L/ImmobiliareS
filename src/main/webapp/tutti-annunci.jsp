<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   


<!doctype html>
<html lang="it">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.88.1">
  <title>Schermata Annunci</title>

  <!-- Bootstrap core CSS -->
  <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="index_immobiliare.css" rel="stylesheet">

  <!-- link for font -->
  <link href="font.css" rel="stylesheet">

  <!--CSS for search bar
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>-->

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

    h1 {
      font-family: HomestayDemo;
    }
  </style>


</head>

<body>

  <!-- HEADER DI TUTTE LE PAGINE -->
  <div class="sticky-top">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between   "
      style="background-color: #f8ebcd;">
      <!-- tolto -> py-3: altezza header fissa/ mb-4: padding tra header e pag -->
      <!--in href mettere link per tornare in cima home page-->
      <a href="index_immobiliare.jsp"
        class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none"
        style="padding-left: 15px;">
        <img src="logo_img/logo.png" style="height: 60px;" title="Homepage Arready">
      </a>
      <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
        <li><a href="index_immobiliare.jsp" class="nav-link px-2 link-secondary">Home</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">Features</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">Pricing</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">FAQs</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">About</a></li>
      </ul>
      <div class="col-md-3 text-end">
        <a href="log_in.jsp">
          <button type="button" class="btn btn-outline-primary me-2 bottone-arready-2">Accedi</button>
        </a>
        <a href="sign_in.jsp" style="padding-right: 15px;">
          <button type="button" class="btn btn-primary bottone-arready">Registrati</button>
        </a>

      </div>
    </header>
  </div>

  <main style="width: 100%; height: 100%;">
    <!--BLOCCO CONTENUTI-->
    
  
    <section class="py-5 text-center container">
      <div class="row py-lg-5">
        <div class="col-lg-6 col-md-8 mx-auto">

          <h1>CERCA LA TUA PROSSIMA CASA</h1>
          <p>filtra per: </p>
          <div style="background-color: #f8ebcd;">
            <br>
            <form action="ricerca-annuncio" method="post">
              <div style="position: relative; text-align: left; padding-left: 50px;">

                <label for="prezzoMin">Prezzo Minimo  </label>
                <div style=" padding-left: 55px; display: inline-block;">
                  <input type="number" id="prezzoMin" placeholder="Qualsiasi" step="500" name="prezzoMin" min="0" max="5000000" value="0">
                </div>
                <br>
                <label for="prezzoMax">Prezzo Massimo  </label>
                <div style=" padding-left: 55px; display: inline-block;">
                  <input type="number" id="prezzoMax" placeholder="Qualsiasi" step="500" name="prezzoMax" min="0" max="5000000" value="5000000">
                  
                </div>
                <br>

                <label for="numeroLocali">Numero locali </label>
                <select id="numeroLocali" name="numeroLocali">
                  <option value="0">Qualsiasi</option>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                  <option value="4">4</option>
                  <option value="5">5</option> <!-- to update numLocali+ -->
                </select>
                <br>

                <label for="superficie">metri<sup>2</sup> superficie </label>
                <div style="position: absolute; padding-left: 10px; display: inline-block;">
                  <input type="range" id="superficie" name="superficie" min="0" max="100000" step="10" value="0"
                    oninput="this.nextElementSibling.value = this.value">
                  <output></output>metri<sup>2</sup>
                </div>
              </div>

              <label for="citta">
                <p style="font-size: 25px;">Cerca</p>
                <!--ricerca per titolo-->
              </label>
              <input type="search" name="citta" id="citta" style="size: 50%;" value="qualsiasi">
              
              <input type="submit" value="Cerca" class="btn btn-primary bottone-arready" style="width: 100px;">
            </form>
            <a href="ricerca_completa.jsp">
              <!--pagina ricerca completa-->
              pi&ugrave; filtri
            </a>
            <br><br>
            <form method="ricerca-annuncio" action="get">
              <label for="ordinamento">Ordina per:</label>
              <select id="ordinamento" name="ordinamentoPrezzo">
                <option value="crescente">prezzo crescente</option>
                <option value="decrescente">prezzo decrescente</option>
              </select>  
               <select id="ordinamento" name="ordinamentoSuperficie"> 
                <option value="crescente">superficie crecente</option>
                <option value="decrescente">superficie decrescente</option>
              </select>
              <input class="btn btn-outline-primary bottone-arready-2" type="submit" value="Ordina" >
            </form>
            <br>
          </div>
        </div>
      </div>
    </section>
    <!--<div style="position: relative; width: 50%; text-align: left; padding-left: 50px;">-->


    <!-- ALBUM -->
    <div class="album py-5" style="background-color: #fdf6e3a4; ">
      <div class="container">

        <!--riga-->
        <div class="row-cols-sm-2 row-cols-md-3 g-3" style="margin: auto;">
        <!--  row row-cols-1  -->

          <!--INIZIO CICLO-->
          <!--colonna-->
          <!--inizio casella-->
          <c:forEach items="${annunci}" var="annuncio">
          <div class="col">
            <a href="" style="color: black; text-decoration: none; cursor: pointer;">
              <div class="card shadow-sm">
                <img class="bd-placeholder-img card-img-top" width="100%" height="225" role="img"
                  aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"
                  src="https://imagizer.imageshack.com/img924/3462/z9BgMv.jpg"> <!-- change image -->
                <div class="card-body">
                  <p class="card-text">
                  
                  ${annuncio.titoloAnnuncio}
                  </p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                     
                      <form action="dettaglio-annuncio" method="get">
                       <input type="submit" class="btn btn-sm btn-outline-secondary" value="Apri"/>
                      <input type="hidden" name="id" value="${ annuncio.id}"/>
                      </form>
                      
                      <!--<button type="button" class="btn btn-sm btn-outline-secondary">Modifica</button>-->
                    </div>
                    <small class="text-muted">100â¬</small>
                  </div>
                </div>
              </div>
            </a>
            

          </div>
          
          </c:forEach>
          <!--fine singola casella-->
     

        <!--FINE CLICLO-->




      </div>
    </div>

  </main>

  <!--FOOTER-->
  <footer class="py-5" style="background-color: #f8ebcd;">
    <div class="row container" style="margin: auto;">
      <div class="col-12 col-md">
        <p>Arready Immobiliare S.R.L.</p>
        <small class="d-block mb-3 text-muted">&copy; 2017â2021</small>
        <a href="index_immobiliare.html">
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
        <h5>Info Legali</h5>
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


  <script src="assets/dist/js/bootstrap.bundle.min.js"></script>


</body>

</html>

<!--
  <h1 class="fw-light">Annunci di vendita</h1>
          <p class="lead text-muted">Something short and leading about the collection belowâits contents, the creator,
            etc. Make it short and sweet, but not too short so folks donât simply skip over it entirely.</p>
          <p>
            <a href="#" class="btn btn-primary my-2">Main call to action</a>
            <a href="#" class="btn btn-secondary my-2">Secondary action</a>
          </p>

-->