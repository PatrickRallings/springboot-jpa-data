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
            //  save a few customers
            repository.save(new Customer("Patrick", "Rallings"));
            repository.save(new Customer("Matt", "Papacha"));
            repository.save(new Customer("Hector", "Gonzalez"));
            repository.save(new Customer("Cameron", "Bostic"));

            //  fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            String s = "\n";
            for (Customer customer : repository.findAll()) {
                s += customer.toString()+"\n";
            }
            log.info(s);
            log.info("-------------------------------");

            //  fetch an individual customer by ID
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            //  fetches customers by last name of 'Rallings'
            log.info("Customer found with findByLastName('Rallings'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Rallings").forEach(tuple -> {
                log.info(tuple.toString());
            });
            //  for (Customer bauer : repository.findByLastName("Rallings")) {
            //  log.info(tuple.toString());
            // }
            log.info("");
        };
    }
}
