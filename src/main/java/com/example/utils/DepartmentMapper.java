package com.example.utils;

import com.example.entity.Department;
import org.springframework.jdbc.core.RowMapper;



import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentMapper implements RowMapper<Department> {

    @Override
    public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
        Department department = new Department();
        department.setIdDepartment(rs.getLong(1));
        department.setDepartmentName(rs.getString(2));
        return department;
    }


}
