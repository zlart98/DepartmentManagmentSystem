package com.example.controllers;

import com.example.entity.Department;
import com.example.entity.Worker;
import com.example.exception.InputFormanException;
import com.example.service.dao.DepartmentDao;
import com.example.service.dao.WorkerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private WorkerDao workerDao;

    @GetMapping
    public String department(Model model) {
        List<Department> departments = departmentDao.findAll();
        model.addAttribute("departmentList", departments);
        return "department";
    }

    @PostMapping(value = "/saveOrUpdate")
    public String saveOrUpdate(@RequestParam(value = "idDepartment", required = false) Long idDepartment,
                               @RequestParam String name) throws InputFormanException {

        Department department = new Department();
        if (name.matches("^-?\\d+$")) {
            throw new InputFormanException("Неверный ввод");
        }
        department.setDepartmentName(name);

        if (idDepartment != null) {
            department.setIdDepartment(idDepartment);
        }
        departmentDao.saveOrUpdate(department);

        return "redirect:/department";

    }

    @PostMapping("/removeDepartment")
    public String removeDepartment(@RequestParam(value = "idDepartment", required = false) Long idDepartment) {
        Department department = new Department();
        department.setIdDepartment(idDepartment);
        departmentDao.delete(department);
        return "redirect:/department";
    }

    @GetMapping("/enterTheDepartment/{departmentId}")
    public String editDepartment(@PathVariable Long departmentId, Model model) {

        Department department = departmentDao.findByIdWithDeps(departmentId);
        List<Worker> workersFromDepartment = department.getWorkersByIdDepartment();
        model.addAttribute("workersFromDepartment", workersFromDepartment);

        List<Worker> workersWithoutDepartment = departmentDao.getWorkerWithoutDepartment();
        model.addAttribute("workersWithoutDepartment", workersWithoutDepartment);

        return "editDepartment";
    }

    @GetMapping("/enterTheDepartment/{departmentId}/removeWorkerFromDepartment")
        public String removeWorkerFromDepartment(@PathVariable("departmentId") Long departmentId, @RequestParam("idWorker") Long idWorker, Model model){
        Worker worker = workerDao.findByIdWithWork(idWorker);

        departmentDao.removeWorkerFromDepartment(worker);

        return "redirect:/department/enterTheDepartment/" + departmentId + "/";
    }

    @GetMapping("/enterTheDepartment/{departmentId}/addWorkerInDepartment")
        public String addWorkerInDepartment(@PathVariable("departmentId") Long departmentId, @RequestParam("idWorker") Long idWorker, Model model){
        Worker worker = new Worker();
        worker.setDepartmentByIdDepartment(departmentDao.findByIdWithDeps(departmentId));
        worker.setIdWorker(idWorker);

        departmentDao.addWorkerInDepartment(worker);

        return "redirect:/department/enterTheDepartment/" + departmentId + "/";
    }

}
