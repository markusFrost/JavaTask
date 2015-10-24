/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.t_task.java_web_client;

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

/**
 *
 * @author Андрей
 */
@WebServlet(name = "StringAnalysisServlet", urlPatterns = {"/StringAnalysisServlet"})
public class StringAnalysisServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/JavaTaskWebSevice/StringAnalysis.wsdl")
    private StringAnalysis_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            //int num1 = Integer.parseInt( request.getParameter("num1") );
            
             String text1 = "Привет! dream dream dream dream Меня зовут Андрей. And  I very  work work work work like to &&& java-applications!";
        String text2 = "Привет! Меня зовут Андрей. And develop I very like to develop java-applications!";
        String text3 = "Привет! Меня  dream dream whiteMonk dream dream зовут Андрей. And develop I very  work work work work like to develop java-applications!";
        String text4 = "Привет! Меня зовут Андрей. And develop I 1234 very like to develop java-applications!";
        String text5 = "Привет! Меня  whiteMonk dream Applications dream dream dream  work work work work зовут Андрей. And  I very like to  java-applications! work dream";
        
            List<ItemWord> list = stringProcessing(text1, text2, text3, text4, text5);
           
            String value = "Результат расчётов : " +  list.size();
            
            request.setAttribute("message", value);
            
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
