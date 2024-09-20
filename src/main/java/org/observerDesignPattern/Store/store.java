package org.observerDesignPattern.Store;

import org.observerDesignPattern.Observable.phoneObservervableImpl;
import org.observerDesignPattern.Observable.stockObservable;
import org.observerDesignPattern.Observer.NotificationObserver;
import org.observerDesignPattern.Observer.emailNotificationObserver;
import org.observerDesignPattern.Observer.textMessageNotificationObserver;

public class store {
    public static void main(String[] args) {
        stockObservable stock = new phoneObservervableImpl();

        NotificationObserver notificationObserver1 = new emailNotificationObserver("obs1@gmail.com",stock);
        NotificationObserver notificationObserver2 = new emailNotificationObserver("obs2@gmail.com",stock);
        NotificationObserver notificationObserver3 = new textMessageNotificationObserver(9876543210L,stock);
        NotificationObserver notificationObserver4 = new textMessageNotificationObserver(1234567890L,stock);

        stock.add(notificationObserver1);
        stock.add(notificationObserver2);
        stock.add(notificationObserver3);
        stock.add(notificationObserver4);

        stock.setStockCount(10);

        // this will not notify observers
        stock.setStockCount(100);

        stock.setStockCount(0);

        // this will notify customers.
        stock.setStockCount(5);
    }
}
