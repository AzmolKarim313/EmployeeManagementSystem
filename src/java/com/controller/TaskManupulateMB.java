/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.TaskDAO;
import com.pojo.EmpInfo;
import com.pojo.TaskTable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Azmol-IT
 */
@ManagedBean
@RequestScoped
public class TaskManupulateMB {

    EmpInfo employee = new EmpInfo();
    TaskTable tasks = new TaskTable();
    
    TaskDAO dbTaskObj;
    
    /**
     * Creates a new instance of TaskManupulateMB
     */
    public TaskManupulateMB() {
    }

    public EmpInfo getEmployee() {
        return employee;
    }

    public void setEmployee(EmpInfo employee) {
        this.employee = employee;
    }

    public TaskTable getTasks() {
        return tasks;
    }

    public void setTasks(TaskTable tasks) {
        this.tasks = tasks;
    }
    
    public void taskInsert(){
        dbTaskObj = new TaskDAO();
        dbTaskObj.addTask(employee, tasks);
    }
    
    public void fullInfoTaskById(){
        dbTaskObj =new TaskDAO();
        TaskTable taskValue = dbTaskObj.taskInfoByTaskId(tasks.getTaskId());
        tasks.setTaskId(taskValue.getTaskId());
        tasks.setEndDate(taskValue.getEndDate());
        tasks.setStartDate(taskValue.getStartDate());
        tasks.setTaskTitle(taskValue.getTaskTitle());
    }
    
}
