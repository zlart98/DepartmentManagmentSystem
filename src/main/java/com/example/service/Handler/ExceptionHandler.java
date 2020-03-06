//package com.example.Service.Handler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class ExceptionHandler {
//   public void hanle(Exception e, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       String[] path = request.getServletPath().substring(1).split("/");
//
//       if (e.getClass().getSimpleName().equals("InputFormanException")){
//           request.setAttribute("inputeFormatException", e.getMessage());
//           request.getRequestDispatcher("/" + path[0]).forward(request, response);
//       }else {
//           response.sendRedirect( request.getContextPath() + "/servletException");
//       }
//   }
//}
