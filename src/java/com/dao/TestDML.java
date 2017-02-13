/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.EmpInfo;
import com.pojo.FamilyInfo;
import com.util.HibernateUtil;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Azmol-IT
 */
public class TestDML {

    public void doInsert(EmpInfo empInfo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(empInfo);
        session.getTransaction().commit();
    }

    public void doInsertFalimy(EmpInfo emp,FamilyInfo family) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        emp.setFamilyInfo(family);
        family.setEmpInfo(emp);
        session.save(family);
        session.getTransaction().commit();
    }
    
    public List<EmpInfo> empInfoAllData(){
        List<EmpInfo> allData = new ArrayList<EmpInfo>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from EmpInfo";
        Query query = session.createQuery(hql);
        allData = query.list();
        session.getTransaction().commit();
        session.close();
        return allData;
    }
    
    public EmpInfo empInfoAllDataById(String id){
        EmpInfo emp =null;
        List<EmpInfo> allData = new ArrayList<EmpInfo>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from EmpInfo where empId = :empId";
        Query query = session.createQuery(hql);
        query.setString("empId", id);
        allData = query.list();
        if (allData.size() > 0) {
            emp = allData.get(0);
        }
        session.getTransaction().commit();
        session.close();
        return emp;
    }
    
    public List<EmpInfo> empInfoAllId(){
        List<EmpInfo> allData = new ArrayList<EmpInfo>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "select empId from EmpInfo";
        Query query = session.createQuery(hql);
        allData = query.list();
        session.getTransaction().commit();
        session.close();
        return allData;
    }
    
    public static void main(String[] args) {
        TestDML testObj = new TestDML();
        if (testObj.empInfoAllId().isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println("not empty");
        }
    }

//    public static void main(String[] args) {
//        EmpInfo emp = new EmpInfo();
//        emp.setEmpId("Emp004");
//        emp.setFirstname("Emp001");
//        emp.setLastname("Emp001");
//        emp.setGender("Emp001");
//        emp.setJobTitle("Emp001");
//        emp.setDepartment("Emp001");
//        emp.setDob(Date.valueOf("2016-05-01"));
//        emp.setNationality("Emp001");
//        emp.setContact("Emp");
//        emp.setEmail("Emp");
//        emp.setMailAddress("Emp001");
//
//        FamilyInfo family = new FamilyInfo();
//        family.setNominyName("dfsf");
//        family.setContact("dfsf");
//        family.setEmail("dfsf");
//        family.setMailAddress("dfsf");
//        family.setRelation("dfsf");
//
//        TestDML obj = new TestDML();
//        obj.doInsert(emp);
//        obj.doInsertFalimy(emp,family);
//    }

}
