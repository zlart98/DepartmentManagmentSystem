package com.example.controllers;

import com.example.entity.Department;
import com.example.entity.Worker;
import com.example.service.dao.DepartmentDao;
import com.example.service.dao.WorkerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private WorkerDao workerDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping
    public String getWorkers(Model model) {
        List<Worker> workers = workerDao.findAll();
        model.addAttribute("workerList", workers);

        List<Department> departments = departmentDao.findAll();
        model.addAttribute("departmentList", departments);

        return "worker";
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdateWorker(@RequestParam(value = "idWorker", required = false) Long idWorker,
                              @RequestParam(value = "name") String name,
                              @RequestParam(value = "position") String position,
                              @RequestParam(value = "idDepartment", required = false) Long idDepartment){

        Worker worker = new Worker();
        worker.setIdWorker(idWorker);
        worker.setName(name);
        worker.setPosition(position);
        worker.setWorkposition(position);
        if (idDepartment != null){
            Department department = departmentDao.findById(idDepartment);
            if (department != null) {
                worker.setDepartmentByIdDepartment(department);
            }else {
                throw new RuntimeException("eeee");
            }
        }
        workerDao.saveOrUpdate(worker);
        return "redirect:/worker";
    }

    @GetMapping("/removeWorker")
    public String removeWorker(@RequestParam("idWorker") Long idWorker){
        Worker worker = workerDao.findById(idWorker);
        if (worker != null){
            workerDao.delete(worker);
        }
        return "redirect:/worker";
    }
}
