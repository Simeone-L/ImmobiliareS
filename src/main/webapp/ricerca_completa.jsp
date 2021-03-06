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

  <!-- link for font -->
  <link href="font.css" rel="stylesheet">

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
    
    h2 {
      font-family: HomestayDemo;
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
       
       <form action="login" method="post">
       <c:when test="${username == null}" >
        <a href="log_in.jsp">
          <button type="button" class="btn btn-outline-primary me-2 bottone-arready-2">Accedi</button>
        </a>
        <form action="sign_in" method="post">
        <a href="sign_in.jsp">
          <button type="button" class="btn btn-primary bottone-arready">Registrati</button>
        </a>
        </form>
        </form>
        </c:when>
        <c:otherwise >
        <form action="logout" method="get">
        	<input class="btn btn-primary bottone-arready" type="submit" value="Esci"></input>
        </form>
        </c:otherwise>

      </div>
    </header>
  </div>

  <div class="container">
    <main>
      <div class="py-5 text-center">

        <h2>RICERCA AVANZATA TRA GLI ANNUNCI ONLINE</h2>
        <p class="lead">Compila tutti i campi sottostanti e premi "CERCA" una volta completata la procedura.
        </p>
      </div>


      <div class="col-md-7 col-lg-8" style="margin: auto;">
        <h4 class="mb-3">Inserisci campi</h4>
        <form class="needs-validation" novalidate>
          <div class="row g-3">
            <div class="col-12">
              <label for="titolo" class="form-label">Ricerca per Parole Chiave</label>
              <input type="text" class="form-control" id="titolo" name="titolo" placeholder="" value="qualsiasi">

            </div>

            <div class="col-sm-6">
              <label for="citta" class="form-label">Citt&agrave;</label>
              <input type="text" class="form-control" id="citta" name="citta" placeholder="" value="qualsiasi">

            </div>

            <div class="col-sm-6">
              <label for="provincia" class="form-label">Provincia</label>
              <select id="provincia" name="provincia" class="form-control">
                <option value="qualsiasi">Qualsiasi</option>
                <option value="ag">Agrigento</option>
                <option value="al">Alessandria</option>
                <option value="an">Ancona</option>
                <option value="ao">Aosta</option>
                <option value="ar">Arezzo</option>
                <option value="ap">Ascoli Piceno</option>
                <option value="at">Asti</option>
                <option value="av">Avellino</option>
                <option value="ba">Bari</option>
                <option value="bt">Barletta-Andria-Trani</option>
                <option value="bl">Belluno</option>
                <option value="bn">Benevento</option>
                <option value="bg">Bergamo</option>
                <option value="bi">Biella</option>
                <option value="bo">Bologna</option>
                <option value="bz">Bolzano</option>
                <option value="bs">Brescia</option>
                <option value="br">Brindisi</option>
                <option value="ca">Cagliari</option>
                <option value="cl">Caltanissetta</option>
                <option value="cb">Campobasso</option>
                <option value="ci">Carbonia-iglesias</option>
                <option value="ce">Caserta</option>
                <option value="ct">Catania</option>
                <option value="cz">Catanzaro</option>
                <option value="ch">Chieti</option>
                <option value="co">Como</option>
                <option value="cs">Cosenza</option>
                <option value="cr">Cremona</option>
                <option value="kr">Crotone</option>
                <option value="cn">Cuneo</option>
                <option value="en">Enna</option>
                <option value="fm">Fermo</option>
                <option value="fe">Ferrara</option>
                <option value="fi">Firenze</option>
                <option value="fg">Foggia</option>
                <option value="fc">Forl&igrave;-Cesena</option>
                <option value="fr">Frosinone</option>
                <option value="ge">Genova</option>
                <option value="go">Gorizia</option>
                <option value="gr">Grosseto</option>
                <option value="im">Imperia</option>
                <option value="is">Isernia</option>
                <option value="sp">La spezia</option>
                <option value="aq">L'aquila</option>
                <option value="lt">Latina</option>
                <option value="le">Lecce</option>
                <option value="lc">Lecco</option>
                <option value="li">Livorno</option>
                <option value="lo">Lodi</option>
                <option value="lu">Lucca</option>
                <option value="mc">Macerata</option>
                <option value="mn">Mantova</option>
                <option value="ms">Massa-Carrara</option>
                <option value="mt">Matera</option>
                <option value="vs">Medio Campidano</option>
                <option value="me">Messina</option>
                <option value="mi">Milano</option>
                <option value="mo">Modena</option>
                <option value="mb">Monza e della Brianza</option>
                <option value="na">Napoli</option>
                <option value="no">Novara</option>
                <option value="nu">Nuoro</option>
                <option value="og">Ogliastra</option>
                <option value="ot">Olbia-Tempio</option>
                <option value="or">Oristano</option>
                <option value="pd">Padova</option>
                <option value="pa">Palermo</option>
                <option value="pr">Parma</option>
                <option value="pv">Pavia</option>
                <option value="pg">Perugia</option>
                <option value="pu">Pesaro e Urbino</option>
                <option value="pe">Pescara</option>
                <option value="pc">Piacenza</option>
                <option value="pi">Pisa</option>
                <option value="pt">Pistoia</option>
                <option value="pn">Pordenone</option>
                <option value="pz">Potenza</option>
                <option value="po">Prato</option>
                <option value="rg">Ragusa</option>
                <option value="ra">Ravenna</option>
                <option value="rc">Reggio di Calabria</option>
                <option value="re">Reggio nell'Emilia</option>
                <option value="ri">Rieti</option>
                <option value="rn">Rimini</option>
                <option value="rm">Roma</option>
                <option value="ro">Rovigo</option>
                <option value="sa">Salerno</option>
                <option value="ss">Sassari</option>
                <option value="sv">Savona</option>
                <option value="si">Siena</option>
                <option value="sr">Siracusa</option>
                <option value="so">Sondrio</option>
                <option value="ta">Taranto</option>
                <option value="te">Teramo</option>
                <option value="tr">Terni</option>
                <option value="to">Torino</option>
                <option value="tp">Trapani</option>
                <option value="tn">Trento</option>
                <option value="tv">Treviso</option>
                <option value="ts">Trieste</option>
                <option value="ud">Udine</option>
                <option value="va">Varese</option>
                <option value="ve">Venezia</option>
                <option value="vb">Verbano-Cusio-Ossola</option>
                <option value="vc">Vercelli</option>
                <option value="vr">Verona</option>
                <option value="vv">Vibo valentia</option>
                <option value="vi">Vicenza</option>
                <option value="vt">Viterbo</option>
              </select>
            </div>

            <div class="col-8">
              <label for="indirizzo" class="form-label">Indirizzo</label>
              <input type="text" class="form-control" id="indirizzo" name="indirizzo" placeholder="Via Mario Rossi"
                 value="qualsiasi">
            </div>

            <div class="col-4">
              <label for="numeroCivico" class="form-label">Civico</label>
              <input type="text" class="form-control" id="numeroCivico" name="numeroCivico"
                placeholder="Via Mario Rossi" value="0" >

            </div>

            <div class="col-md-6">
              <label for="prezzoMin" class="form-label">Prezzo Minimo</label>
              <div class="input-group has-validation">
                <input type="number" class="form-control" id="prezzoMin" name="prezzoMin" placeholder="0" min="0" max="5000000" value="0">
                <span class="input-group-text">&#128;</span>
              </div>
            </div>

            <div class="col-md-6">
              <label for="prezzoMax" class="form-label">Prezzo Massimo</label>
              <div class="input-group has-validation">
              
                <input type="number" class="form-control" id="prezzoMax" name="prezzoMax" placeholder="5000000" min="0" max="5000000" value="5000000">
                <span class="input-group-text">&#128;</span>
              </div>
            </div>

            <div class="col-6">
              <label for="superficieMin" class="form-label">Superficie Minima</label>
              <div class="input-group has-validation">
                <input type="number" class="form-control" id="superficieMin" name="superficieMin" placeholder="0 mq"
                   min="0" max="100000" value="0">
                <span class="input-group-text">metri<sup>2</sup></span>
              </div>
            </div>

            <div class="col-6">
              <label for="superficieMax" class="form-label">Superficie Massima</label>
              <div class="input-group has-validation">
                <input type="number" class="form-control" id="superficieMax" name="superficieMax" placeholder="100000 mq"
                 mix="0" max="100000" value="100000">
                <span class="input-group-text">metri<sup>2</sup></span>
              </div>
            </div>

            <div class="col-md-4">
              <label for="numeroLocali" class="form-label">Numero Locali</label>
              <select class="form-select" id="numeroLocali" name="numeroLocali">
                <option value="0">Qualsiasi</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <!--  <option value="10"> 10</option> -->
              </select>

            </div>

            <div class="col-md-4">
              <label for="piano" class="form-label">Piano</label>
              <select class="form-select" id="piano" name="piano">
                <option value="-10">Qualsiasi</option>
                <option value="-1">-1</option>
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <!-- <option value="10">Pi?? di 9</option> -->
              </select>

            </div>

            <div class="col-md-4">
              <label for="bagni" class="form-label">Bagni</label>
              <select class="form-select" id="bagni" name="bagni">
                <option value="0">Qualsiasi</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option> <!-- to update numBagni+ -->
              </select>

            </div>

            <div class="col-md-5">
              <label for="statoImmobile" class="form-label">Condizioni dell'Immobile</label>
              <select class="form-select" id="statoImmobile" name="statoImmobile">
                <option value="qualsiasi">Qualsiasi</option>
                <option value="nuovo">Nuovo</option>
                <option value="buono">Buono</option>
                <option value="vecchio">Vecchio</option>
                <option value="ristrutturato">Ristrutturato</option>
                <option value="daRistrutturare">Da Restrutturare</option>
                <option value="inCostruzione">In Costruzione</option>
              </select>
            </div>

            <div class="col-md-5">
              <label for="statoVendita" class="form-label">Stato vendita</label>
              <select class="form-select" id="statoVendita" name="statoVendita">
                <option value="qualsiasi">Qualsiasi</option>
                <option value="vendita">Vendita</option>
                <option value="affitto">Affitto</option>
                <option value="affittoRiscatto">Affitto a Riscatto</option>
              </select>
            </div>

          </div>
      </div>

      <hr class="my-4">



      <form action="/action_page.php">


        <input type="submit" class="w-100 btn btn-primary btn-lg bottone-arready">

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
