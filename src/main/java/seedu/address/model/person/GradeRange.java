package seedu.address.model.person;

/**
 * Represents expected grade range of a module taken
 */
public class GradeRange {
    private Grade min;
    private Grade max;

    public Grade getMin() {
        return min;
    }

    public Grade getMax() {
        return max;
    }

    public void setMin(Grade min) {
        this.min = min;
    }

    public void setMax(Grade max) {
        this.max = max;
    }

    /**
     * Returns true if the min gradepoint is no more than max gradepoint
     */
    public boolean checkMinNotMoreThanMax() {
        return min.isWithin(max);
    }
}
