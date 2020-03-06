package com.example.utils;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class DatasourseHibernate {

    private final static String DB_CONNECTION = "jdbc:mysql://localhost:3306/new_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String  DB_USER = "root";
    private final static String DB_PASSWORD = "root";

    private static MysqlDataSource mysqlDataSource;
    private static DataSource dataSource;


    private static DataSource createDatasourse(){
        mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUrl(DB_CONNECTION);
        mysqlDataSource.setUser(DB_USER);
        mysqlDataSource.setPassword(DB_PASSWORD);
        dataSource = mysqlDataSource;

        return dataSource;
    }

    public static synchronized DataSource getDatasourse(){
        if(mysqlDataSource == null){
            dataSource = createDatasourse();
        }
        return dataSource;
    }
}
