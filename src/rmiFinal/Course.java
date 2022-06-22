package rmiFinal;

import java.util.ArrayList;
import java.util.List;

public class Course {

    String course_code;
    String course_name;
    int credit_hours;

    // students names
    List<String> studentsList = new ArrayList();

    Course(String course_code, String cource_name, int credit_hours) {
        this.course_code = course_code;
        this.course_name = cource_name;
        this.credit_hours = credit_hours;
    }

}
