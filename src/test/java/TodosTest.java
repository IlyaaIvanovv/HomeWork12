import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQueryInSimpleTask () {
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

        Task[] expected = { simpleTask };
        Task[] actual = todos.search("Погулять");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQueryInEpic () {
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

        Task[] expected = { epic };
        Task[] actual = todos.search("ужин");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQueryInMeeting () {
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

        Task[] expected = { meeting };
        Task[] actual = todos.search("Собеседование");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQueryEmptyField () {
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

        Task[] expected = { };
        Task[] actual = todos.search("Позвонить");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQueryIn2Tasks () {
        SimpleTask simpleTask = new SimpleTask(2,"Обсуждение вечерних новостей");

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

        Task[] expected = { simpleTask, meeting };
        Task[] actual = todos.search("Обсуждение");

        Assertions.assertArrayEquals(expected, actual);
    }
}
