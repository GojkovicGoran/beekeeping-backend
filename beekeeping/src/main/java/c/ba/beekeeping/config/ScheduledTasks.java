package c.ba.beekeeping.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import c.ba.beekeeping.domain.Task;
import c.ba.beekeeping.services.TaskService;

@Component
public class ScheduledTasks {

    private TaskService taskService;

    @Autowired
    public ScheduledTasks(TaskService taskService) {
        this.taskService = taskService;
    }

    @Scheduled(cron = "0 55 23 * * ?")
    public void postponeAndDeleteTasks() throws Exception {

        LocalDate date = LocalDate.now();

        for (Task task : taskService.getAllCompletedTasks()) {
            taskService.deleteTask(task.getId());
        }

        for (Task task : taskService.getAllTasks(date)) {
            taskService.postponeTasks(task.getId());
        }

    }

}
