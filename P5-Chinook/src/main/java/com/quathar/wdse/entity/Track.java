package com.quathar.wdse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TrackId", nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false, length = 200)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AlbumId")
    private Album album;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MediaTypeId", nullable = false)
    private Mediatype mediaType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GenreId")
    private Genre genre;

    @Column(name = "Composer", length = 220)
    private String composer;

    @Column(name = "Milliseconds", nullable = false)
    private Integer milliseconds;

    @Column(name = "Bytes")
    private Integer bytes;

    @Column(name = "UnitPrice", nullable = false, precision = 10, scale = 2)
    private java.math.BigDecimal unitPrice;

    @ManyToMany
    @JoinTable(name = "playlisttrack",
            joinColumns = @JoinColumn(name = "TrackId"),
            inverseJoinColumns = @JoinColumn(name = "PlaylistId"))
    private Set<Playlist> playlists = new LinkedHashSet<>();

    @OneToMany(mappedBy = "track")
    private Set<Invoiceline> invoicelines = new LinkedHashSet<>();

}
