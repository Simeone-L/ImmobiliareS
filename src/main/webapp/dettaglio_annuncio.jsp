<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
 
<!DOCTYPE html>
<html lang="it">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Annuncio</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="index_immobiliare.css" rel="stylesheet">

    <!--CSS for search bar-->
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>

    <!--css e js per carosello custom-->
    <link href="carosello.css" rel="stylesheet">
    <link href="carosello.js" rel="stylesheet">

    <!--Custom styles for Carousel-->
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

        .form-control {
            padding-left: 2.375rem;
        }

        .spacer-searchbar {
            padding-left: 25%;

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
    <form action="dettaglio-annuncio" method="get">
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


    <!--carosello-->
    <div style="float: left; width: 50%; padding-left: 150px; padding-top: 100px;">
        <div class="container">
            <main>
                <div id="myCarousel" class="carousel" data-bs-ride="carousel">
                    <div class="carousel-indicators">

                        <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active"
                            aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1"
                            aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2"
                            aria-label="Slide 3"></button>
                    </div>

                    <div class="carousel-inner">

                        <div class="carousel-item active">
                            <img src="img/foto1.png" id="immagine">
                        </div>

                        <div class="carousel-item">
                            <img src="img/foto2.png" id="immagine">
                        </div>

                        <div class="carousel-item">
                            <img src="img/foto3.png" id="immagine">
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel"
                        data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#myCarousel"
                        data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </main>
            <script src="assets/dist/js/bootstrap.bundle.min.js"></script>
        </div>
    </div>

    <!--descrizione-->
    <div style="float: right; width: 45%; ">
        <div class="container">

            <div style="padding-top: 100px;  width: 100%;">
                <h1 >
                  ${annuncio.titoloAnnuncio }
                
                </h1>
                <div>
                    <a href="#">link dell'utente proprietario dell'annuncio</a>
                    <!--da spostare sulla destra-->
                </div>
            </div>

            <div>
                <div style="width: fit-content;">
                    <pre style="font-size: 20px;">
                    <!-- descrizione-->
                 ${annuncio.immobile.descrizione }
                </pre>
                </div>
            </div>
            <div>
                <p style="font-size: 40px; display: inline;">Prezzo: ${annuncio.immobile.prezzo }</p>
                <!--inserire prezzo--> 
            </div>
        </div>
    </div>

    <div style="text-align: center; background-color: rgba(255, 232, 168, 0.212)">
        <div class="container" style="display: flex; width: 100%;">

            <table style="width: 50%;">
                <thead>
                    <tr>
                        <th> - CARATTERISTICHE - </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <p class="text-muted" style="float: left; ">Superficie</p>
                        </td>
                        <td>
                            <p style="float: right; "> ${annuncio.immobile.superficie } m??</p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p class="text-muted" style="float: left;">Numero di Locali</p>
                        </td>
                        <td>
                            <p style="float: right; "> [${annuncio.immobile.numLocali } </p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p class="text-muted" style="float: left; ">Numero di Bagni</p>
                        </td>
                        <td>
                            <p style="float: right;"> ${annuncio.immobile.numBagni } </p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p class="text-muted" style="float: left; ">Piano</p>
                        </td>
                        <td>
                            <p style="float: right; "> ${annuncio.immobile.piano } </p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p class="text-muted" style="float: left; ">Indirizzo</p>
                        </td>
                        <td>
                            <p style="float: right; "> ${annuncio.immobile.indirizzo.via }, ${annuncio.immobile.indirizzo.citta } n?? ${annuncio.immobile.indirizzo.numeroCivico }</p>
                        </td>
                    </tr>
                </tbody>
            </table>

        </div>

    </div>
    
    </form>

    <div style="padding-top: 100px; padding-left: 200px;">
        <div>
            <!--  <form action="" method="post"> -->
                <p style="font-size: 25px;">Contatta il venditore</p>
                <input class="form-control" type="text" name="oggetto_messaggio" id="oggetto_messaggio"
                    placeholder="oggetto del messaggio" style=" width: 25%; background-color: #be944749;">
                <br>
                <textarea rows="4" cols="100" name="messaggio" form="contatta_venditore"
                    style="background-color: #be944749;">Scrivi qui il tuo messaggio</textarea><br>
                <input class="btn btn-primary bottone-arready" type="submit" value="Invia">
            </form>
        </div>
    </div>

    <div style="padding-bottom: 100px; padding-top: 50px">
    </div>

    <!--FOOTER-->

    <footer class="py-5" style="background-color: #f8ebcd;">
        <div class="row container" style="margin: auto;">
            <div class="col-12 col-md">
                <p>Arready Immobiliare S.R.L.</p>
                <small class="d-block mb-3 text-muted">&copy; 2017???2021</small>
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
                <h5>Info Legali</h5>
                <ul class="list-unstyled text-small">
                    <li><a class="link-secondary" href="#">Preferenze Cookie</a></li>
                    <li><a class="link-secondary" href="#">Privacy</a></li>
                    <li><a class="link-secondary" href="#">Condizioni d'uso</a></li>
                </ul>
            </div>
        </div>
    </footer>
</body>
</html>