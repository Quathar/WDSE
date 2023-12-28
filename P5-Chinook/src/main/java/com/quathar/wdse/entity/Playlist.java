package com.quathar.wdse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlaylistId", nullable = false)
    private Integer id;

    @Column(name = "Name", length = 120)
    private String name;

    @ManyToMany
    @JoinTable(name = "playlisttrack",
            joinColumns = @JoinColumn(name = "PlaylistId"),
            inverseJoinColumns = @JoinColumn(name = "TrackId"))
    private java.util.Set<Track> tracks = new java.util.LinkedHashSet<>();

}
