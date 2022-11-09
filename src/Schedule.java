import java.time.LocalDate;
import java.util.*;

public class Schedule {
    Map<Integer, Task> taskMap = new HashMap<>();

    public Collection<Task> getTaskForDay(LocalDate localDate) {
        Set<Task> tasksForDay = new TreeSet<>(new TaskTimeComparator());
        for (Task task : taskMap.values()) {
            if (task.appearsIn(LocalDate)) {
                tasksForDay.add(task);
            }
        }
        return tasksForDay;
    }
}
