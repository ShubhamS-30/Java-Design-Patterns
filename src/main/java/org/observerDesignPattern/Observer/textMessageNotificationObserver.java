package org.observerDesignPattern.Observer;

import org.observerDesignPattern.Observable.stockObservable;

/**
 * textMessageNotificationObserver - Concrete Observer in Observer Pattern
 *
 * Role: Another specific observer that reacts to stock changes by sending SMS
 *
 * Key Points:
 * 1. Implements NotificationObserver interface (same as emailNotificationObserver)
 * 2. Maintains a reference to the observable to query current state
 * 3. When update() is called, it sends a text message notification
 * 4. Works independently alongside other observers
 *
 * Observer Pattern Benefit:
 * - Email observer sends emails, SMS observer sends texts
 * - Both triggered by same event (stock change)
 * - Neither aware of each other's existence
 * - Easy to add more observers (Slack, WhatsApp, Discord, etc.)
 */
public class textMessageNotificationObserver implements NotificationObserver {

    private Long phoneNo;
    private stockObservable observable;  // Reference to the subject being observed

    /**
     * Constructor subscribes this observer to the observable
     *
     * @param phoneNo - Phone number to send notifications to
     * @param observable - The product/stock being observed
     */
    public textMessageNotificationObserver(Long phoneNo, stockObservable observable) {
        this.phoneNo = phoneNo;
        this.observable = observable;
    }

    /**
     * Called by the observable when state changes
     * This observer responds by sending an SMS/text message
     */
    @Override
    public void update() {
        sendMessage();
    }

    /**
     * Sends a text message notification about stock availability
     * The observer queries the observable to get current state details
     */
    public void sendMessage() {
        // Get current stock from observable and send text message
        System.out.println("Only " + observable.getStockCount() + " left!! Message sent to Phone no : " + phoneNo);
    }

    // Getters and Setters
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
