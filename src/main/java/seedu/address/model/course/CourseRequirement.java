package seedu.address.model.course;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import seedu.address.model.moduleinfo.ModuleInfo;

/**
 * Checks whether a list of module fulfils course requirement
 */
public class CourseRequirement {

    protected final String description;
    protected final String identifier;
    protected final Predicate<List<ModuleInfo>> isFulfilled;
    protected final Function<List<ModuleInfo>, String> getUnfulfilled;

    /* Protected because we only want an instance of this class to be constructed via its
       subclasses such as ContainsAll, or ContainsAtLeast
     */
    protected CourseRequirement (String description, String identifier,
                              Predicate<List<ModuleInfo>> isFulfilled,
                              Function<List<ModuleInfo>, String> getUnfulfilled) {
        requireAllNonNull(description, isFulfilled, getUnfulfilled);
        this.description = description;
        this.identifier = identifier;
        this.isFulfilled = isFulfilled;
        this.getUnfulfilled = getUnfulfilled;
    }

    /**
     * Returns description of course requirement
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns regular expressions that are not satisfied
     */
    public String getUnfulfilled(List<ModuleInfo> moduleInfos) {
        return getUnfulfilled.apply(moduleInfos);
    };

    public boolean test(List<ModuleInfo> moduleInfos) {
        return isFulfilled.test(moduleInfos);
    };

}
