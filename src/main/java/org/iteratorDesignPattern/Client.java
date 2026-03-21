package org.iteratorDesignPattern;

public class Client {
    public static void main(String[] args) {
        PlayList playList = new PlayList();
        playList.addSong(new Song("Song 1", "Artist A", false));
        playList.addSong(new Song("Song 2", "Artist B", true));
        playList.addSong(new Song("Song 3", "Artist C", false));
        playList.addSong(new Song("Song 4", "Artist D", true));
        playList.addSong(new Song("Song 5", "Artist E", false));
        playList.addSong(new Song("Song 6", "Artist F", true));

        System.out.println("All songs in the playlist:");
        PlayListIterator simpleIterator = new SimplePlayListIterator(playList);
        while (simpleIterator.hasNext()) {
            Song song = simpleIterator.next();
            System.out.println(song.getTitle() + " by " + song.getArtist());
        }

        System.out.println("\nFavorite songs in the playlist:");
        PlayListIterator favoriteIterator = new FavoritePlayListIterator(playList);
        while (favoriteIterator.hasNext()) {
            Song song = favoriteIterator.next();
            System.out.println(song.getTitle() + " by " + song.getArtist());
        }

        System.out.println("\nShuffled songs in the playlist:");
        PlayListIterator shuffleIterator = new ShufflePlayListIterator(playList);
        while (shuffleIterator.hasNext()) {
            Song song = shuffleIterator.next();
            System.out.println(song.getTitle() + " by " + song.getArtist());
        }
    }
}
