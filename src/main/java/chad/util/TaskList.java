package chad.util;

import java.util.ArrayList;

import chad.exception.DeleteException;
import chad.exception.MarkException;
import chad.exception.UnmarkException;
import chad.task.Task;

/**
 * Represent a list consisting of Task objects.
 */
public class TaskList {
    private ArrayList<Task> list;
    private TaskComparator taskComparator;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        this.list = new ArrayList<>();
        this.taskComparator = new TaskComparator();
    }

    /**
     * Constructs a TaskList with a given ArrayList.
     *
     * @param list The initial list of Task to be stored in the TaskList.
     */
    public TaskList(ArrayList<Task> list) {
        assert list != null : "ArrayList cannot be null";

        this.list = list;
    }

    /**
     * Returns a string representation of the TaskList with individual Task.
     *
     * @return The string representation of the list of Task in the TaskList.
     */
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < list.size(); i++) {
            String index = (i + 1) + ".";
            String taskString = list.get(i).toString() + "\n";

            output += index + taskString;
        }
        return output;
    }

    /**
     * Adds a given Task into the TaskList.
     *
     * @param task The given Task to be added into the TaskList
     */
    public void add(Task task) {
        assert task != null : "Task cannot be null";

        this.list.add(task);
        this.list.sort(taskComparator);
    }

    /**
     * Removes a Task of the given index and returns the removed Task.
     * If given index is out of bound, returns null.
     *
     * @param index The index of Task to be removed.
     * @return The Task object that has been removed from the TaskList.
     */
    public Task remove(int index) throws DeleteException {
        if (index < 0 || index >= list.size()) {
            throw new DeleteException();
        }

        return this.list.remove(index);
    }

    /**
     * Updates the status of the Task of given index to completed and
     * returns the Task. If given index is out of bound, returns null.
     *
     * @param index The index of the Task to be marked complete.
     * @return The Task object that has been marked complete.
     */
    public Task mark(int index) throws MarkException {
        if (index < 0 || index >= list.size()) {
            throw new MarkException();
        }

        this.list.get(index).markAsDone();
        return this.list.get(index);
    }

    /**
     * Updates the status of the Task of given index to uncompleted and
     * returns the Task. If given index is out of bound, returns null.
     *
     * @param index The index of the Task to be marked incomplete.
     * @return The Task object that has been marked incomplete.
     */
    public Task unmark(int index) throws UnmarkException {
        if (index < 0 || index >= list.size()) {
            throw new UnmarkException();
        }

        this.list.get(index).markAsNotDone();
        return this.list.get(index);
    }

    /**
     * Returns the number of Task in the TaskList.
     *
     * @return The number of Task in the TaskList.
     */
    public int size() {
        return this.list.size();
    }

    /**
     * Returns Task at the given index.
     *
     * @param index The given index of the Task.
     * @return Task object at the given index.
     */
    public Task get(int index) {
        return this.list.get(index);
    }

    /**
     * Returns a list of Task with matching description as the given string.
     *
     * @param string The given String to be searched on the TaskList.
     * @return TaskList with Task of matching descriptions.
     */
    public TaskList find(String string) {
        assert string != null : "String cannot be null";

        ArrayList<Task> filteredList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Task task = list.get(i);
            if (task.toString().contains(string)) {
                filteredList.add(task);
            }
        }
        return new TaskList(filteredList);
    }
}
