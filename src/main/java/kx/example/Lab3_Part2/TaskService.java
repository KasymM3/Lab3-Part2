package kx.example.Lab3_Part2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaskService {

    private Map<Long,Task> tasks = new LinkedHashMap<>();

    private Long num = 0L;

    public List<Task> list(){
        return new ArrayList<>(tasks.values());
    }

    public void add_task(Task task){
        task.setId(num);
        tasks.put(num++,task);
    }

    public void deleteTaskById(Long id){
        tasks.remove(id);
    }

    public void update_task(Long id, Task task){
        task.setId(id);
        tasks.put(id,task);

    }

    public Task findById(Long id){
        return tasks.get(id);
    }
    public TaskService() {
        add_task(new Task(null,"Complete Task 7 from Spring Boot till the end of lesson",
                "I must complete task 7 by using Spring Boot & Thymeleaf.", "23.10.2020", true));
        add_task(new Task(null,"Clear home and buy foods","", "25.10.2020", true));
        add_task(new Task(null,"Complete all home tasks at the weekend","", "28.10.2020", false));
    }

}
