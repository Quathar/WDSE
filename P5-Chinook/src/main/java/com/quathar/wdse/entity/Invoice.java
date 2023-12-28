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

@Getter
@Setter
@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InvoiceId", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CustomerId", nullable = false)
    private Customer customer;

    @Column(name = "InvoiceDate", nullable = false)
    private java.time.Instant invoiceDate;

    @Column(name = "BillingAddress", length = 70)
    private String billingAddress;

    @Column(name = "BillingCity", length = 40)
    private String billingCity;

    @Column(name = "BillingState", length = 40)
    private String billingState;

    @Column(name = "BillingCountry", length = 40)
    private String billingCountry;

    @Column(name = "BillingPostalCode", length = 10)
    private String billingPostalCode;

    @Column(name = "Total", nullable = false, precision = 10, scale = 2)
    private java.math.BigDecimal total;

    @OneToMany(mappedBy = "invoice")
    private java.util.Set<Invoiceline> invoicelines = new java.util.LinkedHashSet<>();

}
