package c.ba.beekeeping.services;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c.ba.beekeeping.domain.Task;
import c.ba.beekeeping.repositories.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAllByOrderByCompletedAscIdDesc();
    }

    public Task postponeTasks(Integer taskId) throws Exception {

        Task task = taskRepository.findOne(taskId);

        if (task == null) {
            throw new Exception("No task with that ID");
        }

        taskRepository.delete(taskId);

        task.setId(null);
        task.setCreatedAt(LocalDate.now().plusDays(1));

        return taskRepository.save(task);
    }

    public Task getTask(Integer taskId) throws Exception {

        Task task = taskRepository.findOne(taskId);

        if (task == null) {
            throw new Exception("No task with that ID");
        }
        return task;
    }

    public List<Task> getAllTasks(LocalDate date) {
        return taskRepository.findByCreatedAt(date);
    }

    @Transactional
    public void updateComplete(Integer id) {
        taskRepository.updateCompletedById(id);
    }

    public List<Task> getAllCompletedTasks() {
        return taskRepository.findAllByCompleted();
    }

    public void deleteTask(Integer taskId) {
        taskRepository.delete(taskId);
    }

    public Task uncompletedTask(Integer taskId) throws Exception {

        Task task = taskRepository.findOne(taskId);

        if (task == null) {
            throw new Exception("No task with that ID");
        }
        taskRepository.delete(taskId);

        task.setId(null);
        task.setCompleted(false);
        saveTask(task);
        return saveTask(task);
    }
}
