package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_UNFULFILLED;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.moduletaken.IsUnfulfilledPredicate;

/**
 * Command to display requirement that is either completed / uncompleted
 */
public class DisplayreqCommand extends  Command{
    public static final String COMMAND_WORD = "displayreq";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + "Displays lists of requirement based on given "
            + "parameters: "
            + "[" + PREFIX_UNFULFILLED + "IS_FULFILLED" +"] \n"
            + "EXAMPLE: " + COMMAND_WORD + " "
            + "PREFIX_UNFULFILLED" + "true";

    private final IsUnfulfilledPredicate predicate;

    public DisplayreqCommand(IsUnfulfilledPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        requireNonNull(model);
        model.updateReqList(predicate);
        return new CommandResult("Something");
    }
}
