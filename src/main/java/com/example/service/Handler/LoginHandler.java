//package com.example.Service.Handler;
//
//import com.example.bean.User;
//import com.example.utils.AppUtils;
//import com.example.utils.DataDAO;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//public class LoginHandler implements RequestHandler {
//
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String[] path = request.getServletPath().substring(1).split("/");
//        if (path.length > 1) {
//            switch (path[1]) {
//                case "loginPage":
//                    getLoginPage(request, response);
//                    break;
//                case "auth":
//                    auth(request, response);
//                    break;
//                case "accessDenied":
//                    accessDenied(request, response);
//                    break;
//            }
//        }
//
//    }
//
//    private void getLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/login.jsp").forward(request, response);
//
//    }
//
//    private void auth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("userName");
//        String password = request.getParameter("password");
//        User userAccount = DataDAO.findUser(username, password);
//        if (userAccount == null) {
//            String errorMessage = "Invalid userName or Password";
//
//            request.setAttribute("errorMessage", errorMessage);
//
//
//                request.getRequestDispatcher("/login/loginPage").forward(request, response);
//
//            return;
//        }
//        AppUtils.storeLoginedUser(request.getSession(), userAccount);
//
//        //
//        int redirectId = -1;
//
//
//
//        String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
//        if (requestUri != null) {
//
//                response.sendRedirect(requestUri);
//
//        } else {
//            // По умолчанию после успешного входа в систему
//            // перенаправить на страницу /userInfo
//
//                response.sendRedirect(request.getContextPath() + "/");
//
//        }
//    }
//
//    private void accessDenied(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/accessDeniedView.jsp").forward(request, response);
//
//    }
//}
