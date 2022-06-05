package me.rallings.springbootjpadata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


//  @SpringBootApplication includes the annotations of:
//@Configuration: Tags this as bean source
//@EnableAutoConfiguration: Adds more beans based off of the classpath
//@ComponentScan: Looks for more components to utilize within the
//classpath, which is me/rallings in this case
@SpringBootApplication
public class SpringbootJpaDataApplication {

    //Instantiates new logger for logging the output of the springboot app, this type of logger,
    //LoggerFactory, is specifically geared towards logging API
    private static final Logger log = LoggerFactory.getLogger(SpringbootJpaDataApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaDataApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }
}
