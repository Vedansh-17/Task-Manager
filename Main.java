package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tasks taskManager = new Tasks(); // Create an instance of Tasks

        // Display welcome message or introduction
        System.out.println(" Welcome to Task Manager ");

        // Display menu options
        printMenu();

        boolean exit = false;
        while (!exit) {
            // Ask for user input
            System.out.print("\n*Enter your choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("*Enter task to add: ");
                    String newTask = scanner.nextLine();
                    taskManager.addTask(newTask);
                    break;
                case 2:
                    taskManager.displayTasks(); // Display available tasks
                    System.out.print("*Enter index of task to remove: ");
                    int indexToRemove = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    taskManager.removeTask(indexToRemove - 1); // Adjust index for user input
                    break;
                case 3:
                    taskManager.displayTasks(); // Display available tasks
                    System.out.print("*Enter index of task to mark as completed: ");
                    int indexToComplete = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    taskManager.completeTask(indexToComplete - 1); // Adjust index for user input
                    break;
                case 4:
                    taskManager.displayCompletedTasks();
                    break;
                case 5:
                    taskManager.displayTasksInCompletionOrder();
                    break;
                case 6:
                    exit = true;
                    System.out.println("*Thank you for using Task Manager");
                    break;
                default:
                    System.out.println("*Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        }

        // Close the scanner
        scanner.close();
    }

    // Helper method to print the menu options
    private static void printMenu() {
        System.out.println("________________________________________ ");
        System.out.println("| Select an option:                    |");
        System.out.println("| ==================================== |");
        System.out.println("| 1. Add Task                          |");
        System.out.println("| 2. Remove Task                       |");
        System.out.println("| 3. Mark Task as Completed            |");
        System.out.println("| 4. View Completed Tasks              |");
        System.out.println("| 5. View Tasks in Order of Completion |");
        System.out.println("| 6. Exit                              |");
        System.out.println("'______________________________________'");
    }
}
