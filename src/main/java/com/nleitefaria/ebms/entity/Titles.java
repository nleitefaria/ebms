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
@Table(name = "titles")
public class Titles {

    @EmbeddedId
    private Id id;

    @MapsId("empNo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_no", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employees employee;

    @Column(name = "to_date")
    private LocalDate toDate;

    protected Titles() {
    }

    public Titles(Employees employee, String title, LocalDate fromDate, LocalDate toDate) {
        this.id = new Id(employee.getEmpNo(), title, fromDate);
        this.employee = employee;
        this.toDate = toDate;
    }

    public Id getId() {
        return id;
    }

    public Employees getEmployee() {
        return employee;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    @Embeddable
    public static class Id implements Serializable {

        @Column(name = "emp_no", nullable = false)
        private Integer empNo;

        @Column(name = "title", nullable = false, length = 50)
        private String title;

        @Column(name = "from_date", nullable = false)
        private LocalDate fromDate;

        protected Id() {
        }

        public Id(Integer empNo, String title, LocalDate fromDate) {
            this.empNo = empNo;
            this.title = title;
            this.fromDate = fromDate;
        }

        public Integer getEmpNo() {
            return empNo;
        }

        public String getTitle() {
            return title;
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
            return Objects.equals(empNo, that.empNo)
                    && Objects.equals(title, that.title)
                    && Objects.equals(fromDate, that.fromDate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(empNo, title, fromDate);
        }
    }
}
