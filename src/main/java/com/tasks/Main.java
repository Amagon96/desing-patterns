package com.tasks;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class Main {

    static void main() {

        List<Song> masterOfPuppets = List.of(
                new Song("Orion", 9_123),
                new Song("Master Of Puppets (Song)", 97_272),
                new Song("Battery", 18_567));
        List<Song> blackAlbum = List.of(
                new Song("Enter Sandman", 165_362),
                new Song("Through the Never", 6_771),
                new Song("My Friend of Misery", 1_236),
                new Song("Unknown Error", null));
        List<Song> seasons = List.of(
                new Song("Shadows Follow", 1_309),
                new Song("Screaming Suicide", 2_472),
                new Song("Lux AEterna", 13_425));
        Artist artist = new Artist("Metallica", List.of(
                new Album("Master Of Puppets", masterOfPuppets),
                new Album("Black Album", blackAlbum),
                new Album("72 Seasons", seasons)));

//        System.out.println("-------------- Greatest Songs --------------");
//        artist.greatestSongs().forEach(System.out::println);

        System.out.println("\n-------------- Greatest Song By Album --------------");
        artist.greatestSongByAlbum().forEach((key, value) -> System.out.println(key + ": " + value));

//        System.out.println("\n-------------- Greatest Album --------------");
//        System.out.println(artist.greatestAlbumName());
    }
}


class Artist {
    private String name;
    private List<Album> albumList;

    public Artist(String name, List<Album> albumList) {
        this.name = name;
        this.albumList = albumList;
    }

    /** EXERCISE 1
     * @return Songs with more than 10,000 playbackCount sorted by playbackCount (descending order).
     *
     * Expected Result:
     * --- Greatest Songs ---
     * Song[name=Enter Sandman, playbackCount=165362]
     * Song[name=Master Of Puppets (Song), playbackCount=97272]
     * Song[name=Lux AEterna, playbackCount=13425]
     *
     */
    public List<Song> greatestSongs() {
        // ------- Code here -------
        return albumList.stream()
                .flatMap(album -> album.getSongs().stream())
                .filter(song -> (
                        Objects.nonNull(song.getPlaybackCount())
                                && song.getPlaybackCount() > 10_000 ))
                .toList();
    }

    /** EXERCISE 2
     * @return Top song of each album.
     *
     * --- Greatest Song By Album ---
     * Master Of Puppets: Song[name=Master Of Puppets (Song), playbackCount=97272]
     * 72 Seasons: Song[name=Lux AEterna, playbackCount=13425]
     * Black Album: Song[name=Enter Sandman, playbackCount=165362]
     *
     */
    public Map<String, Song> greatestSongByAlbum() {
        // ------- Code here -------
        // Artist is already created, use albumList to start.

        return albumList.stream()
                .collect(Collectors.toMap(
                        Album::getName,
                        album -> album.getSongs().stream()
                                .max(Comparator.comparing(song ->
                                        Optional.ofNullable(song.getPlaybackCount()).orElse(0)))
                                .orElseThrow(() -> new IllegalArgumentException("")))
                );
    }

    /** EXERCISE 3
     * @return Album with the greatest playback count.
     *
     * --- Greatest Album ---
     * Black Album
     *
     */
    public String greatestAlbumName() {
        // ------- Code here -------
        // Artist is already created, use albumList to start.
        return "";
    }

}

class Album {
    private String name; private List<Song> songs;
    public Album(String name, List<Song> songs) { this.name = name; this.songs = songs;}
    public List<Song> getSongs() {return songs;}
    public String getName() {
        return name;
    }

    public String toString() {return "Album[name=" + name + ", songs=" + songs + ']';}
}

class Song {
    private String name; private Integer playbackCount;
    public Song(String name, Integer playbackCount) {this.name = name; this.playbackCount = playbackCount;}
    public Integer getPlaybackCount() {return playbackCount;}
    public String toString() {return "Song[name=" + name + ", playbackCount=" + playbackCount + ']';}
}