package com.pojo;
// Generated Nov 30, 2016 8:49:37 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * PromotiomTable generated by hbm2java
 */
public class PromotiomTable  implements java.io.Serializable {


     private Integer promotionId;
     private EmpInfo empInfo;
     private Date promotionDate;
     private String position;

    public PromotiomTable() {
    }

    public PromotiomTable(EmpInfo empInfo, Date promotionDate, String position) {
       this.empInfo = empInfo;
       this.promotionDate = promotionDate;
       this.position = position;
    }
   
    public Integer getPromotionId() {
        return this.promotionId;
    }
    
    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }
    public EmpInfo getEmpInfo() {
        return this.empInfo;
    }
    
    public void setEmpInfo(EmpInfo empInfo) {
        this.empInfo = empInfo;
    }
    public Date getPromotionDate() {
        return this.promotionDate;
    }
    
    public void setPromotionDate(Date promotionDate) {
        this.promotionDate = promotionDate;
    }
    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }




}

