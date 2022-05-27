package ru.netology.javacore;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodosTests {

    @BeforeAll
    public static void initSuite() {
        System.out.println("Running 'TodosTests' for methods of class \"Todos\"");
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("All 'TodosTests' complete! ");
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Starting new test");
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete!");
    }

    @Test
    @DisplayName("Test \"addTask()\" method")
    public void addTaskTest(TestInfo addTaskTestInfo) {

        Todos todo = new Todos();

        todo.addTask("Doing something!");

        boolean actual = todo.getTaskList().contains("Doing something!");

        Assertions.assertTrue(actual, addTaskTestInfo.getDisplayName() + " NO complete!");
        System.out.println(addTaskTestInfo.getDisplayName() + " complete!");
    }

    @Test
    @DisplayName("Test \"removeTask()\" method")
    public void removeTaskTest(TestInfo removeTaskTestInfo) {

        Todos todo = new Todos();

        todo.addTask("Doing something!");
        todo.removeTask("Doing something!");

        boolean actual = todo.getTaskList().contains("Doing something!");

        Assertions.assertFalse(actual, removeTaskTestInfo.getDisplayName() + " NO complete!");
        System.out.println(removeTaskTestInfo.getDisplayName() + " complete!");
    }


    @Test
    @DisplayName("Test \"getAllTask()\" method")
    public void getAllTasksTest(TestInfo getAllTasksTestInfo) {

        Todos todo = new Todos();

        String expected = "First task" +
                " " +
                "Second task" +
                " " +
                "Third task" +
                " ";

        todo.addTask("First task");
        todo.addTask("Second task");
        todo.addTask("Third task");

        Assertions.assertEquals(expected, todo.getTaskList(), getAllTasksTestInfo.getDisplayName() + " NO complete!");
        System.out.println(getAllTasksTestInfo.getDisplayName() + " complete!");
    }

    @Test
    @DisplayName("Test \"getAllTasksAsList()\" method")
    public void getAllTasksAsListTest(TestInfo getAllTasksAsListTestInfo) {
        Todos todo = new Todos();

        todo.addTask("First task");
        todo.addTask("Second task");
        todo.addTask("Third task");

        List<String> expected = new ArrayList<>(Arrays.asList("First task", "Second task", "Third task"));

        List<String> actual = todo.getAllTasksAsList();

        Assertions.assertEquals(expected, actual, getAllTasksAsListTestInfo.getDisplayName() + " NO complete!");
        System.out.println(getAllTasksAsListTestInfo.getDisplayName() + " complete!");
    }


}
