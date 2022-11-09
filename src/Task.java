import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Task {

    private final String nameTask;
    private final String task;
    private final boolean personalTask;
    private final LocalDateTime taskDateTime;
    private final int id;

    private static int counter = 0;


    public Task(String nameTask, String task, boolean personalTask, LocalDateTime taskDateTime, int id) {
        if (nameTask == null || nameTask.isBlank()) {
            throw new IllegalArgumentException("Заполните название задачи");
        }
        this.nameTask = nameTask;
            if (task == null || task.isBlank()) {
            throw new IllegalArgumentException("Заполните описание задачи");
        this.task = task;
        this.personalTask = personalTask;
        this.taskDateTime = taskDateTime;
        this.id = counter++;
    }

    public abstract boolean appearsIn (LocalDate date);

    public String getNameTask() {
        return nameTask;
    }

    public String getTask() {
        return task;
    }

    public boolean isPersonalTask() {
        return personalTask;
    }

    public LocalDateTime getTaskDateTime() {
        return taskDateTime;
    }

    public int getId() {
        return id;
    }
}
