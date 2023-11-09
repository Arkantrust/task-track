package me.arkantrust.repository;

import me.arkantrust.model.Task;
import me.arkantrust.util.HashMap;
import me.arkantrust.view.TaskView;

public class TaskRepository {

    private static TaskRepository instance;

    private static Integer count = 1;

    private final HashMap<Integer, Task> tasks;

    public static TaskRepository getInstance() {

        if (instance == null)
            instance = new TaskRepository();

        return instance;

    }

    private TaskRepository() {

        tasks = new HashMap<>();

    }

    public Task addTask() {

        Task task = new TaskView().build();

        if (task != null) {

            task.setId(count);
            tasks.put(count, task);
            count++;

        }

        return task;

    }

    // This method is an insult to software engineering
    // TODO: Handle error properly
    public boolean removeTask(Integer id) {

        try {

            tasks.remove(id);
            return true;

        } catch (Exception e) {

            return false;

        }

    }

    public Task editTask(Integer id) {

        // TODO: test this method
        Task task = tasks.get(id);

        Task taskDetails = new TaskView().build();

        if (taskDetails != null) {

            task.setTitle(taskDetails.getTitle());
            task.setDetails(taskDetails.getDetails());
            task.setPriority(taskDetails.getPriority());
            task.setDueDate(taskDetails.getDueDate());

        }

        return task;

    }

    public Task getTaskById(Integer id) {

        return tasks.get(id);

    }

    public Task[] getTasks() {

        return tasks.values();

    }

}
