package kx.example.Lab3_Part2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    TaskService taskService;

    public TaskController(){
        this.taskService= new TaskService();
    }

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("tasks",taskService.list());
        return "task_list";
    }
    @GetMapping("/task/new")
    public String newTask(Model model){
        model.addAttribute("task",new Task());
        return "new_task";
    }

    @PostMapping("/task/new")
    public String addTask(@ModelAttribute Task task){
        taskService.add_task(task);
        return "redirect:/";
    }

    @GetMapping("/task/{id}")
    public String details(@PathVariable Long id,Model model){
        model.addAttribute("task",taskService.findById(id));
        return "detail_task";
    }

    @PostMapping("/task/edit/{id}")
    public String edit(@PathVariable Long id,@ModelAttribute Task task){
        taskService.update_task(id,task);
        return "redirect:/";
    }

    @PostMapping("/task/delete/{id}")
    public String delete(@PathVariable Long id){
        taskService.deleteTaskById(id);
        return "redirect:/";
    }
}
