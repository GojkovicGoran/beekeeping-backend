package c.ba.beekeeping.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import c.ba.beekeeping.domain.Task;
import c.ba.beekeeping.services.TaskService;

@RestController
@CrossOrigin
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(value = "/tasks")
    public Task saveNewTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @GetMapping(value = "/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping(value = "/tasks/{date}")
    public List<Task> getAllTasks(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws Exception {

        List<Task> tasks = taskService.getAllTasks(date);
        if (tasks.isEmpty()) {
            throw new Exception("No more tasks");
        }
        return tasks;
    }

    @PostMapping(value = "/tasks/{id}")
    public Task postponeTasks(@PathVariable Integer id) throws Exception {
        return taskService.postponeTasks(id);
    }

    @PutMapping(value = "/tasks/{id}")
    public void completeTask(@PathVariable Integer id) {
        taskService.updateComplete(id);
    }

    @PutMapping(value = "/task/{id}")
    public Task getTask(@PathVariable Integer id) throws Exception {
        return taskService.getTask(id);
    }

    @DeleteMapping(value = "/task/{id}")
    public void deleteTask(@PathVariable Integer id) throws Exception {
        taskService.deleteTask(id);
    }
    @PostMapping(value = "/task/{id}")
    public Task uncompletedTask(@PathVariable Integer id) throws Exception {
        return taskService.uncompletedTask(id);
    }
}