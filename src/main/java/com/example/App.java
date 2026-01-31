package com.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Result: " + calc.calculate(10, 5, "add-again"));
        }
        UserService service = new UserService();
        service.findUser("admin");
        service.deleteUser("admin"); // NEW dangerous call
        }
}

