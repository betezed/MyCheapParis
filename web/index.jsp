<%--
  Created by IntelliJ IDEA.
  User: betezed
  Date: 28/10/14
  Time: 09:21
  To change this template use File | Settings | File Templates.
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>My Cheap Paris</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
    <!-- @TODO Il faudrait déplacer la déclaration des styles dans un CSS -->
    <style>
        *{ box-sizing: border-box;
        background-color: #435a6b}

        body{
            font-family: 'Open Sans', sans-serif;
            color: #4d4d4d;
        }

        h1{
            font-family: 'Myriad Pro', cursive;
            font-size: 6em;
            font-weight: 700;
            text-align: center;
            color: #2ecc71;

            margin: 0.25em 0;
        }
        h2{
            font-style: italic;
            text-align: center;
            margin-bottom: 2em;
            color: #DDDDDD;
        }
        section {
            margin: 0px auto;
            padding: 7em 3em;
            text-align: center;
        }
        nav a {
            position: relative;
            display: inline-block;
            margin: 15px 25px;
            outline: medium none;
            color: #FFF;
            text-decoration: none;
            text-transform: uppercase;
            letter-spacing: 1px;
            font-weight: 400;
            text-shadow: 0px 0px 1px rgba(255, 255, 255, 0.3);
            font-size: 1.35em;
        }

        .cl-effect-1 a::before,
        .cl-effect-1 a::after {
            display: inline-block;
            opacity: 0;
            -webkit-transition: -webkit-transform 0.3s, opacity 0.2s;
            -moz-transition: -moz-transform 0.3s, opacity 0.2s;
            transition: transform 0.3s, opacity 0.2s;
        }

        .cl-effect-1 a::before {
            margin-right: 10px;
            content: '[';
            -webkit-transform: translateX(20px);
            -moz-transform: translateX(20px);
            transform: translateX(20px);
        }

        .cl-effect-1 a::after {
            margin-left: 10px;
            content: ']';
            -webkit-transform: translateX(-20px);
            -moz-transform: translateX(-20px);
            transform: translateX(-20px);
        }

        .cl-effect-1 a:hover::before,
        .cl-effect-1 a:hover::after,
        .cl-effect-1 a:focus::before,
        .cl-effect-1 a:focus::after {
            opacity: 1;
            -webkit-transform: translateX(0px);
            -moz-transform: translateX(0px);
            transform: translateX(0px);
        }

    </style>
</head>
<body>
<h1>My Cheap Paris</h1>
<h2>Paris, en mieux</h2>
<section class="color-1">
<nav class="cl-effect-1">
    <!-- Appel de l'API pour avoir soit la liste des cafes, soit la liste des hotspots -->
<a href="http://localhost:8080/api/datas/type=cafe">Liste des cafés à moins de 1 euro</a>
<a href="http://localhost:8080/api/datas/type=hotspot">Liste des hotspot wifi gratuits</a>
</nav>
</section>

</body>
</html>