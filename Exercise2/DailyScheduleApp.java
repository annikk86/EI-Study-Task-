import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DailyScheduleApp implements TaskObserver {
    private static Scanner inputScanner = new Scanner(System.in);
    private static final Logger appLogger = Logger.getLogger(DailyScheduleApp.class.getName());

    public static void main(String[] args) {
        DailyScheduleApp scheduleApp = new DailyScheduleApp();
        ScheduleManager taskManager = ScheduleManager.getInstance();
        taskManager.addObserver(scheduleApp);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nWhat you want to do?");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Edit Task");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. View All Tasks");
            System.out.println("6. View Tasks by Priority");
            System.out.println("7. Exit");

            int userChoice = -1;
            try {
                userChoice = Integer.parseInt(inputScanner.nextLine());
            } catch (NumberFormatException e) {
                appLogger.log(Level.WARNING, "Invalid input format for user choice", e);
                System.out.println("Invalid input. Please enter a valid number.");
            }

            switch (userChoice) {
                case 1:
                    addNewTask(taskManager);
                    break;
                case 2:
                    deleteTask(taskManager);
                    break;
                case 3:
                    updateTask(taskManager);
                    break;
                case 4:
                    completeTask(taskManager);
                    break;
                case 5:
                    displayTasks(taskManager);
                    break;
                case 6:
                    displayTasksByPriority(taskManager);
                    break;
                case 7:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addNewTask(ScheduleManager taskManager) {
        System.out.println("Enter task description:");
        String taskDescription = inputScanner.nextLine();
        System.out.println("Enter task start time (HH:mm):");
        String taskStartTime = inputScanner.nextLine();
        System.out.println("Enter task end time (HH:mm):");
        String taskEndTime = inputScanner.nextLine();
        System.out.println("Enter task priority (Low, Medium, High):");
        String taskPriority = inputScanner.nextLine();

        taskManager.addTask(taskDescription, taskStartTime, taskEndTime, taskPriority);
    }

    private static void deleteTask(ScheduleManager taskManager) {
        System.out.println("Enter task description to remove:");
        String taskDescription = inputScanner.nextLine();
        taskManager.removeTask(taskDescription);
    }

    private static void updateTask(ScheduleManager taskManager) {
        System.out.println("Enter task description to edit:");
        String taskDescription = inputScanner.nextLine();
        System.out.println("Enter new start time (HH:mm):");
        String newStartTime = inputScanner.nextLine();
        System.out.println("Enter new end time (HH:mm):");
        String newEndTime = inputScanner.nextLine();
        System.out.println("Enter new priority (Low, Medium, High):");
        String newPriority = inputScanner.nextLine();

        taskManager.editTask(taskDescription, newStartTime, newEndTime, newPriority);
    }

    private static void completeTask(ScheduleManager taskManager) {
        System.out.println("Enter task description to mark as completed:");
        String taskDescription = inputScanner.nextLine();
        taskManager.markTaskAsCompleted(taskDescription);
    }

    private static void displayTasks(ScheduleManager taskManager) {
        taskManager.viewTasks();
    }

    private static void displayTasksByPriority(ScheduleManager taskManager) {
        System.out.println("Enter priority to view (Low, Medium, High):");
        String priority = inputScanner.nextLine();
        taskManager.viewTasksByPriority(priority);
    }

    @Override
    public void onTaskConflict(Task task) {
        System.out.println("Error: Task conflicts with existing task " + task.getDescription());
    }

    @Override
    public void onTaskAdded(Task task) {
        System.out.println("Task added successfully: " + task.getDescription());
    }

    @Override
    public void onTaskRemoved(Task task) {
        System.out.println("Task removed successfully: " + task.getDescription());
    }
}
