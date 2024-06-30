package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tasks {
    private List<String> tasks;
    private List<String> completedTasks;
    private List<Integer> completionOrder;
    private Scanner scanner;

    public Tasks() {
        tasks = new ArrayList<>();
        completedTasks = new ArrayList<>();
        completionOrder = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to add a task
    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    // Method to remove a task
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid index. No task removed.");
        }
    }

    // Method to mark a task as completed
    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String completedTask = tasks.remove(index);
            completedTasks.add(completedTask);
            completionOrder.add(index);
            System.out.println("Task completed: " + completedTask);
        } else {
            System.out.println("Invalid index. No task marked as completed.");
        }
    }

    // Method to display completed tasks
    public void displayCompletedTasks() {
        System.out.println("Completed Tasks:");
        for (String task : completedTasks) {
            System.out.println("- " + task);
        }
        double completedPercentage = ((double) completedTasks.size() / (tasks.size() + completedTasks.size())) * 100;
        System.out.printf("Percentage of Completed Tasks: %.2f%%\n", completedPercentage);
    }

    // Method to display all tasks
    public void displayTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    // Method to display tasks in order of completion
    public void displayTasksInCompletionOrder() {
        System.out.println("Tasks in Order of Completion:");
        for (int index : completionOrder) {
            System.out.println("- " + tasks.get(index));
        }
    }


    // Method to start the task management interface
    public void startTaskManager() {
        boolean exit = false;
        while (!exit) {
            System.out.println(" Select an option: ");
            System.out.println("| --------------------- |");
            System.out.println("| 1. Add Task |");
            System.out.println("| 2. Remove Task |");
            System.out.println("| 3. Mark Task as Completed |");
            System.out.println("| 4. View Completed Tasks |");
            System.out.println("| 5. View Tasks in Order of Completion |");
            System.out.println("| 6. Exit |");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String newTask = scanner.nextLine();
                    addTask(newTask);
                    break;
                case 2:
                    displayTasks(); // Display available tasks
                    System.out.print("Enter index of task to remove: ");
                    int indexToRemove = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character after nextInt()
                    removeTask(indexToRemove - 1); // Adjust index for user input
                    break;
                case 3:
                    displayTasks(); // Display available tasks
                    System.out.print("Enter index of task to mark as completed: ");
                    int indexToComplete = scanner.nextInt();
                    scanner.nextLine();
                    completeTask(indexToComplete - 1);
                    break;
                case 4:
                    displayCompletedTasks();
                    break;
                case 5:
                    displayTasksInCompletionOrder();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting Task Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
        scanner.close();
    }
}
