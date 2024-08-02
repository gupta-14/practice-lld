package LLD.SprintPlanner;

import java.util.ArrayList;
import java.util.List;

public class Sprint {
    private String name;
    private List<Task> tasks;

    public Sprint(String name){
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public List<Task> getTasks(){
        return tasks;
    }

    public void addTask(Task task){
        if (tasks.size() >= 20){
            throw new IllegalArgumentException("Sprint can have max 20 tasks");
        }
        tasks.add(task);
    }

    public void removeTask(String taskId){
        for(int i=0; i< tasks.size(); i++){
            if (tasks.get(i).getId().equals(taskId)){
                tasks.remove(i);
                break;
            }
        }
    }

    public List<Task> getTaskByUser(String userId){
        List<Task> userTasks = new ArrayList<>();
        for (Task task : tasks){
            if (task.getAssignedUser().getId().equals(userId)){
                userTasks.add(task);
            }
        }
        return userTasks;
    }

    @Override
    public String toString(){
        return "Sprint [name=" + name + "tasks=" + tasks + "]";
    }
}
