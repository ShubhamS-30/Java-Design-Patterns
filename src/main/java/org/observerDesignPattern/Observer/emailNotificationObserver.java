package org.observerDesignPattern.Observer;

import org.observerDesignPattern.Observable.stockObservable;

/**
 * emailNotificationObserver - Concrete Observer in Observer Pattern
 *
 * Role: One specific observer that reacts to stock changes by sending emails
 *
 * Key Points:
 * 1. Implements NotificationObserver interface
 * 2. Maintains a reference to the observable to query current state
 * 3. When update() is called, it sends an email notification
 * 4. Completely independent of other observers (SMS, Slack, etc.)
 *
 * Advantages of Observer Pattern here:
 * - If you want to add WhatsApp notifications, create WhatsAppObserver
 *   WITHOUT modifying phoneObservableImpl or emailNotificationObserver
 * - Each observer is responsible for its own logic
 */
public class emailNotificationObserver implements NotificationObserver {

    private String email;
    private stockObservable observable;  // Reference to the subject being observed

    /**
     * Constructor subscribes this observer to the observable
     *
     * @param email - Email address to send notifications to
     * @param observable - The product/stock being observed
     */
    public emailNotificationObserver(String email, stockObservable observable) {
        this.email = email;
        this.observable = observable;
    }

    // ...getters and setters...
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

    /**
     * Called by the observable when state changes
     * This observer responds by sending an email
     */
    @Override
    public void update() {
        sendEmail();
    }

    /**
     * Sends an email notification about stock availability
     * The observer queries the observable to get current state details
     */
    public void sendEmail() {
        // Get current stock from observable and send email
        System.out.println("Only " + observable.getStockCount() + " left!! Email sent to : " + email);
    }
}
