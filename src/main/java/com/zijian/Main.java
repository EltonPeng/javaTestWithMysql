package com.zijian;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // driver
        Class.forName("com.mysql.cj.jdbc.Driver");

//        String url = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=utf-8";
//        Connection conn = DriverManager.getConnection(url, "root", "root");
//        Statement stat = conn.createStatement();
//        stat.executeUpdate("create database mtt");
//        stat.close();
//        conn.close();

        String url = "jdbc:mysql://localhost:3306/mtt?useUnicode=true&characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url, "root", "root");
        Statement stat = conn.createStatement();
//        stat.executeUpdate("drop table trash;");
//        stat.executeUpdate("create table trash(id int NOT NULL, code varchar(80) NOT NULL, time1 datetime NOT NULL, time2 datetime, PRIMARY KEY (`id`));");
//        stat.executeUpdate("drop table event;");
//        stat.executeUpdate("create table event(code varchar(80) NOT NULL, action int NOT NULL, time1 datetime NOT NULL)");
//
//        for (int i = 1; i <= 50000; i++) {
//            Date startDateTime = new Date(2023, 4, 1, 9, 0, 0);
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String dateTime1 = sdf.format(startDateTime);
//            stat.executeUpdate("insert into `event` values('" + (600000 + i) + "', 1, '" + dateTime1 + "' )");
//
//            String dateTime2 = "NULL";
//            int random = new java.util.Random().nextInt(10);
//            if (random != 0) {
//                Calendar time = Calendar.getInstance();
//                time.setTime(startDateTime);
//                time.add(Calendar.MINUTE, random * 50);
//                dateTime2 = sdf.format(time.getTime());
//
//                stat.executeUpdate("insert into `event` values('" + (600000 + i) + "', 2, '" + dateTime2 + "' )");
//                stat.executeUpdate("insert into `trash` values(" + i + ", '" + (600000 + i) + "', '" + dateTime1 + "', '" + dateTime2 + "' )");
//            } else {
//                stat.executeUpdate("insert into `trash` values(" + i + ", '" + (600000 + i) + "', '" + dateTime1 + "', NULL )");
//            }
//        }


        ResultSet result = stat.executeQuery("SELECT id FROM trash WHERE trash.time2 IS NOT NULL AND TIMESTAMPDIFF(MINUTE, trash.time1, trash.time2) > 360;");

        Date start = new Date();
        while (result.next()) {
            result.getInt(1);
        }
        Date end = new Date();
        var diff = end.getTime() - start.getTime();

        result.close();
        stat.close();
        conn.close();

        System.out.println("Hello world!" + diff);
    }
}