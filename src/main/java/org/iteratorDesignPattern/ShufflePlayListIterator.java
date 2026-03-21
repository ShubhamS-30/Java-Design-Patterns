package org.iteratorDesignPattern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ShufflePlayListIterator implements PlayListIterator{
    private final PlayList playList;
    private int curIndex;
    private List<Song> shuffledSongs;

    public ShufflePlayListIterator(PlayList playList) {
        this.playList = playList;
        this.curIndex = 0;
        this.shuffledSongs = new ArrayList<>(playList.getSongs());
        Collections.shuffle(this.shuffledSongs);
    }

    @Override
    public boolean hasNext() {
        return curIndex < shuffledSongs.size();
    }

    @Override
    public Song next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more songs in the playlist.");
        }
        return shuffledSongs.get(curIndex++);
    }


}
