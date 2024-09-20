package org.observerDesignPattern.Observable;

import org.observerDesignPattern.Observer.NotificationObserver;

public interface stockObservable {
    public void add(NotificationObserver observer);
    public void remove(NotificationObserver observer);
    public void notifyObservers();
    public void setStockCount(int count);
    public int getStockCount();
}
