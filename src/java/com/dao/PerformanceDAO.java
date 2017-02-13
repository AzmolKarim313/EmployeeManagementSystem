/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.EmpInfo;
import com.pojo.PerformanceTable;
import com.pojo.PromotiomTable;
import com.util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Azmol-IT
 */
public class PerformanceDAO {

    Connection conn;
    PreparedStatement pstm;
    ConnectionManager conObj;

    public ResultSet promotionRetData() {
        conObj = new ConnectionManager();
        conn = conObj.doCOnnection();
        ResultSet rs = null;
        try {
            String stm = "select e.emp_id, e.firstname,e.lastname, p.noOfAssignment, p.noOfClientDeily, p.leave, p.month\n"
                    + "from emp_info e , performance_table p\n"
                    + "where e.emp_id = p.emp_id";
            pstm = conn.prepareStatement(stm);
            rs = pstm.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }

    public List<PerformanceTable> listOfPromotin(ResultSet rs) {
        List<PerformanceTable> list = new ArrayList<PerformanceTable>();
        try {
            while (rs.next()) {
                PerformanceTable empPer = new PerformanceTable();
                EmpInfo emp = new EmpInfo();
                emp.setEmpId(rs.getString("emp_id"));
                emp.setFirstname(rs.getString("firstname"));
                emp.setLastname(rs.getString("lastname"));
                empPer.setLeave(rs.getInt("leave"));
                empPer.setNoOfClientDeily(rs.getInt("noOfClientDeily"));
                empPer.setNoOfAssignment(rs.getInt("noOfAssignment"));
                empPer.setEmpInfo(emp);
                empPer.setMonth(rs.getString("month"));
                list.add(empPer);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ResultSet designationRetData() {
        conObj = new ConnectionManager();
        conn = conObj.doCOnnection();
        ResultSet rs = null;
        try {
            String stm = "select e.emp_id, e.firstname,e.lastname, p.noOfAssignment, p.noOfClientDeily, p.leave, p.month, e.job_title\n"
                    + "from emp_info e , performance_table p\n"
                    + "where e.emp_id = p.emp_id";
            pstm = conn.prepareStatement(stm);
            rs = pstm.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }

    public List<PerformanceTable> listOfDesignation(ResultSet rs) {
        List<PerformanceTable> list = new ArrayList<PerformanceTable>();
        try {
            while (rs.next()) {
                PerformanceTable empPer = new PerformanceTable();
                EmpInfo emp = new EmpInfo();
                emp.setEmpId(rs.getString("emp_id"));
                emp.setFirstname(rs.getString("firstname"));
                emp.setLastname(rs.getString("lastname"));
                emp.setJobTitle(rs.getString("job_title"));
                empPer.setLeave(rs.getInt("leave"));
                empPer.setNoOfClientDeily(rs.getInt("noOfClientDeily"));
                empPer.setNoOfAssignment(rs.getInt("noOfAssignment"));
                empPer.setEmpInfo(emp);
                empPer.setMonth(rs.getString("month"));
                list.add(empPer);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        PerformanceDAO obj = new PerformanceDAO();
//        System.out.println(obj.listOfPromotin(obj.promotionRetData()));

        ResultSet rs = obj.promotionRetData();
        try {
            while (rs.next()) {
                System.out.println(rs.getInt("leave"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerformanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
