<%@ page import="java.util.List" %>
<%@ page import="com.mycheapparis.app.model.Location" %>
<%@ page import="org.apache.commons.lang.StringEscapeUtils" %>
<% List<Location> locations = (List<Location>) request.getAttribute("locations"); %>
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
    <title>The Cheap Paris</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
    <!-- @TODO Il faudrait déplacer la déclaration des styles dans un CSS -->
    <style>
        html, body, #map-canvas { height: 95%; margin: 0px; padding: 0px }

        h1 { position: absolute;
            top: 0;
            left: 100px;
            font-family: 'Myriad Pro', cursive;

            background-color: #435a6b;
            display: inline-block;
            padding: 10px;
            margin: 0 auto 0;
            border-radius: 0 0 10px 10px;
        }
        h1 a {text-decoration: none; color:#85A2B7;}
        h1 a:visited { text-decoration: none; color:#85A2B7; }
        h1 a:hover { text-decoration: none; color: #A5C2D7;; }
        h1 a:focus { text-decoration: none; color:#85A2B7; }
        h1 a:hover, a:active { text-decoration: none; color:#85A2B7 }
        .color-1 {
            background-color: #435a6b
        }
        section {
            margin: 0px auto;
            padding: 2em 3em;
            text-align: center;
        }
        nav a {
            position: relative;
            display: inline-block;
            margin: 15px 25px;
            outline: medium none;
            color: #85A2B7;
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
        .cl-effect-1 a:hover {
            color: #A5C2D7;
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
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>

    <script>
        var map;
        function initialize() {
            var mapOptions = {
                zoom: 12
            };
            map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

            // Try HTML5 geolocation
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(function(position) {

                    var centre = new google.maps.LatLng(48.861893,
                            2.347);


                    map.setCenter(centre);
                    <!-- On récupère la liste des véhicules, récupéré dans MapServlet, en récupérant l'attribut, et en le castant -->
                    <% int compteur = 0;
                        if (locations != null) {
                            if (locations.size() > 0) {
                                for (Location l : locations) {
                                    if (l.getLocationEntry().getLatitude() !=0) {%>
                                        var contentString_<%= compteur %> = '<div id="content">'+
                                                '<div id="siteNotice">'+
                                                '</div>'+
                                                '<h3 id="firstHeading" class="firstHeading"><%= StringEscapeUtils.escapeJavaScript(l.getName()) %></h3>'+
                                                '<div id="bodyContent">'+
                                                '<p><b>Address : </b><%= StringEscapeUtils.escapeJavaScript(l.getAddress().toString()) %>'+
                                                '</div>'+
                                                '</div>';

                                        var infowindow_<%= compteur %> = new google.maps.InfoWindow({
                                            content: contentString_<%= compteur %>
                                        });

                                        var marker_<%= compteur %> = new google.maps.Marker({
                                            position: new google.maps.LatLng(<%= l.getLocationEntry().getLatitude() %>, <%= l.getLocationEntry().getLongitude() %>),
                                            map: map,
                                            title: '<%= StringEscapeUtils.escapeJavaScript(l.getName()) %>'
                                        });
                                        google.maps.event.addListener(marker_<%= compteur %>, 'click', function() {
                                            infowindow_<%= compteur %>.open(map,marker_<%= compteur %>);
                                        });
                                        <% compteur++;
                                    }
                                }
                            } else { %>
                                alert("Invalid data");
                        <% }
                        } else { %>
                            alert("Unable to connect to the database");
                     <% }%>
                }, function () {
                    handleNoGeolocation(true);
                });
            } else {
                // Browser doesn't support Geolocation
                handleNoGeolocation(false);
            }
        }

        function handleNoGeolocation(errorFlag) {
            if (errorFlag) {
                var content = 'Error: The Geolocation service failed.';
            } else {
                var content = 'Error: Your browser doesn\'t support geolocation.';
            }

            var options = {
                map: map,
                position: new google.maps.LatLng(60, 105),
                content: content
            };

            var infowindow = new google.maps.InfoWindow(options);
            map.setCenter(options.position);
        }


        google.maps.event.addDomListener(window, 'load', initialize);
    </script>
</head>
<body>
<div id="map-canvas"></div>
<h1><a href="/index.jsp">My Cheap Paris</a></h1>
<section class="color-1">
    <nav class="cl-effect-1">
        <a href="http://localhost:8080/api/datas/type=cafe">Liste des cafés à moins de 1 euro</a>
        <a href="http://localhost:8080/api/datas/type=hotspot">Liste des hotspot wifi gratuits</a>
    </nav>
</section>
</body>
</html>