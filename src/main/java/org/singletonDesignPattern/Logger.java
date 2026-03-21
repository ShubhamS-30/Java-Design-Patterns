package org.singletonDesignPattern;

/**
 * SINGLETON DESIGN PATTERN
 * 
 * Purpose: Ensure that a class has only one instance and provide a global point of access to it.
 * 
 * Key Characteristics:
 * - Private constructor: Prevents instantiation from outside the class
 * - Static instance: Holds the single instance of the class
 * - Thread-safe getInstance(): Ensures only one instance even in multi-threaded environments
 * - Double-checked locking: Optimizes performance by minimizing synchronization overhead
 * 
 * Real-world use cases: Logger, Database Connection, Configuration Manager, Connection Pool
 */
public class Logger {
    
    // 'volatile' keyword ensures visibility of changes across threads
    // This is crucial for thread-safe implementation
    // Without volatile, threads might cache the instance value and not see updates
    public static volatile Logger instance;
    
    // Counter to track how many times the Logger instance was created
    // This demonstrates the singleton pattern - should only increment once
    private static Integer count = 0;
    
    /**
     * PRIVATE CONSTRUCTOR
     * 
     * This is the key to preventing multiple instantiations.
     * By making the constructor private, we prevent any code outside this class 
     * from creating new instances using the 'new' keyword.
     * 
     * If someone tries to do: Logger logger = new Logger(); 
     * -> Compilation error: The constructor Logger() is not visible
     */
    private Logger() {
        // Private constructor to prevent direct instantiation from outside
    }

    /**
     * GET INSTANCE METHOD (Thread-Safe)
     * 
     * This method implements the "Double-Checked Locking" pattern:
     * 
     * Step 1: First check (without lock) - if instance already exists, return it immediately
     *         This avoids expensive synchronization for subsequent calls
     * 
     * Step 2: If null, acquire lock on Logger.class
     *         Only one thread can enter this synchronized block at a time
     * 
     * Step 3: Second check (with lock) - verify instance is still null
     *         This prevents race conditions where multiple threads enter the first if block
     *         but only one should create the instance
     * 
     * Step 4: Create instance and increment count
     *         Now we have guaranteed exactly one instance
     * 
     * @return The single instance of Logger
     */
    public static Logger getInstance() {
        // First check: Avoid synchronization if instance already exists
        if (instance == null) {
            // Synchronize: Ensure only one thread can execute this block
            synchronized (Logger.class) {
                // Second check: Verify instance is still null inside the lock
                // (another thread might have created it between first check and acquiring lock)
                if (instance == null) {
                    // Create the single instance
                    instance = new Logger();
                    // Increment count to show instance was created
                    count++;
                }
            }
        }
        return instance;
    }

    /**
     * LOG MESSAGE METHOD
     * 
     * This is a simple logging method that all loggers will use.
     * Since there's only one Logger instance, all threads will use the same log method.
     * 
     * @param message The message to log
     */
    public void log(String message) {
        System.out.println(String.format("Log: %s", message));
    }

    /**
     * GET CREATION COUNT
     * 
     * Returns how many times the Logger instance was actually created.
     * In a properly implemented singleton, this should always be 1
     * regardless of how many times getInstance() was called.
     * 
     * @return The number of Logger instances created (should be 1)
     */
    public static Integer getCount() {
        return count;
    }
}
