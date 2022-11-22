import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task{
    public WeeklyTask(String nameTask, String taskDescription, LocalDateTime taskDateTime) {
        super(nameTask, taskDescription, taskDateTime);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        LocalDate createdDate = getTaskDateTime().toLocalDate();
        return createdDate.equals(date) ||
                (createdDate.isBefore(date));
    }

    @Override
    public String getTaskRepeatRule() {
        return "еженедельная";
    }
}
