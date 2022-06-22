package rmiFinal;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Interface extends Remote {

    public String get_course_info(String course_code) throws RemoteException;

    public String register_new_student(String course_code, String student_name) throws RemoteException;

    public String drop_student(String course_code, String student_name) throws RemoteException;

    public List request_Students(String course_code) throws RemoteException;
}
