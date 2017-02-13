/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.TestDML;
import com.pojo.EmpInfo;
import com.pojo.FamilyInfo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Azmol-IT
 */
@ManagedBean
@RequestScoped
public class EmployeeMB{

    EmpInfo empInfo = new EmpInfo();
    FamilyInfo family = new FamilyInfo();
    
    List<EmpInfo> empAllInfo = new ArrayList<EmpInfo>();
    List<EmpInfo> empAllId = new ArrayList<EmpInfo>();
    
    TestDML dbObj;
    
    public EmployeeMB() {
    }

    public EmpInfo getEmpInfo() {
        return empInfo;
    }

    public void setEmpInfo(EmpInfo empInfo) {
        this.empInfo = empInfo;
    }

    public FamilyInfo getFamily() {
        return family;
    }

    public void setFamily(FamilyInfo family) {
        this.family = family;
    }

    public List<EmpInfo> getEmpAllInfo() {
        dbObj = new TestDML();
        return dbObj.empInfoAllData();
    }

    public void setEmpAllInfo(List<EmpInfo> empAllInfo) {
        this.empAllInfo = empAllInfo;
    }

    public List<EmpInfo> getEmpAllId() {
        dbObj = new TestDML();
        return dbObj.empInfoAllId();
    }

    public void setEmpAllId(List<EmpInfo> empAllId) {
        this.empAllId = empAllId;
    }

    public void inset(){
        dbObj = new TestDML();
        dbObj.doInsert(empInfo);
        dbObj.doInsertFalimy(empInfo, family);
    }
    
    public void fullInfoById(){
        dbObj = new TestDML();
        EmpInfo empValues = dbObj.empInfoAllDataById(empInfo.getEmpId());
        empInfo.setEmpId(empValues.getEmpId());
        empInfo.setFirstname(empValues.getFirstname());
        empInfo.setLastname(empValues.getLastname());
        empInfo.setGender(empValues.getGender());
        empInfo.setContact(empValues.getContact());
        empInfo.setDepartment(empValues.getDepartment());
        empInfo.setDob(empValues.getDob());
        empInfo.setEmail(empValues.getEmail());
        empInfo.setNationality(empValues.getNationality());
        empInfo.setJobTitle(empValues.getJobTitle());
        empInfo.setMailAddress(empValues.getMailAddress());
    }
    
    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Employee inserted Successfully"));
        
    }
    
}
