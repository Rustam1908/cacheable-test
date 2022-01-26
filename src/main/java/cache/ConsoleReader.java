package cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ConsoleReader extends Thread {

    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService;

    @Autowired
    public ConsoleReader(UserService userService) {
        this.userService = userService;
        this.start();
    }

    @Override
    public void run() {
        System.out.println("#### console reading started ####");

        while (true) {

            String command = scanner.nextLine();

            if ("stop".equals(command)) {
                System.out.println("#### console reading stopped ####");
                break;
            }

            if ("list".equals(command)) {
                for (User user : userService.getAllUsers()) {
                    System.out.println(user);
                }
            }

            if (command.startsWith("fn")) {
                String neededName = command.substring(3);
                System.out.println(userService.getUserByFistName(neededName));
            }

            if (command.startsWith("ln")) {
                String neededName = command.substring(3);
                System.out.println(userService.getUserByLastName(neededName));
            }
        }
    }
}
