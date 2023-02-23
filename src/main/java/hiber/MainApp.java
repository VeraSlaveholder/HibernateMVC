package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);
        userService.deleteAllUsers();
        User user1 = new User("User1", "Lastname1", "user1@mail.ru");

        userService.add(user1);


        Car car1 = new Car("Lada", 123);

        user1.setCar(car1);

        carService.add(car1);

        // System.out.println(user1.getCar());
//        List<User> users = userService.listUsers();
//        for (User user : users) {
//            System.out.println("Id = " + user.getId());
//            System.out.println("First Name = " + user.getFirstName());
//            System.out.println("Last Name = " + user.getLastName());
//            System.out.println("Email = " + user.getEmail());
//            System.out.println("Car = " + user.getCar());
//            System.out.println();
//        }

        context.close();
    }
}
