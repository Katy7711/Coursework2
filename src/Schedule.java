import TaskNotFoundException.TaskNotFoundException;

import java.time.LocalDate;
import java.util.*;

public class Schedule {
    private final Map<Integer, Task> taskMap = new HashMap<>();

    public void addTask(Task task){
        taskMap.put(task.getId(), task);
    }
    public void removeTask (int id) throws TaskNotFoundException {
        if (!taskMap.containsKey(id)) {
            throw new TaskNotFoundException("Задач с таким id не найдено");
        }
        taskMap.remove(id);
    }

    public Collection<Task> getTaskForDay(LocalDate localDate) {
        Set<Task> tasksForDay = new TreeSet<>(new TaskTimeComparator());
        for (Task task : taskMap.values()) {
            if (task.appearsIn(localDate)) {
                tasksForDay.add(task);
            }
        }
        return tasksForDay;
    }

    public Collection<Task> getAllTasks(){
        return taskMap.values();
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "taskMap=" + taskMap +
                '}';
    }
}