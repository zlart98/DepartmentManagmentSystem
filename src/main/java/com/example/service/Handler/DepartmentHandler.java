//package com.example.Service.Handler;
//
//import com.example.Service.dao.DepartmentDao;
//import com.example.Service.dao.EmploeeDao;
//import com.example.Service.dao.impl.FactoryDaoImpl;
//import com.example.entity.Department;
//import com.example.entity.Worker;
//import com.example.exception.InputFormanException;
//
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//public class DepartmentHandler implements RequestHandler {
//
//    private final FactoryDaoImpl factoryDao;
//    private final DepartmentDao departmentDao;
//    private final EmploeeDao emploeeDao;
//
//    public DepartmentHandler(){
//        factoryDao = FactoryDaoImpl.getInstance();
//        departmentDao = factoryDao.getDepartmentDao();
//        emploeeDao = factoryDao.getEmploeeDao();
//    }
//
//
//    public void handle(HttpServletRequest request, HttpServletResponse response) throws InputFormanException, ServletException, IOException {
//
//        String[] path = request.getServletPath().substring(1).split("/");
//        if (path.length > 1){
//        switch (path[1]) {
//            case "saveOrUpdate":
//                saveOrUpdate(request, response);
//                break;
//            case "removeDepartment":
//                removeDepartment(request, response);
//                break;
//            case "enterTheDepartment":
//                enterTheDepartment(request, response);
//                break;
//            }
//        }else {
//            department(request, response);
//        }
//    }
//
//    private void department(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        List<Department> departments = departmentDao.findAll();
//        request.setAttribute("departmentList",departments);
//
//            request.getRequestDispatcher("department.jsp").forward(request, response);
//    }
//
//    private void saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws InputFormanException, ServletException, IOException {
//
//            Department department = new Department();
//            if (request.getParameter("name").matches("^-?\\d+$")){
//                throw new InputFormanException("Неверный ввод");
//            }
//            department.setDepartmentName(request.getParameter("name"));
//            final String idDepartment = request.getParameter("idDepartment");
//            if (idDepartment != null) {
//                department.setIdDepartment(Long.parseLong(idDepartment));
//            }
//            departmentDao.saveOrUpdate(department);
//
//            request.getRequestDispatcher("/department").forward(request, response);
//
//
//    }
//
//    private void removeDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Long idDepartment = Long.parseLong(request.getParameter("idDepartment"));
//        Department department = new Department();
//        department.setIdDepartment(idDepartment);
//
//        departmentDao.delete(department);
//
//            response.sendRedirect(request.getContextPath() + "/department");
//    }
//
//    private void enterTheDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//
//        String[] path = request.getServletPath().substring(1).split("/");
//        Worker worker = new Worker();
//        Department department;
//        if (path.length > 3){
//            if (path[3].equals("removeWorkerFromDepartment")){
//                worker = emploeeDao.findByIdWithWork((Long.parseLong(request.getParameter("idWorker"))));
//
//
//                departmentDao.removeWorkerFromDepartment(worker);
//
//                response.sendRedirect( request.getContextPath() + "/department/enterTheDepartment/"+ path[2] + "/");
//
//            }
//            else {
//
//                worker.setDepartmentByIdDepartment(departmentDao.findByIdWithDeps(Long.parseLong(path[2])));
//                worker.setIdWorker(Long.parseLong(request.getParameter("idWorker")));
//
//                    departmentDao.addWorkerInDepartment(worker);
//
//                    response.sendRedirect( request.getContextPath() + "/department/enterTheDepartment/"+ path[2] + "/");
//            }
//
//        }else {
//             department = departmentDao.findByIdWithDeps(Long.parseLong(path[2]));
//
//
//                List<Worker> workersFromDepartment = department.getWorkersByIdDepartment();
//                request.setAttribute("workersFromDepartment", workersFromDepartment);
//
//                List<Worker> workersWithoutDepartment = departmentDao.getWorkerWithoutDepartment();
//                request.setAttribute("workersWithoutDepartment", workersWithoutDepartment);
//
//                request.getRequestDispatcher("/editDepartment.jsp").forward(request, response);
//        }
//    }
//
//    /* private void addWorkerInDepartment(HttpServletRequest request, HttpServletResponse response){
//        String[] path = request.getServletPath().substring(1).split("/");
//        Long idDepartment = Long.parseLong(path[2]);
//        int idWorker =  Integer.parseInt(request.getParameter("idWorker"));
//        try {
//            addWorkerInDepartment.add(idDepartment, idWorker);
//            try {
//                request.getRequestDispatcher("/editDepartment.jsp").forward(request, response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }*/
//}
//
