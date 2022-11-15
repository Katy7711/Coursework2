import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Task {

    private final String nameTask;
    private final String taskDescription;
    private boolean personalTask;
    private final LocalDateTime taskDateTime;
    private final int id;

    private static int counter = 0;


    public Task(String nameTask, String taskDescription, LocalDateTime taskDateTime) {
        if (nameTask == null || nameTask.isBlank()) {
            throw new IllegalArgumentException("Заполните название задачи");
        }
        this.nameTask = nameTask;
        if (taskDescription == null || taskDescription.isBlank()) {
            throw new IllegalArgumentException("Заполните описание задачи");
        }
        this.taskDescription = taskDescription;
        this.personalTask = personalTask;
        this.taskDateTime = taskDateTime;
        this.id = counter++;
    }

    public abstract boolean appearsIn (LocalDate date);
    public abstract String getTaskRepeatRule();

    public String getNameTask() {
        return nameTask;
    }

    public String getTaskDescription() {
        return taskDescription;
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

    @Override
    public String toString() {
        return "Task{" +
                "nameTask='" + nameTask + '\'' +
                ", task='" + taskDescription + '\'' +
                ", personalTask=" + personalTask +
                ", taskDateTime=" + taskDateTime +
                ", id=" + id +
                '}';
    }
}