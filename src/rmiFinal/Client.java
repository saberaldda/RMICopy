package rmiFinal;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.rmi.registry.*;

public class Client {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1234);
        Interface object = (Interface) reg.lookup("server");
        System.out.println("Connected to RMI server");

        System.out.println(object.get_course_info("A"));
        System.out.println(object.register_new_student("A", "ali"));
        System.out.println(object.register_new_student("A", "ahmad"));
        System.out.println(object.register_new_student("A", "mohamed"));
        System.out.println(object.request_Students("A"));
        System.out.println(object.drop_student("A", "ahmad"));
        System.out.println(object.request_Students("A"));

    }
}
