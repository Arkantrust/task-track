package me.arkantrust.view;

import me.arkantrust.util.HashMap;
import me.arkantrust.view.io.IO;
import me.arkantrust.repository.TaskRepository;

/**
 * The MenuIO class is responsible for printing the main menu options for
 * PipeMaster.
 */

public class HomeView extends IO {

    private boolean running;

    public HomeView() {

        running = true;

        HashMap<Integer, Runnable> OPTIONS = new HashMap<>();
        OPTIONS.put(0, this::exit);
        OPTIONS.put(1, this::showTasks);
        OPTIONS.put(2, this::showTask);
        OPTIONS.put(3, this::addTask);
        OPTIONS.put(4, this::editTask);
        OPTIONS.put(5, this::deleteTask);

        printBlue("Welcome to Task Tracker!\n");

        while (running)
            OPTIONS.get(printMenu()).run();

    }

    private Integer printMenu() {

        printInstruction("  1. Show tasks\n");
        printInstruction("  2. Show task\n");
        printInstruction("  3. Add task\n");
        printInstruction("  4. Edit task\n");
        printInstruction("  5. Delete task\n");
        printInstruction("  0. Delete task\n");
        printInstruction("$ ");

        return readMenuItem();

    }

    private void showTasks() {

        var tasks = TaskRepository.getInstance().getTasks();

        if (tasks.length == 0)
            System.out.println("It seems quite empty here...");
        else {

            System.out.println("Tasks found:");

            for (var task : tasks)
                System.out.println(task);

        }

    }

    private void showTask() {
    }

    private void addTask() {
    }

    private void editTask() {
    }

    private void deleteTask() {
    }

    private void exit() {

        running = false;
        System.out.println("Goodbye!");
        System.exit(0);

    }

}
