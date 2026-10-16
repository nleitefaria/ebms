package com.nleitefaria.ebms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "dept_emp")
public class DeptEmp {

    @EmbeddedId
    private Id id;

    @MapsId("empNo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_no", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employees employee;

    @MapsId("deptNo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dept_no", nullable = false, columnDefinition = "CHAR(4)")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Departments department;

    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;

    protected DeptEmp() {
    }

    public DeptEmp(Employees employee, Departments department, LocalDate fromDate, LocalDate toDate) {
        this.id = new Id(employee.getEmpNo(), department.getDeptNo());
        this.employee = employee;
        this.department = department;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Id getId() {
        return id;
    }

    public Employees getEmployee() {
        return employee;
    }

    public Departments getDepartment() {
        return department;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    @Embeddable
    public static class Id implements Serializable {

        @Column(name = "emp_no", nullable = false)
        private Integer empNo;

        @Column(name = "dept_no", nullable = false, length = 4, columnDefinition = "CHAR(4)")
        private String deptNo;

        protected Id() {
        }

        public Id(Integer empNo, String deptNo) {
            this.empNo = empNo;
            this.deptNo = deptNo;
        }

        public Integer getEmpNo() {
            return empNo;
        }

        public String getDeptNo() {
            return deptNo;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Id that)) {
                return false;
            }
            return Objects.equals(empNo, that.empNo) && Objects.equals(deptNo, that.deptNo);
        }

        @Override
        public int hashCode() {
            return Objects.hash(empNo, deptNo);
        }
    }
}
