package LLD.SprintPlanner;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class SprintPlanner {
    private Map<String, Sprint> sprints;
    private Map<String, Task> tasks;

    public SprintPlanner(){
        this.sprints = new HashMap<>();
        this.tasks = new HashMap<>();
    }

    public void createSprint(String name){
        if (sprints.containsKey(name)) {
            throw new IllegalArgumentException("Sprint with this name already exists");
        }
        sprints.put(name, new Sprint(name));
    }

    public void addTasksToSprint(String sprintName, Task task){
        if (!sprints.containsKey(sprintName)) {
            throw new IllegalArgumentException("Sprint does not exist");
        }
        Sprint sprint = sprints.get(sprintName);
        if (task.getStatus() == TaskStatus.INPROGRESS && getInProgressTaskCount(sprint) >= 2){
            throw new IllegalArgumentException("Sprint can have max 2 tasks in INPROGRESS status");
        }
        sprint.addTask(task);
        tasks.put(task.getId(), task);
    }

    private int getInProgressTaskCount(Sprint sprint){
        int count = 0;
        for (Task task: sprint.getTasks()){
            if (task.getStatus() == TaskStatus.INPROGRESS){
                count++;
            }
        }
        return count;
    }

    public void removeTaskFromSprint(String sprintName, String taskId){
        if (!sprints.containsKey(sprintName)) {
            throw new IllegalArgumentException("Sprint does not exist");
        }
        Sprint sprint = sprints.get(sprintName);
        sprint.removeTask(taskId);
        tasks.remove(taskId);
    }

    public void changeTaskStatus(String taskId, TaskStatus newStatus){
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task does not exist");
        }
        Task task = tasks.get(taskId);
        task.setStatus(newStatus);
    }

    public List<Task> getTasksByUserInSprint(String sprintName, String userId){
        if (!sprints.containsKey(sprintName)) {
            throw new IllegalArgumentException("Sprint does not exist");
        }
        Sprint sprint = sprints.get(sprintName);
        return sprint.getTaskByUser(userId);
    }

    @Override
    public String toString(){
        return "SprintPlanner [sprints=" + sprints + ", tasks=" + tasks + "]";
    }
}
