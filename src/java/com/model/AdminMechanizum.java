/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.sql.Date;

/**
 *
 * @author Azmol-IT
 */
public class AdminMechanizum {

    public int leaveDates(Date start_date, Date end_date) {
        return (int)(end_date.getTime() - start_date.getTime())/ (1000 * 60 * 60 * 24);
    }
    
    public float totalSalary(float reg_salary, float anno_salary){
        return reg_salary+anno_salary;
    }

//    public static void main(String[] args) {
//        AdminMechanizum testObj = new AdminMechanizum();
//        System.out.println(testObj.totalSalary(5000, 1200));
//    }

}
