package com.example.utils;

import com.example.entity.Department;
import com.example.entity.Worker;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmploeeMapper implements RowMapper<Worker> {

    @Override
    public Worker mapRow(ResultSet resultSet, int i) throws SQLException {
        Worker worker = new Worker();
        Department department = new Department();
        worker.setIdWorker(resultSet.getLong(1));
        worker.setName(resultSet.getString(2));
        worker.setPosition(resultSet.getString(3));
        worker.setWorkposition(resultSet.getString(4));
        department.setIdDepartment(resultSet.getLong(5));
        worker.setDepartmentByIdDepartment(department);
        return worker;
    }
}
