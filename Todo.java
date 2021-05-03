package Stack;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.lang.Integer;


enum Priority {
    URGENT,
    HIGH,
    NORMAL,
    LOW
}

enum Status {
    NOT_STARTED,
    IN_PROGRESS,
    WAITING,
    DEFERRED
}

class Task implements Comparable<Task> {

    int taskId = 0;
    String subject;
    Priority priority;
    Status status;
    LocalDate startDate;
    LocalDate dueDate;

    public Task(int taskId, String subject, Priority priority, Status status, LocalDate startDate, LocalDate dueDate) {
        this.taskId = taskId;
        this.subject = subject;
        this.priority = priority;
        this.status = status;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }


    public int getTaskId() {
        return taskId;
    }

    @Override
    public String toString() {
        return "Id:" + taskId + "; Subject: " + subject + "; Status: " + status + "; Priority: " + priority + "; StartDate: " + startDate.toString() + "; Due date: " + dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task task) {
        return this.getPriority().compareTo(task.getPriority());        }
}

class ToDoListApplication {


    PriorityQueue<Task> taskPriorityQueue = new PriorityQueue<>();
    Scanner scanner = new Scanner(System.in);
    int taskID = 0;
    public static void main(String[] args) {
        ToDoListApplication app = new ToDoListApplication();
        app.testPriorityQueue();
    }

    public void displayNextTask() {
        if(taskPriorityQueue.isEmpty()) // check if the queue is empty
        {
            System.out.println("No tasks in the queue.");
        }
        else
        {
            // if not display the next task in queue
            System.out.println(taskPriorityQueue.peek());
            taskPriorityQueue.poll(); // remove the next task from queue
        }
    }

    public void showTaskDetail(int taskId) {

        // create an iterator to the start of queue
        Iterator it = taskPriorityQueue.iterator();
        // loop over the queue until the end
        while (((Iterator) it).hasNext()) {
            Task task = (Task) it.next(); // get the next task
            if (task.getTaskId() == taskId) // check if taskId is found, then display the task and exit
            {
                System.out.println(task);
                return;
            }
        }

        System.out.println("TaskId not found..."); //taskId not found

    }
    public Task getTaskById(int taskId)  {

        Iterator it = taskPriorityQueue.iterator();
        while (((Iterator) it).hasNext()) {
            Task task = (Task) it.next();
            if (task.getTaskId() == taskId)
                return task;
            System.out.println("TaskId not found...");
        }
        return null;
    }
    public void removeTask(int taskId) {

        // create an iterator to start of the queue
        Iterator it = taskPriorityQueue.iterator();
        // loop over the queue
        while (((Iterator) it).hasNext())
        {
            Task task = (Task) it.next(); // get the next task
            if (task.getTaskId() == taskId) // check if taskId is found, then remove the task and exit
            {
                it.remove();
                return ;
            }
        }
        System.out.println("TaskId not found..."); // taskId not found

    }

    public void testPriorityQueue() {
        String menuItem;
        System.out.println("Welcome to My Task List\n");
        do {
            System.out.println("Choose action (Add(a), Next(n), List(l), Detail(d),Edit(e), Remove(r), Quit(q):");
            menuItem = scanner.nextLine();
            switch (menuItem) {
                case "a":
                    addTask();
                    break;
                case "n":
                    displayNextTask();
                    break;
                case "l":
                    showTaskSummaryList();
                    break;
                case "d":
                    System.out.println("Enter taskId: ");
                    int taskId = Integer.parseInt(scanner.nextLine());
                    showTaskDetail(taskId);
                    break;
                case "r":
                    System.out.println("Enter taskId: ");
                    taskId = Integer.parseInt(scanner.nextLine());
                    removeTask(taskId);
                    break;
                case "q":
                    break;
            }
        } while (!menuItem.equals("q")); // loop that continues until user quits
        System.out.println("Goodbye");
    }

    void showTaskSummaryList() {
        for (Task task: taskPriorityQueue)
            System.out.println(task);
    }



    private Priority scanForPriority() {
        Priority priority = Priority.NORMAL;
        System.out.println("Enter priority abbreviation Normal=n,Low=l,High=h,Urgent=u): ");String abbrev = scanner.nextLine();
        switch (abbrev) {
            case "n":
                priority = Priority.NORMAL;
                break;
            case "l":
                priority = Priority.LOW;
                break;
            case "h":
                priority = Priority.HIGH;
                break;
            case "u":
                priority = Priority.URGENT;
                break;
        }
        return priority;
    }

    void addTask() {

        System.out.println("Adding new Task...");
        taskID++; // increment taskId by 1
        System.out.println("Enter subject:");
        Scanner scanner = new Scanner(System.in);
        String subject = scanner.nextLine();
        System.out.println("Enter due date (yyyy-MM-dd):");
        String input = scanner.nextLine();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dueDate = LocalDate.parse(input);
        Priority priority = scanForPriority();
        Status status = Status.NOT_STARTED;
        LocalDate date = LocalDate.now();
        LocalDate startDate = LocalDate.now();
        // pass taskID for the task
        Task task = new Task(taskID, subject, priority, status, startDate, dueDate);
        taskPriorityQueue.add(task);
    }
}