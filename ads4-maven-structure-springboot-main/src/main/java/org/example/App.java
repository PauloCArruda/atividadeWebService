package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableJpaRepositories
public class App {
    /**public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
    }*/
    public static void main(
            String[] args) {
        SpringApplication.run(App.class, args);
    }
}
