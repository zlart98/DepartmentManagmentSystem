package com.example.service.dao;

import com.example.entity.Department;
import com.example.entity.Worker;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentDao {

    List<Department> findAll();
    Department findById(Long idDepartment);
    Department findByIdWithDeps(Long idDepartment);
    void delete(Department department);
    void saveOrUpdate(Department department);
    List<Worker> getWorkerWithoutDepartment();
    void removeWorkerFromDepartment(Worker worker);
    void addWorkerInDepartment(Worker worker);

}
