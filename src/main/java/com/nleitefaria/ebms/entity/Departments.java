package com.nleitefaria.ebms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
        name = "departments",
        uniqueConstraints = @UniqueConstraint(columnNames = "dept_name"))
public class Departments {

    @Id
    @Column(name = "dept_no", nullable = false, length = 4, columnDefinition = "CHAR(4)")
    private String deptNo;

    @Column(name = "dept_name", nullable = false, length = 40)
    private String deptName;

    protected Departments() {
    }

    public Departments(String deptNo, String deptName) {
        this.deptNo = deptNo;
        this.deptName = deptName;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
