package com.quathar.wdse.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "playlisttrack")
public class Playlisttrack {

    @EmbeddedId
    private PlaylisttrackId id;

    @MapsId("playlistId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PlaylistId", nullable = false)
    private Playlist playlist;

    @MapsId("trackId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TrackId", nullable = false)
    private Track track;

}
