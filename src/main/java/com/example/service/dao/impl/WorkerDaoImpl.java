package com.example.service.dao.impl;

import com.example.service.dao.WorkerDao;
import com.example.entity.Department;
import com.example.entity.Worker;
import com.example.utils.MySqlSessionFactoryUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerDaoImpl implements WorkerDao {

    @Override
    public List<Worker> findAll() {
        try(Session session  = MySqlSessionFactoryUtil.openSession()) {
            List<Worker> result;
            result = session.createQuery("from  Worker ", Worker.class).getResultList();
            return result;
        }
    }


      @Override
    public Worker findById(Long id) {
          try(Session session  = MySqlSessionFactoryUtil.openSession();) {
              Worker worker;
              worker = session.load(Worker.class,id);
              return worker;
          }
    }
    @Override
    public Worker findByIdWithWork(Long id) {
        try(Session session  = MySqlSessionFactoryUtil.openSession();) {
            Worker worker;
            worker = session.load(Worker.class,id);
            Department department = worker.getDepartmentByIdDepartment();
            Hibernate.initialize(department);
            return worker;
        }
    }

    @Override
    public void delete(Worker worker) {
        try(Session session  = MySqlSessionFactoryUtil.openSession();) {
            session.delete(worker);
            session.getTransaction().commit();
        }
    }

    /*   @Override
    public void deleteOrAddWorkerInDepartment(Worker worker) {

        try (Connection connection = dataSource.getConnection();
             final Statement statement = connection.createStatement()){

            if (worker.getIdDeprtament() == null) {


                statement.executeUpdate( "UPDATE worker SET idDepartment="+ worker.getIdDeprtament()
                        + " WHERE idWorker=" + worker.getIdWorker());
            }else {

                statement.executeUpdate("UPDATE worker SET idDepartment=NULL WHERE idWorker=" + worker.getIdWorker());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public void saveOrUpdate(Worker worker) {
        try(Session session  = MySqlSessionFactoryUtil.openSession();) {
            if (worker.getIdWorker() == null) {
                session.save(worker);
                session.getTransaction().commit();
            }else {
                session.update(worker);
                session.getTransaction().commit();
            }
        }

    }
}





