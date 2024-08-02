package LLD.SprintPlanner;

import java.util.UUID;

public class Task {
    private String id;
    private String name;
    private TaskType type;
    private TaskStatus status;
    private User assignedUser;

    public Task(String name, TaskType type, User assignedUser){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.type = type;
        this.status = TaskStatus.TODO;
        this.assignedUser = assignedUser;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public TaskType getType(){
        return type;
    }

    public TaskStatus getStatus(){
        return status;
    }

    public User getAssignedUser(){
        return assignedUser;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", name=" + name + ", type=" + type + ", status=" + status + ", assignedUser=" + assignedUser + "]";
    }
}
