/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculadora;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bladimir
 */
@WebServlet(name = "calcular", urlPatterns = {"/calcular"})
public class calcular extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet calcular</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet calcular at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    private int num1;
    private int num2;
    private int opcion;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        num1=Integer.parseInt(request.getParameter("numero1"));
        num2=Integer.parseInt(request.getParameter("numero2"));
        opcion=Integer.parseInt(request.getParameter("opcion"));
        if(opcion==1){
            int s=suma(num1, num2);
            request.getSession().setAttribute("resultado", s);     
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if(opcion==2){
            request.getSession().setAttribute("resultado", multiplicar(num1, num2));
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if(opcion==3){
            request.getSession().setAttribute("resultado", mayor(num1, num2));
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if(opcion==4){
            request.getSession().setAttribute("resultado", potencia(num1, num2));
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if(opcion==5){
         request.getSession().setAttribute("resultado", Binario(num1, num2));   
         request.getRequestDispatcher("index.jsp").forward(request, response);
        }
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

    private int suma(int N1,int N2){
        return (N1+N2);
    }
    private double multiplicar(int N1,int N2){
        double resultado=0;
        return resultado=(N1*N2);
    }
    private String mayor(int N1,int N2){
        String dato;
        if(N1>N2){
            dato="es el mayor "+N1;
        }else{
            dato="es el mayor "+N2;
        }
        return dato ;
    }
    private double potencia(int N1,int N2){
        double resultado=0;
        return resultado=((int) Math.pow(N1, N2));
    }
    private String Binario(int N1,int N2){
        String resultado="";
        String b1=Integer.toBinaryString(N1);
        String b2=Integer.toBinaryString(N2);
        resultado="binario 1 "+b1+" binario 2 "+b2;
        return resultado;
    }
}
