package org.observerDesignPattern;

import org.observerDesignPattern.Observable.phoneObservervableImpl;
import org.observerDesignPattern.Observer.NotificationObserver;
import org.observerDesignPattern.Observer.emailNotificationObserver;
import org.observerDesignPattern.Observer.textMessageNotificationObserver;

/**
 * Main class - Client that demonstrates the Observer Design Pattern implementation.
 * The Observer Pattern is a behavioral design pattern that defines a one-to-many dependency between objects.
 * When one object (Observable/Subject) changes state, all its dependents (Observers) are notified automatically.
 * This example shows how multiple observers (email and SMS notifications) are notified whenever 
 * the stock count changes in the observable object.
 */
public class Main {
    public static void main(String[] args) {
        
        // Create an Observable object that will act as the subject/publisher
        // phoneObservervableImpl represents a phone stock that observers will monitor
        phoneObservervableImpl stock = new phoneObservervableImpl();
        
        // Create Email Notification Observers - these will receive notifications via email
        // Each observer is initialized with an email address and a reference to the observable
        NotificationObserver emailObserver1 = new emailNotificationObserver("emailObserver1@gmail.com", stock);
        NotificationObserver emailObserver2 = new emailNotificationObserver("emailObserver2@gmail.com", stock);
        
        // Create Text Message Notification Observers - these will receive notifications via SMS
        // Each observer is initialized with a phone number and a reference to the observable
        NotificationObserver textMessageObserver1 = new textMessageNotificationObserver(9876543210L, stock);
        NotificationObserver textMessageObserver2 = new textMessageNotificationObserver(1234567890L, stock);

        // Register all observers with the Observable object
        // The Observable maintains a list of observers and will notify them when state changes
        stock.add(emailObserver1);
        stock.add(emailObserver2);
        stock.add(textMessageObserver1);
        stock.add(textMessageObserver2);
        
        // Trigger state changes in the Observable
        // Each setStockCount() call will notify all registered observers about the change
        // This is the "push" notification mechanism of the Observer Pattern
        
        // Setting stock count to 10 - all observers will be notified
        stock.setStockCount(10);
        
        // Setting stock count to 0 -  stock is out
        stock.setStockCount(0);
        
        // Setting stock count to 5 - all observers will be notified
        stock.setStockCount(5);

        // Setting stock count to 0 -  stock is out
        stock.setStockCount(0);

        // Setting stock count to 5 - all observers will be notified
        stock.setStockCount(50);

    }
}