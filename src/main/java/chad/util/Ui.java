package chad.util;

import chad.task.Task;

/**
 * Represents user interface of the chatbot.
 */
public class Ui {
    private String message;

    /**
     * Constructor for UI class.
     */
    public Ui() {
        this.message = "";
    }

    /**
     * Returns the welcome message of the Chad.
     */
    public static String getWelcomeMessage() {
        return "Hello! I'm Chad \n"
                + "What can I do for you? \n";
    }

    /**
     * Prints the exit message of the chatbot.
     */
    public void addExitMessage() {
        this.message = "Bye. Hope to see you again soon!\n";
    }

    /**
     * Returns a String of the current message in the Ui object and clears the message.
     *
     * @return String with the current message.
     */
    public String showMessage() {
        String output = this.message;
        this.message = "";
        return output;
    }

    /**
     * Adds all the String representation of Tasks in a given TaskList.
     *
     * @param taskList The given TaskList.
     */
    public void addTaskList(TaskList taskList) {
        this.message += taskList.toString();
    }

    /**
     * Adds a message to indicate that a given task has been successfully added.
     */
    public void addAddMessage() {
        this.message += "Got it. I've added this task:\n";
    }

    /**
     * Adds a message to indicate that a given task has been successfully deleted.
     */
    public void addDeleteMessage() {
        this.message += "Noted. I've removed this task:\n";
    }

    /**
     * Adds a message to indicate that a given task has been successfully marked.
     */
    public void addMarkMessage() {
        this.message += "Nice! I've marked this task as done:\n";
    }

    /**
     * Adds a message to indicate that a given task has been successfully unmarked.
     */
    public void addUnmarkMessage() {
        this.message += "OK, I've marked this task as not done yet:\n";
    }

    /**
     * Adds the error message from a given Exception.
     *
     * @param e The Exception thrown from the execution of a method.
     */
    public void addErrorMessage(Exception e) {
        assert e != null : "Exception cannot be null";

        this.message += "Oops! we encountered an error\n" + e.getMessage() + "\n";
    }

    /**
     * Adds the error message when the parser cannot find a matching command.
     */
    public void addCommandNotFound() {
        this.message += "Oops! I'm sorry, but I don't know what that means :-(\n";
    }

    /**
     * Adds the message to indicate the find query is successful.
     */
    public void addFindMessage() {
        this.message += "Here are the matching tasks in your list:\n";
    }

    /**
     * Adds the String representation of the given Task into the message.
     *
     * @param task The given Task to be added into the message of the UI.
     */
    public void addTaskMessage(Task task) {
        assert task != null : "Task cannot be null";

        this.message += task + "\n";
    }

    /**
     * Adds the message indicating the size of the TaskList.
     *
     * @param taskList The given TaskList.
     */
    public void addTaskListSizeMessage(TaskList taskList) {
        assert taskList != null : "TaskList cannot be null";

        this.message += "Now you have " + taskList.size() + " tasks in the list." + "\n";
    }
}
