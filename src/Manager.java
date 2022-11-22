import TaskNotFoundException.TaskNotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Scanner;

public class Manager {

    public static void main(String[] args) throws TaskNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Schedule schedule = new Schedule();
        boolean isRunning = true;
        int id = 0;
        while (isRunning) {
            printMenu();
            System.out.print("Выберите пункт меню: ");
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        inputTask(scanner);
                        break;
                    case 2:
                        schedule.removeTask(id);
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

    private static LocalDate getDateFromUser(Scanner scanner) {
        LocalDate result = null;
        boolean forceUserToAnswer = true;
        while (forceUserToAnswer) {
            try {
                System.out.println("Введите дату задачи в формате dd.mm.yyyy: ");
                String date = scanner.next();
                result = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                forceUserToAnswer = false;
            } catch (Exception e) {
                System.out.println("Введите еще раз, пожалуйста");
            }
        }
        return result;
    }


    private static void inputTask(java.util.Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.next();
        System.out.print("Введите время задачи в формате HH:mm");
        String time = scanner.next();
        LocalDate taskDate = getDateFromUser(scanner);
        LocalTime taskTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        LocalDateTime resultDate = LocalDateTime.of(taskDate,taskTime);
        System.out.print("персональная? 0 -да, 1-нет");
        int isPersonal = scanner.nextInt();
        int i = parseTaskType(scanner);
        Schedule schedule = new Schedule();
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