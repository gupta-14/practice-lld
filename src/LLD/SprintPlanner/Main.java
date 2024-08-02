package LLD.SprintPlanner;

import java.sql.SQLOutput;

public class Main {
    public static void main(String args[]){
        SprintPlanner sprintPlanner = new SprintPlanner();

        //create a Sprint
        sprintPlanner.createSprint("Sprint 1");

        //create users
        User user1 = new User("Shubham");
        User user2 = new User("Shrishti");

        //create tasks
        Task task1 = new Task("Task 1", TaskType.FEATURE, user1);
        Task task2 = new Task("Task 1", TaskType.BUG, user2);

        //add tasks to sprint
        sprintPlanner.addTasksToSprint("Sprint 1", task1);
        sprintPlanner.addTasksToSprint("Sprint 1", task2);

        //change Task Status
        sprintPlanner.changeTaskStatus(task1.getId(), TaskStatus.INPROGRESS);

        //show tasks by user in sprint
        System.out.println(sprintPlanner.getTasksByUserInSprint("Sprint 1", user1.getId()));

        //print Sprint details
        System.out.println(sprintPlanner);
    }
}

/*

handling multithreading

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SprintPlannerTest {

    public static void main(String[] args) {
        SprintPlanner planner = new SprintPlanner();

        // Create a Sprint
        planner.createSprint("Sprint 1");

        // Create Users
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        // Create Tasks
        Task task1 = new Task("Task 1", TaskType.FEATURE, user1);
        Task task2 = new Task("Task 2", TaskType.BUG, user2);

        // Add Tasks to Sprint
        planner.addTaskToSprint("Sprint 1", task1);
        planner.addTaskToSprint("Sprint 1", task2);

        // Create a thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Submit tasks to executor
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                // Concurrently add and remove tasks
                Task task = new Task("Task " + Thread.currentThread().getId(), TaskType.STORY, user1);
                planner.addTaskToSprint("Sprint 1", task);
                planner.removeTaskFromSprint("Sprint 1", task.getId());

                // Concurrently change task status
                planner.changeTaskStatus(task1.getId(), TaskStatus.INPROGRESS);
                planner.changeTaskStatus(task2.getId(), TaskStatus.DONE);

                // Concurrently get tasks by user
                List<Task> userTasks = planner.getTasksByUserInSprint("Sprint 1", user1.getId());
                System.out.println(userTasks);

                // Print Sprint Details
                System.out.println(planner);
            });
        }

        // Shutdown executor and wait for tasks to complete
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}

 */