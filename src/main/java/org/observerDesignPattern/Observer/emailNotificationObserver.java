package org.observerDesignPattern.Observer;

import org.observerDesignPattern.Observable.stockObservable;

public class emailNotificationObserver implements NotificationObserver {

    private String email;
    private stockObservable observable;

    public emailNotificationObserver(String email, stockObservable observable) {
        this.email = email;
        this.observable = observable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public stockObservable getObservable() {
        return observable;
    }

    public void setObservable(stockObservable observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        sendEmail();
    }

    public void sendEmail() {
        System.out.println("Only " + observable.getStockCount() + " left!! Email sent to : " + email);
    }
}
