import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        SingleTask task1 = new SingleTask("задание1", "задание1", LocalDateTime.of(2022, 11, 7, 11, 20));
        SingleTask task2 = new SingleTask("задание2", "задание2", LocalDateTime.of(2022, 11, 8, 11, 20));
        DailyTask task3 = new DailyTask("задание3", "задание3", LocalDateTime.of(2022, 11, 7, 12, 20));
        DailyTask task4 = new DailyTask("задание4", "задание4", LocalDateTime.of(2022, 11, 7, 14, 20));
        Schedule schedule = new Schedule();
        schedule.addTask(task1);
        schedule.addTask(task2);
        schedule.addTask(task3);
        schedule.addTask(task4);
        LocalDate tasksForDay = LocalDate.of(2020, 11, 11);
        printTasksForDay(tasksForDay,schedule.getTaskForDay(tasksForDay));
        printTaskForDelete(schedule.getAllTasks());
    }

    public static void printTaskForDelete (Collection<Task> tasks){
        for (Task task: tasks) {
            System.out.printf("%d. %s %s%n", task.getId(), task.getNameTask(), task.getTaskRepeatRule());
        }

    }

    private static void printTasksForDay(LocalDate day, Collection<Task> tasks) {
        String dateString = day.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        if (tasks.size() == 0) {
            System.out.println("на " + dateString + " задач нет");
        } else {
            System.out.println("задачи на " + dateString);
            for (Task task : tasks) {
                System.out.printf("%s %s Описание: %s%n", task.getNameTask(), task.getTaskDateTime().toLocalTime(),task.getTaskDescription());

            }
        }
    }
}
