import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    public MonthlyTask(String nameTask, String taskDescription, LocalDateTime taskDateTime) {
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
        return "ежемесячная";
    }
}
