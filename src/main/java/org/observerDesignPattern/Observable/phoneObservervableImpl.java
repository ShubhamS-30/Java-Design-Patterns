package org.observerDesignPattern.Observable;

import org.observerDesignPattern.Observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class phoneObservervableImpl implements stockObservable {

    private int stock = 0;
    private List<NotificationObserver> observers = new ArrayList<NotificationObserver>();

    @Override
    public void add(NotificationObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(NotificationObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (NotificationObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int count) {
        if (this.stock == 0)
        {
            this.stock = count;
            notifyObservers();
        }
        else
            this.stock = count;
    }

    @Override
    public int getStockCount() {
        return this.stock;
    }
}
