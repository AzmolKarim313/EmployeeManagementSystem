/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.SalaryDAO;
import com.pojo.SalaryInfo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Azmol-IT
 */
@ManagedBean
@RequestScoped
public class SalaryMB {

    SalaryInfo salary = new SalaryInfo();
    
    List<SalaryInfo> listOfSalary = new ArrayList<SalaryInfo>();
    
    SalaryDAO dbSalary;
    
    /**
     * Creates a new instance of SalaryMB
     */
    public SalaryMB() {
    }

    public SalaryInfo getSalary() {
        return salary;
    }

    public void setSalary(SalaryInfo salary) {
        this.salary = salary;
    }

    public List<SalaryInfo> getListOfSalary() {
        dbSalary = new SalaryDAO();
        return dbSalary.listOfPromotin(dbSalary.promotionRetData("Emp001"));
    }

    public void setListOfSalary(List<SalaryInfo> listOfSalary) {
        this.listOfSalary = listOfSalary;
    }
    
}
