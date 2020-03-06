package com.example.service.dao;

import com.example.entity.Worker;
import org.springframework.stereotype.Service;

import java.util.List;


public interface WorkerDao {

    List<Worker> findAll();
    Worker findByIdWithWork(Long id);
    Worker findById(Long idWorker);
    void delete(Worker worker);
    void save(Worker worker);
    void update(Worker worker);
}
