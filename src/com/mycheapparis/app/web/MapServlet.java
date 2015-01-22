package com.mycheapparis.app.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by betezed on 28/10/14.
 */
public class MapServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * On redirige les demandes de / vers index.jsp. On pourrait ajouter des traitement supplémentaires si on voulait, avant d'afficher l'index.
         */
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
