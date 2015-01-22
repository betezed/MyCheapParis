package com.mycheapparis.app.api;

import com.mycheapparis.app.model.Cafe;
import com.mycheapparis.app.model.Hotspot;
import com.mycheapparis.app.model.Location;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by betezed on 24/11/14.
 */
public class ApiServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED,
                "POST is not supported yed. Please use GET requests.");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processGetRequest(request, response);
    }

    protected void processGetRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * On cherche un couple key=valeur
         */
        StringBuilder sb = new StringBuilder(request.getPathInfo());
        sb.deleteCharAt(0);
        String fileName;
        String key = "";
        String value = "";
        String typeLocation = sb.toString();
        /*
         * Donc on split sur le = pour avoir le membre de droite et de gauche. On verifiera qu'il n'y a bien qu'un couple a=b
         */
        String[] argRequest = typeLocation.split("=");
        /*
         * S'il y a plus de couple cle-valeur, on avertira que les données sont invalides
         */
        if (argRequest.length != 2)
            fileName = "ERROR";
        else {
            /*
             Sinon, on cherche le fichier json qui convient
             */
            key = argRequest[0];
            value = argRequest[1];
            if (key.equals("type")) {
                fileName = "http://hackndo.com/" + value + ".json";
            } else {
                fileName = "ERROR";
            }
        }
        if (fileName != "ERROR") {
            /*
             * S'il n'y a pas d'erreur, on parse le fichier json, soit avec l'adapter de hotspot, soit celui de cafe
             */
            Location[] locations = new Location[0];
            String json;
            json = IOUtils.toString(new URL(fileName).openStream());
            switch (value) {
                case "hotspot":
                    locations = Hotspot.getInstance().parseLocations(json);
                    break;
                case "cafe":
                    locations = Cafe.getInstance().parseLocations(json);
                    break;
            }
            request.setAttribute("locations", new ArrayList<>(Arrays.asList(locations)));
        } else {
            request.setAttribute("locations", new Location[0]);
        }
        getServletContext().getRequestDispatcher("/map.jsp").forward(request, response);
    }
}
