package c.ba.beekeeping.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import c.ba.beekeeping.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByCreatedAt(LocalDate date);

    @Modifying
    @Query("UPDATE Task task SET task.completed = 1 WHERE task.id = ?1")
    void updateCompletedById(Integer id);

    List<Task> findAllByOrderByCompletedAscIdDesc();

    @Query(value = "SELECT t FROM Task t WHERE t.completed=true")
    List<Task> findAllByCompleted();
}
