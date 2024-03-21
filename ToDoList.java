import java.util.LinkedList;
import java.util.Queue;

public class ToDoList {
    private Queue<String> tasks;

    public ToDoList() {
        this.tasks = new LinkedList<>();
    }

    public void addTask(String task) {
        tasks.offer(task);
    }

    public String getFirstTask() {
        return tasks.peek();
    }

    public void removeFirstTask() {
        tasks.poll();
    }

    public void showAllTasks() {
        System.out.println("To-Do List:");
        for (String task : tasks) {
            System.out.println(task);
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.addTask("Jurnal 05 ISD");
        toDoList.addTask("Kuis Sistem Basis Data");
        toDoList.addTask("Tugas Besar");

        System.out.println("First Task: " + toDoList.getFirstTask());
        System.out.println("=== Remove First Task ===");
        toDoList.removeFirstTask();
        System.out.println("First Task after Removal: " + toDoList.getFirstTask());
        System.out.println("=== Show All Tasks ===");
        toDoList.showAllTasks();
    }
}
