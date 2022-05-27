package ru.netology.javacore;

import java.util.*;

public class Todos {

    private List<String> taskList;

    public Todos() {
        this.taskList = new ArrayList<>();
    }

    public void addTask(String task) {
        this.taskList.add(task);
    }

    public void removeTask(String task) {
        this.taskList.remove(task);
    }

    public void setTaskList(List<String> taskList) {
        this.taskList = taskList;
    }

    public String getTaskList() {
        Collections.sort(this.taskList);
        StringBuilder sb = new StringBuilder();
        for (String task : this.taskList) {
            sb.append(task);
            sb.append(" ");
        }
        return sb.toString();
    }

    public List<String> getAllTasksAsList() {
        return this.taskList;
    }

    @Override
    public String toString() {
        return "Todos { " +
                " allTasks = " + taskList +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todos)) return false;
        Todos todos = (Todos) o;
        return getTaskList().equals(todos.getTaskList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTaskList());
    }
}
