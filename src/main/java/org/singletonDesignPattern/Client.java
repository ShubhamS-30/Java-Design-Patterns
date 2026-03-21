package org.singletonDesignPattern;

/**
 * CLIENT CLASS - SINGLETON DESIGN PATTERN DEMONSTRATION
 * 
 * This class demonstrates the Singleton design pattern with multithreading.
 * It shows that:
 * 1. Multiple threads accessing getInstance() receive the SAME instance
 * 2. The singleton instance is created only ONCE, even with concurrent access
 * 3. All threads can safely use the shared singleton instance
 */
public class Client {

    public static void main(String[] args) {
        
        System.out.println("===== SINGLETON DESIGN PATTERN WITH MULTITHREADING =====\n");
        
        // SCENARIO 1: Single-threaded access
        System.out.println("--- SCENARIO 1: Single-Threaded Access ---");
        demonstrateSingleThreaded();
        
        System.out.println("\n--- SCENARIO 2: Multi-Threaded Access ---");
        // SCENARIO 2: Multi-threaded access to demonstrate thread safety
        demonstrateMultiThreaded(5);
        
        System.out.println("\n--- FINAL RESULT ---");
        // Print final instance count
        System.out.println("Total Logger instances created: " + Logger.getCount());
    }
    
    /**
     * DEMONSTRATE SINGLE-THREADED ACCESS
     * 
     * Shows that even in single-threaded scenario, 
     * multiple calls to getInstance() return the same object instance.
     */
    private static void demonstrateSingleThreaded() {
        // Get first instance
        Logger logger1 = Logger.getInstance();
        logger1.log("This is a log message from logger1 (Thread: " + Thread.currentThread().getName() + ")");
        
        // Get second instance
        Logger logger2 = Logger.getInstance();
        logger2.log("This is a log message from logger2 (Thread: " + Thread.currentThread().getName() + ")");
        
        // Verify they are the SAME instance
        System.out.println("Are logger1 and logger2 the same instance? " + (logger1 == logger2));
        System.out.println("logger1 HashCode: " + logger1.hashCode());
        System.out.println("logger2 HashCode: " + logger2.hashCode());
        System.out.println("Instances created so far: " + Logger.getCount());
    }
    
    /**
     * DEMONSTRATE MULTI-THREADED ACCESS
     * 
     * This is the critical test for the Singleton pattern!
     * Multiple threads will attempt to get the Logger instance simultaneously.
     * 
     * Expected behavior:
     * - All threads should receive the SAME instance (same hashCode)
     * - The instance should only be created ONCE (count = 1)
     * 
     * This proves that the double-checked locking in Logger.getInstance() 
     * properly handles concurrent access.
     * 
     * @param numThreads The number of concurrent threads to create
     */
    private static void demonstrateMultiThreaded(int numThreads) {
        
        // Array to hold references to logger instances from different threads
        Logger[] loggerInstances = new Logger[numThreads];
        
        // Array to hold thread references
        Thread[] threads = new Thread[numThreads];
        
        System.out.println("Creating " + numThreads + " threads to access the singleton...\n");
        
        // Create and start multiple threads
        for (int i = 0; i < numThreads; i++) {
            final int threadId = i;
            
            // Each thread will:
            // 1. Get the Logger instance
            // 2. Store it in the array
            // 3. Log a message
            // 4. Print its hashCode
            threads[i] = new Thread(() -> {
                // Get Logger instance from this thread
                Logger logger = Logger.getInstance();
                loggerInstances[threadId] = logger;
                
                // Log a message using the singleton instance
                logger.log("Message from Thread-" + threadId + " (Thread: " 
                    + Thread.currentThread().getName() + ")");
                
                // Print the instance's hashCode for verification
                System.out.println("  Thread-" + threadId + " got Logger with hashCode: " 
                    + logger.hashCode());
            });
            
            // Give each thread a meaningful name
            threads[i].setName("LoggerAccessor-" + i);
        }
        
        // Start all threads simultaneously
        System.out.println("Starting all threads...\n");
        for (Thread thread : threads) {
            thread.start();
        }
        
        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("\nAll threads completed!");
        
        // VERIFICATION: Check if all threads got the same instance
        System.out.println("\n--- VERIFICATION ---");
        System.out.println("Checking if all threads received the SAME Logger instance...\n");
        
        boolean allSameInstance = true;
        Logger firstInstance = loggerInstances[0];
        
        for (int i = 0; i < numThreads; i++) {
            boolean isSame = loggerInstances[i] == firstInstance;
            if (!isSame) {
                allSameInstance = false;
            }
            System.out.println("Thread-" + i + " got same instance? " + isSame);
        }
        
        System.out.println("\nAll " + numThreads + " threads got the SAME instance? " + allSameInstance);
        System.out.println("Instances created: " + Logger.getCount());
    }
}

