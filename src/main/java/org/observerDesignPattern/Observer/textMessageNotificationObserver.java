package org.observerDesignPattern.Observer;

import org.observerDesignPattern.Observable.stockObservable;

public class textMessageNotificationObserver implements NotificationObserver {

    private Long phoneNo;
    private stockObservable observable;

    public textMessageNotificationObserver(Long phoneNo, stockObservable observable) {
        this.phoneNo = phoneNo;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMessage();
    }

    public void sendMessage() {
        System.out.println("Only " + observable.getStockCount() + " left!! Message sent to Phone no : " + phoneNo);
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public stockObservable getObservable() {
        return observable;
    }

    public void setObservable(stockObservable observable) {
        this.observable = observable;
    }
}
