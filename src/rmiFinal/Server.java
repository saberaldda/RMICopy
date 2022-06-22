package rmiFinal;

import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;


public class Server extends UnicastRemoteObject implements Interface {

    List<Course> courses = new ArrayList();

    Server(List<Course> courses) throws RemoteException {
        this.courses = courses;
    }

    @Override
    public String get_course_info(String code) throws RemoteException {
        for (Course course : courses) {
            if (course.course_code.equals(code)) {
                String reply = "Course Name: " + course.course_name + " , Cource Hours: " + course.credit_hours;
                return reply;
            }
        }
        return "the cource not found";
    }

    @Override
    public String register_new_student(String code, String name) throws RemoteException {
        for (Course course : courses) {
            if (course.course_code.equals(code)) {
                course.studentsList.add(name);
                return "Student Registered";
            }
        }
        return "the cource not found";
    }

    @Override
    public String drop_student(String code, String name) throws RemoteException {
        for (Course course : courses) {
            if (course.course_code.equals(code)) {
                if (course.studentsList.contains(name)) {
                    course.studentsList.remove(name);
                    return "Student Deleted";
                } else {
                    return name + " not exist";
                }
            }
        }
        return "the cource not found";
    }

    @Override
    public List request_Students(String code) throws RemoteException {
        List error = new ArrayList();
        error.add(error);
        for (Course course : courses) {
            if (course.course_code.equals(code)) {
                return course.studentsList;
            }
        }
        return error;
    }

    public static void main(String[] args) {
        List<Course> courses = new ArrayList();
        Course course1 = new Course("A", "arabic", 20);
        Course course2 = new Course("B", "english", 30);
        Course course3 = new Course("C", "math", 40);
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        try {
            Registry reg = LocateRegistry.createRegistry(1234);
            Server object = new Server(courses);
            reg.rebind("server", object);
            System.out.println("Server started");

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
