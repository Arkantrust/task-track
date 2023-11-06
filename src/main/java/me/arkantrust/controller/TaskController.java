package me.arkantrust.controller;

import me.arkantrust.model.Task;
import me.arkantrust.util.HashMap;
import me.arkantrust.view.CreateTaskBox;
import me.arkantrust.view.TaskView;

public class TaskController {

    private static final HashMap<Integer, Task> tasks = new HashMap<>();

    private static Integer count = 1;

    public static Task addTask() {

        Task task = new CreateTaskBox().build();

        if (task != null) {

            task.setId(count);
            tasks.put(count, task);
            count++;

        }

        return task;

    }

    public static boolean removeTask(Integer id) {

        try {

            tasks.remove(id);
            return true;

        } catch (Exception e) {

            return false;

        }

    }

    public static Task editTask(Integer id) {
        // TODO: test this method
        Task task = tasks.get(id);

        Task taskDetails = new CreateTaskBox().build();

        if (taskDetails != null) {

            task.setTitle(taskDetails.getTitle());
            task.setDetails(taskDetails.getDetails());
            task.setPriority(taskDetails.getPriority());
            task.setDueDate(taskDetails.getDueDate());

        }

        return task;

    }

    public static void viewTask(Integer id) {

        Task task = tasks.get(id);

        new TaskView(task).build();

    }

}
