import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Scanner;

public class Manager {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            printMenu();
            System.out.print("Выберите пункт меню: ");
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        inputTask(scanner);
                        break;
                    schedule.addTask();
                    case 2:
                        schedule.removeTask();
                        // todo: обрабатываем пункт меню 2
                        break;
                    case 3:
                        Collection<Task> taskForDay = schedule.getTaskForDay(LocalDate.now().plusDays(2));
                        System.out.println(taskForDay);
                        break;
                    case 0:
                        isRunning = false;
                        break;
                }
            } else {
                scanner.next();
                System.out.println("Выберите пункт меню из списка!");
            }
        }
        System.out.println("Программа заверщена");
    }

    private static void inputTask(java.util.Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.next();
        System.out.print("персональная? 0 -да, 1-нет");
        int isPersonal = scanner.nextInt();
        int i = parseTaskType(scanner);
        switch (i) {
            case 1:
                DailyTask dailyTask = new DailyTask(taskName, taskDescription, LocalDateTime.now());
                schedule.addTask(dailyTask);
                break;
            case 2:
                SingleTask singleTask = new SingleTask(taskName, taskDescription, LocalDateTime.now());
                schedule.addTask(singleTask);
                break;
            case 3:
                WeeklyTask weeklyTask = new WeeklyTask(taskName, taskDescription, LocalDateTime.now());
                schedule.addTask(weeklyTask);
                break;
            case 4:
                MonthlyTask monthlyTask = new MonthlyTask(taskName, taskDescription, LocalDateTime.now());
                schedule.addTask(monthlyTask);
                break;
            case 5:
                YearlyTask yearlyTask = new YearlyTask(taskName, taskDescription, LocalDateTime.now());
                schedule.addTask(yearlyTask);
                break;
            default:
                new IllegalArgumentException("Неверно указан тип задачи");

        }
    }

    private static int parseTaskType(Scanner scanner) {
        System.out.print("Введите тип задачи: 1 -ежедневная, 2 - одноразовая, 3 - еженедельная, 4 - ежемесячная, 5 - ежегодная");
        int taskType = 0;
        boolean isCorrected = false;
        while (!isCorrected) {
            taskType = scanner.nextInt();
            if (taskType >= 6) {
                System.out.print("Неверноуказан тип задачи. Повторите ввод.");
            }
            isCorrected = true;
        }
        return taskType;
    }

    private static void printMenu() {
        System.out.println("1. Добавить задачу");
        System.out.println("2. Удалить задачу");
        System.out.println("3. Получить задачу на указанный день");
        System.out.println("0. Выход");
    }
}