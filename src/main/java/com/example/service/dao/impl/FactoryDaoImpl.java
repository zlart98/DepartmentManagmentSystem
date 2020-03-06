package com.example.service.dao.impl;


import com.example.service.dao.DepartmentDao;
import com.example.service.dao.WorkerDao;

public class FactoryDaoImpl {

    private static FactoryDaoImpl factoryDaoInstance = null;
    private static DepartmentDao departmentDao = null;
    private static WorkerDao workerDao = null;

    public static FactoryDaoImpl getInstance(){
        if (factoryDaoInstance == null) {
            factoryDaoInstance = new FactoryDaoImpl();
        }
        return factoryDaoInstance;
    }

    public synchronized DepartmentDao getDepartmentDao(){
        if (departmentDao == null) {
            departmentDao = new DepartmentDaoImpl();
        }
        return departmentDao;
    }

    public synchronized WorkerDao getEmploeeDao(){
        if (workerDao == null) {
            workerDao = new WorkerDaoImpl();
        }
        return workerDao;
    }
}

