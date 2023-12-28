package com.quathar.wdse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeId", nullable = false)
    private Integer id;

    @Column(name = "LastName", nullable = false, length = 20)
    private String lastName;

    @Column(name = "FirstName", nullable = false, length = 20)
    private String firstName;

    @Column(name = "Title", length = 30)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ReportsTo")
    private Employee reportsTo;

    @Column(name = "BirthDate")
    private Instant birthDate;

    @Column(name = "HireDate")
    private Instant hireDate;

    @Column(name = "Address", length = 70)
    private String address;

    @Column(name = "City", length = 40)
    private String city;

    @Column(name = "State", length = 40)
    private String state;

    @Column(name = "Country", length = 40)
    private String country;

    @Column(name = "PostalCode", length = 10)
    private String postalCode;

    @Column(name = "Phone", length = 24)
    private String phone;

    @Column(name = "Fax", length = 24)
    private String fax;

    @Column(name = "Email", length = 60)
    private String email;

    @OneToMany(mappedBy = "reportsTo")
    private Set<Employee> employees = new LinkedHashSet<>();

    @OneToMany(mappedBy = "supportRep")
    private Set<Customer> customers = new LinkedHashSet<>();

}
