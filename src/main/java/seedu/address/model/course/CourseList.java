package seedu.address.model.course;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.commons.util.InvalidationListenerManager;

/**
 * Wraps all data at the Course List level
 * Duplicates are not allowed (by name)
 */
public class CourseList {
    private final List<Course> courseList;
    private final InvalidationListenerManager invalidationListenerManager = new InvalidationListenerManager();

    {
        courseList = new ArrayList<>();
    }

    public CourseList() {}

    /** Adds Course to the List of all the modules
    * @param course
    */
    public void addCourse(Course course) {
        this.courseList.add(course);
        System.out.println("new module added:" + course.getCourseName().toString());
    }

    /**
     * Returns Course which has the same course name
     * @param courseName
     * @return ModuleInfo
     */
    public Course getCourse(CourseName courseName) {
        Course course = null;
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseName().equals(courseName)) {
                course = courseList.get(i);
            }
        }
        return course;
    }

    public ObservableList<Course> getObservableList() {
        ObservableList<Course> observableList = FXCollections.observableArrayList(courseList);
        return observableList;
    }

    /**
     * Returns an ObservableList of all Courses.
     * @return an ObservableList.
     */
    public ObservableList<Course> getObservableCodeList() {
        ArrayList<Course> codeList = new ArrayList<>();
        for (Course course: courseList) {
            codeList.add(course);
        }

        return FXCollections.observableArrayList(codeList);
    }
}
