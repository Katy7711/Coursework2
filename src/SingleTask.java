import java.time.LocalDate;
import java.time.LocalDateTime;

public class SingleTask extends Task{
    public SingleTask(String nameTask, String taskDescription, LocalDateTime taskDateTime) {
        super(nameTask, taskDescription, taskDateTime);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getTaskDateTime().toLocalDate().equals(date);
    }

    @Override
    public String getTaskRepeatRule() {
        return "одноразовая";
    }
}
