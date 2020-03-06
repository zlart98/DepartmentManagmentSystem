//package com.example.Service.Handler;
//
//import com.example.Service.dao.DepartmentDao;
//import com.example.Service.dao.impl.DepartmentDaoImpl;
//import com.example.Service.dao.EmploeeDao;
//import com.example.Service.dao.impl.EmploeeDaoMySqlImpl;
//import com.example.entity.Department;
//import com.example.entity.Worker;
//import com.example.exception.InputFormanException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//public class WorkerHandler implements RequestHandler {
//
//    private final DepartmentDao departmentDaoMySql;
//    private final EmploeeDao emploeeDaoMySql;
//
//
//
//    public WorkerHandler()  {
//        departmentDaoMySql = new DepartmentDaoImpl();
//        emploeeDaoMySql = new EmploeeDaoMySqlImpl();
//    }
//
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response) throws InputFormanException, ServletException, IOException {
//        String[] path = request.getServletPath().substring(1).split("/");
//        if (path.length > 1){
//        switch (path[1]) {
//            case "newWorker":
//                newWorker(request, response);
//                break;
//            case "removeWorker":
//                removeWorker(request, response);
//                break;
//            case "editWorker":
//                editWorker(request, response);
//                break;
//            }
//        }
//        else {
//            worker(request, response);
//        }
//    }
//
//    private void worker(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Worker> workers = emploeeDaoMySql.findAll();
//        request.setAttribute("workerList",workers);
//
//        List<Department>  departments = departmentDaoMySql.findAll();
//        request.setAttribute("departmentList",departments);
//
//        request.getRequestDispatcher("emploee.jsp").forward(request, response);
//
//    }
//
//    private void newWorker(HttpServletRequest request, HttpServletResponse response) throws InputFormanException, IOException {
//
//            if (request.getParameter("name").matches("^-?\\d+$")||
//                    request.getParameter("position").matches("^-?\\d+$")){
//                throw new InputFormanException("Неверный ввод");
//            }
//
//            Worker worker = new Worker();
//            worker.setName(request.getParameter("name"));
//            worker.setPosition(request.getParameter("position"));
//            worker.setWorkposition(request.getParameter("workposition"));
//
//            if (!request.getParameter("idDepartment").equals("")) {
//                Department department = departmentDaoMySql.findById(Long.parseLong(request.getParameter("idDepartment")));
//                worker.setDepartmentByIdDepartment(department);
//            }
//                emploeeDaoMySql.save(worker);
//
//                response.sendRedirect(request.getContextPath() + "/worker");
//
//    }
//    private void removeWorker(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Long idWorker = Long.parseLong(request.getParameter("idWorker"));
//        Worker worker = new Worker();
//        worker.setIdWorker(idWorker);
//        emploeeDaoMySql.delete(worker);
//
//            response.sendRedirect(request.getContextPath() + "/worker");
//
//    }
//
//   /* private void removeWorkerFromDepartment(HttpServletRequest request, HttpServletResponse response){
//
//        Worker worker = new Worker();
//        worker.setIdDepartament(Long.parseLong(request.getParameter("idDepartment")));
//        worker.setIdWorker(Integer.parseInt(request.getParameter("idWorker")));
//
//        try {
//                emploeeDaoMySql.deleteOrAddWorkerInDepartment(worker);
//            request.getRequestDispatcher("/editDepartment.jsp").forward(request, response);
//        }  catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }*/
//
//   /* private void addWorkerInDepartment(HttpServletRequest request, HttpServletResponse response){
//        Long idDepartment = (Long) request.getSession().getAttribute("idDepartment");
//        String[] path = request.getServletPath().substring(1).split("/");
//        int idWorker = Integer.parseInt(path[1]);
//        try {
//            addWorkerInDepartment.add(idDepartment,idWorker);
//
//            try {
//                request.getRequestDispatcher("/department").forward(request, response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }*/
//
//    private void editWorker(HttpServletRequest request, HttpServletResponse response) throws InputFormanException, IOException {
//
//
//            if (request.getParameter("name").matches("^-?\\d+$")||
//                    request.getParameter("position").matches("^-?\\d+$")){
//                throw new InputFormanException("Неверный ввод");
//            }
//
//            Worker worker = new Worker();
//
//            worker.setIdWorker(Long.parseLong(request.getParameter("idWorker")));
//            worker.setName(request.getParameter("name"));
//            worker.setPosition(request.getParameter("position"));
//            worker.setWorkposition(request.getParameter("workposition"));
//
//
//
//            emploeeDaoMySql.update(worker);
//
//            response.sendRedirect(request.getContextPath() + "/worker");
//    }
//}
