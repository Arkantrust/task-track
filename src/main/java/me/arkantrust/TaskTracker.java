package me.arkantrust;

import me.arkantrust.view.HomeView;

/**
 * The <code>TaskTracker</code> class is the entry point for the TaskTracker
 * program.
 * 
 * @see HomeController
 * 
 */
public class TaskTracker {

    /**
     * 
     * Runs the TaskTracker program. Controlled by the <code>MainController</code>
     * class.
     * 
     * @see HomeController
     * 
     */
    public static void main(String[] args) {

        new HomeView();

    }

}
