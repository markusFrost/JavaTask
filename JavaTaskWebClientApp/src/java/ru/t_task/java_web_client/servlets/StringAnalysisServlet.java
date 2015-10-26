/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.t_task.java_web_client.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import ru.t_task.java_web_client.ItemWord;
import ru.t_task.java_web_client.StringAnalysis_Service;


@WebServlet(name = "StringAnalysisServlet", urlPatterns = {"/StringAnalysisServlet"})
public class StringAnalysisServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/JavaTaskWebSevice/StringAnalysis.wsdl")
    private StringAnalysis_Service service;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {   
            String text1 = "", text2 = "", text3 = "", text4 = "", text5 = "";
            
            text1 = request.getParameter("info_text1");
            text2 = request.getParameter("info_text2");
            text3 = request.getParameter("info_text3");
            text4 = request.getParameter("info_text4");
            text5 = request.getParameter("info_text5");
            
            if ( text1.length() != 0 && text2.length() != 0 && text3.length() != 0 &&
                    text4.length() != 0 && text5.length() != 0 )
            {
            List<ItemWord> list = stringProcessing(text1, text2, text3, text4, text5);
 
            request.setAttribute("message", list);
            
            request.setAttribute("text1", text1 );
            request.setAttribute("text2", text2 );
            request.setAttribute("text3", text3 );
            request.setAttribute("text4", text4 );
            request.setAttribute("text5", text5 );
            
            }           
            
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            
        }
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private java.util.List<ru.t_task.java_web_client.ItemWord> stringProcessing(java.lang.String text1, java.lang.String text2, java.lang.String text3, java.lang.String text4, java.lang.String text5) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ru.t_task.java_web_client.StringAnalysis port = service.getStringAnalysisPort();
        return port.stringProcessing(text1, text2, text3, text4, text5);
    }

}
