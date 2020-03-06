//package com.example.Service.Handler;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class LogoutHandler implements RequestHandler {
//
//   @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        request.getSession().invalidate();
//        response.sendRedirect(request.getContextPath() + "/");
//   }
//}
