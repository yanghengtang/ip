package chad.command;

import chad.exception.SaveException;
import chad.exception.UnmarkException;
import chad.task.Task;
import chad.util.Storage;
import chad.util.TaskList;
import chad.util.Ui;

/**
 * Represents an unmark command to be executed.
 */
public class UnmarkCommand extends Command {
    private int index;

    /**
     * Constructor for UnmarkCommand class.
     *
     * @param index The TaskList index of the Task to be unmarked.
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the list of commands to unmark a Task from a TaskList.
     *
     * @param taskList The given TaskList with the Task to be unmarked.
     * @param ui The given Ui to show the status of the unmarking of the task.
     * @param storage The given Storage that saves the TaskList locally.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws UnmarkException {
        Task task = taskList.unmark(this.index);
        ui.addUnmarkMessage();
        ui.addTaskMessage(task);
        ui.addTaskListSizeMessage(taskList);
        try {
            storage.save(taskList);
        } catch (SaveException e) {
            ui.addErrorMessage(e);
        }
    }
}
