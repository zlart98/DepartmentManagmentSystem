//package com.example.Service.Handler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class GetHandler implements RequestHandler {
//    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String[] path = request.getServletPath().substring(1).split("/");
//        if (path[0].equals("servletException")){
//            request.getRequestDispatcher("/servletException.jsp").forward(request, response);
//        }else {
//            request.getRequestDispatcher("/menu.jsp").forward(request, response);
//        }
//
//
//    }
//}
