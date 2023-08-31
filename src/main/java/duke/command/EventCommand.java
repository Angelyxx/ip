package duke.command;

import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;
import duke.task.Event;

import duke.exception.DukeException;

public class EventCommand extends Command {
    private String description;
    private String startDateTimeStr;
    private String endDateTimeStr;

    public EventCommand(String description, String startDateTimeStr,String endDateTimeStr) {
        this.description = description;
        this.startDateTimeStr = startDateTimeStr;
        this.endDateTimeStr = endDateTimeStr;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        Event event = new Event(description, startDateTimeStr, endDateTimeStr);
        taskList.add(event);
        ui.displayCompletionMessage(event, taskList.size());
        storage.saveTasksToFile(taskList);
    }

}
