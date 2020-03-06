package com.example.service.dao.impl;

import com.example.service.dao.DepartmentDao;
import com.example.service.dao.WorkerDao;
import com.example.entity.Department;
import com.example.entity.Worker;
import com.example.utils.MySqlSessionFactoryUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentDaoImpl implements DepartmentDao {

  @Autowired
  private WorkerDao workerDao;

    @Override
    public List<Department> findAll() {
        try (Session session = MySqlSessionFactoryUtil.openSession();) {
            List<Department> result;
            result = session.getSession().createQuery("from  Department", Department.class).getResultList();
            return result;
        }

    }

    @Override
    public Department findById(Long idDepartment) {
        try (Session session = MySqlSessionFactoryUtil.openSession()) {
            Department department;
            department = session.load(Department.class, idDepartment);
            return department;
        }
    }

    @Override
    public Department findByIdWithDeps(Long idDepartment) {
        try (Session session = MySqlSessionFactoryUtil.openSession();) {
            Department department;
            department = session.load(Department.class, idDepartment);
            department.getWorkersByIdDepartment().forEach( w-> Hibernate.initialize(w));
            return department;
        }
    }

    @Override
    public void delete(Department department) {
        Department departmentEntity = findByIdWithDeps(department.getIdDepartment());
        try (Session session = MySqlSessionFactoryUtil.openSession();) {
            List<Worker> workerListFromDepartment = departmentEntity.getWorkersByIdDepartment();
            if (workerListFromDepartment != null) {
            for (Worker w : workerListFromDepartment) {
                removeWorkerFromDepartment(w);
            }
        }
            session.delete(department);
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveOrUpdate(Department department) {
        try (Session session = MySqlSessionFactoryUtil.openSession();) {
            if (department.getIdDepartment() == null) {
                session.save(department);
                session.getTransaction().commit();
            } else {
                session.update(department);
                session.getTransaction().commit();
            }
        }
    }

    @Override
    public List<Worker> getWorkerWithoutDepartment() {
        try (Session session = MySqlSessionFactoryUtil.openSession();) {
            List<Worker> result;
            result = session.createQuery("FROM Worker WHERE departmentByIdDepartment IS NULL").getResultList();
            return result;
        }
    }

    @Override
    public void removeWorkerFromDepartment(Worker worker) {
        try (Session session = MySqlSessionFactoryUtil.openSession();) {
            worker.setDepartmentByIdDepartment(null);
            session.update(worker);
            session.getTransaction().commit();

        }
    }

    @Override
    public void addWorkerInDepartment(Worker worker) {
        try (Session session = MySqlSessionFactoryUtil.openSession();) {
            Worker workerEntity = workerDao.findByIdWithWork(worker.getIdWorker());
            Hibernate.initialize(workerEntity);
            workerEntity.setDepartmentByIdDepartment(worker.getDepartmentByIdDepartment());
            session.update(workerEntity);
            session.getTransaction().commit();
        }
    }

}



