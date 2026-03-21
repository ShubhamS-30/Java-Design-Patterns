package org.iteratorDesignPattern;

public class FavoritePlayListIterator implements PlayListIterator{
    private final PlayList playList;
    private int curIndex;

    public FavoritePlayListIterator(PlayList playList) {
        this.playList = playList;
        this.curIndex = 0;
    }

    @Override
    public boolean hasNext() {
        while (curIndex < playList.getSongs().size()) {
            if (playList.getSongs().get(curIndex).isFavorite()) {
                return true;
            }
            curIndex++;
        }
        return false;
    }

    @Override
    public Song next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more favorite songs in the playlist.");
        }
        return playList.getSongs().get(curIndex++);
    }


}


