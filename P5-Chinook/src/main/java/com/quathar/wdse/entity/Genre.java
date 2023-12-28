package com.quathar.wdse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GenreId", nullable = false)
    private Integer id;

    @Column(name = "Name", length = 120)
    private String name;

    @OneToMany(mappedBy = "genre")
    private java.util.Set<Track> tracks = new java.util.LinkedHashSet<>();

}
