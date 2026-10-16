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
@Table(name = "salaries")
public class Salaries {

    @EmbeddedId
    private Id id;

    @MapsId("empNo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_no", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employees employee;

    @Column(name = "salary", nullable = false)
    private Integer salary;

    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;

    protected Salaries() {
    }

    public Salaries(Employees employee, Integer salary, LocalDate fromDate, LocalDate toDate) {
        this.id = new Id(employee.getEmpNo(), fromDate);
        this.employee = employee;
        this.salary = salary;
        this.toDate = toDate;
    }

    public Id getId() {
        return id;
    }

    public Employees getEmployee() {
        return employee;
    }

    public Integer getSalary() {
        return salary;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    @Embeddable
    public static class Id implements Serializable {

        @Column(name = "emp_no", nullable = false)
        private Integer empNo;

        @Column(name = "from_date", nullable = false)
        private LocalDate fromDate;

        protected Id() {
        }

        public Id(Integer empNo, LocalDate fromDate) {
            this.empNo = empNo;
            this.fromDate = fromDate;
        }

        public Integer getEmpNo() {
            return empNo;
        }

        public LocalDate getFromDate() {
            return fromDate;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Id that)) {
                return false;
            }
            return Objects.equals(empNo, that.empNo) && Objects.equals(fromDate, that.fromDate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(empNo, fromDate);
        }
    }
}
