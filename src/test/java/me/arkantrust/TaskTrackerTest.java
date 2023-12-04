package me.arkantrust;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTrackerTest {
    
    @Test
    public void AppLoads() {
    
        assertNotNull(new TaskTracker());
    
    }

}
