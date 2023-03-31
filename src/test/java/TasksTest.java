import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void matchesInSimpleTask () {
        SimpleTask simpleTask = new SimpleTask(3,"Погулять с собакой");

        String[] subtasks = { "полдник", "обед", "ужин" };
        Epic epic = new Epic(33, subtasks);

        Meeting meeting = new Meeting(
                333,
                "Собеседование сотрудника",
                "Обсуждение должностных обязанностей",
                "в среду после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        boolean actual = simpleTask.matches("Погулять");

        Assertions.assertTrue(actual);
    }

    @Test
    public void matchesInEpic () {
        SimpleTask simpleTask = new SimpleTask(3,"Погулять с собакой");

        String[] subtasks = { "полдник", "обед", "ужин" };
        Epic epic = new Epic(33, subtasks);

        Meeting meeting = new Meeting(
                333,
                "Собеседование сотрудника",
                "Обсуждение должностных обязанностей",
                "в среду после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        boolean actual = epic.matches("обед");

        Assertions.assertTrue(actual);
    }

    @Test
    public void matchesInMeeting () {
        SimpleTask simpleTask = new SimpleTask(3,"Погулять с собакой");

        String[] subtasks = { "полдник", "обед", "ужин" };
        Epic epic = new Epic(33, subtasks);

        Meeting meeting = new Meeting(
                333,
                "Собеседование сотрудника",
                "Обсуждение должностных обязанностей",
                "в среду после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        boolean actual = meeting.matches("сотрудник");

        Assertions.assertTrue(actual);
    }

    @Test
    public void matchesNotFound () {
        SimpleTask simpleTask = new SimpleTask(3,"Погулять с собакой");

        String[] subtasks = { "полдник", "обед", "ужин" };
        Epic epic = new Epic(33, subtasks);

        Meeting meeting = new Meeting(
                333,
                "Собеседование сотрудника",
                "Обсуждение должностных обязанностей",
                "в среду после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        boolean actual = simpleTask.matches("Выгулить");

        Assertions.assertFalse(actual);
    }
}
