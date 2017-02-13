/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.EmpInfo;
import com.pojo.ExtraActivityTable;
import com.pojo.PerformanceTable;
import com.pojo.PromotiomTable;
import com.pojo.SalaryInfo;
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
public class SalaryDAO {

    Connection conn;
    PreparedStatement pstm;
    ConnectionManager conObj;

    public ResultSet promotionRetData(String id) {
        conObj = new ConnectionManager();
        conn = conObj.doCOnnection();
        ResultSet rs = null;
        try {
            String stm = "select emp_id, regular_salary, total_salary, payment_method, month\n"
                    + "from salary_info\n"
                    + "where emp_id = ?";
            pstm = conn.prepareStatement(stm);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }

    public List<SalaryInfo> listOfPromotin(ResultSet rs) {
        List<SalaryInfo> list = new ArrayList<SalaryInfo>();
        try {
            while (rs.next()) {
                SalaryInfo empPer = new SalaryInfo();
                empPer.setPaymentMethod(rs.getString("payment_method"));
                empPer.setRegularSalary(rs.getFloat("regular_salary"));
                empPer.setTotalSalary(rs.getFloat("total_salary"));
                empPer.setMonth(rs.getString("month"));
                list.add(empPer);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
