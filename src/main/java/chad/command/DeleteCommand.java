package chad.command;

import chad.exception.DeleteException;
import chad.exception.SaveException;
import chad.task.Task;
import chad.util.Storage;
import chad.util.TaskList;
import chad.util.Ui;

/**
 * Represents a Delete command to be executed.
 */
public class DeleteCommand extends Command {
    private int index;

    /**
     * Constructor for DeleteCommand class.
     *
     * @param index The TaskList index of the Task to be deleted.
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the list of commands to delete a Task from a TaskList.
     *
     * @param taskList The given TaskList with the Task to be deleted.
     * @param ui The given Ui to show the status of the deletion command.
     * @param storage The given Storage that saves the TaskList locally.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DeleteException {
        Task task = taskList.remove(this.index);
        ui.addDeleteMessage();
        ui.addTaskMessage(task);
        ui.addTaskListSizeMessage(taskList);
        try {
            storage.save(taskList);
        } catch (SaveException e) {
            ui.addErrorMessage(e);
        }
    }
}
