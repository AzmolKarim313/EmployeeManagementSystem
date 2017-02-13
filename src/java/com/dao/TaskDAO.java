/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.EmpInfo;
import com.pojo.TaskTable;
import com.util.ConnectionManager;
import com.util.HibernateUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Azmol-IT
 */
public class TaskDAO {
    
    public void addTask(EmpInfo employee,TaskTable task){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        task.setEmpInfo(employee);
        employee.getTaskTables().add(task);
        session.saveOrUpdate(task);
        session.getTransaction().commit();
        session.close();
    }
    
    public TaskTable taskInfoByTaskId(String taskId){
        TaskTable task = null;
        List<TaskTable> data = new ArrayList<TaskTable>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("select * from TaskTable where taskId = :tid");
        query.setString("tid", taskId);
        data = query.list();
        if (data.size() > 0) {
            task = data.get(0);
        }
        session.getTransaction().commit();
        session.close();
        return task;
    }
    
    Connection conn;
    PreparedStatement pstm;
    ConnectionManager conObj;
    
    public boolean addTask(String task_id, String title, String empid, Date startdate, Date enddate){
        conObj = new ConnectionManager();
        conn = conObj.doCOnnection();
        int n = 0;
        try {
            String stm = "insert into task_table(task_id, task_title, emp_id)"
                    + "values(?,?,?)";
            pstm = conn.prepareStatement(stm);
            pstm.setString(1, task_id);
            pstm.setString(2, title);
            pstm.setString(3, empid);
//            pstm.setDate(4, startdate);
//            pstm.setDate(5, enddate);
            n = pstm.executeUpdate();
        } catch (Exception e) {
        }
        return n > 0;
    }
    
    public static void main(String[] args) {
        TaskDAO testObj = new TaskDAO();
        EmpInfo emp = new EmpInfo();
        emp.setEmpId("Emp001");
        
        TaskTable task = new TaskTable();
        task.setTaskId("Task005");
        task.setTaskTitle("HRD");
        task.setRemarks("sdas");
        task.setStartDate(Date.valueOf("2016-05-02"));
        task.setEndDate(Date.valueOf("2016-05-22"));
        
        testObj.addTask(emp, task);
    }
    
}
