package org.iteratorDesignPattern;

public class SimplePlayListIterator implements PlayListIterator{
    private final PlayList playList;
    private int curIndex;

    public SimplePlayListIterator(PlayList playList) {
        this.playList = playList;
        this.curIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return curIndex < playList.getSongs().size();
    }

    @Override
    public Song next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more songs in the playlist.");
        }
        return playList.getSongs().get(curIndex++);
    }
}
