package ru.gasp.AutoShop.model;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Testtable_EO.findAll", query = "select o from Testtable_EO o") })
@Table(name = "TESTTABLE")
public class Testtable_EO implements Serializable {
    private static final long serialVersionUID = -8332456732518207823L;
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @Column(length = 20)
    private String name;
    private BigDecimal salary;
    @Column(length = 20)
    private String surname;

    public Testtable_EO() {
    }

    public Testtable_EO(BigDecimal id, String name, BigDecimal salary, String surname) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.surname = surname;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
