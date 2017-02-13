/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.PerformanceDAO;
import com.pojo.EmpInfo;
import com.pojo.PerformanceTable;
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
public class PerformanceMB {
    
    PerformanceTable perfor = new PerformanceTable();
    EmpInfo emp =new EmpInfo();

    List<PerformanceTable> listOfPerfor = new ArrayList<PerformanceTable>();
    List<PerformanceTable> listOfDesignation = new ArrayList<PerformanceTable>();
    
    PerformanceDAO dbPerform;
    
    /**
     * Creates a new instance of PromotionMB
     */
    public PerformanceMB() {
    }

    public EmpInfo getEmp() {
        return emp;
    }

    public void setEmp(EmpInfo emp) {
        this.emp = emp;
    }

    public PerformanceDAO getDbPerform() {
        return dbPerform;
    }

    public void setDbPerform(PerformanceDAO dbPerform) {
        this.dbPerform = dbPerform;
    }

    public List<PerformanceTable> getListOfPerfor() {
        dbPerform = new PerformanceDAO();
        return dbPerform.listOfPromotin(dbPerform.promotionRetData());
    }

    public void setListOfPerfor(List<PerformanceTable> listOfPerfor) {
        this.listOfPerfor = listOfPerfor;
    }

    public List<PerformanceTable> getListOfDesignation() {
        dbPerform = new PerformanceDAO();
        return dbPerform.listOfDesignation(dbPerform.designationRetData());
    }

    public void setListOfDesignation(List<PerformanceTable> listOfDesignation) {
        this.listOfDesignation = listOfDesignation;
    }
    
}
