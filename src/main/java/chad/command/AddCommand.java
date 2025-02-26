package chad.command;

import chad.exception.SaveException;
import chad.task.Task;
import chad.util.Storage;
import chad.util.TaskList;
import chad.util.Ui;

/**
 * Represents an Add Command to be executed.
 */
public class AddCommand extends Command {
    private Task task;

    /**
     * Constructor for AddCommand class.
     *
     * @param task The given Task to be added to a TaskList.
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Executes the list of commands to add a Task from a TaskList.
     *
     * @param taskList The given TaskList with the Task to be added.
     * @param ui The given Ui to show the status of the adding command.
     * @param storage The given Storage that saves the TaskList locally.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.add(this.task);
        ui.addAddMessage();
        ui.addTaskMessage(this.task);
        ui.addTaskListSizeMessage(taskList);
        try {
            storage.save(taskList);
        } catch (SaveException e) {
            ui.addErrorMessage(e);
        }
    }
}
