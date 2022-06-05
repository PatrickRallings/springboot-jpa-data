package me.rallings.springbootjpadata;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

//  Repository is implemented at runtime by spring boot
//and is used to act as the interface between the code and
//the entire table's contents' (in this case, the Customer
//table).
//  Using a generics interface extension with the normal generic
//layout for CrudRepository (which is tableType, idType).
//  In this case, the type of return for our table is the Customer class
//and the primary key's type, or id type, for the table is long.
//  The CrudRepository that we are extending from includes methods for
//adding, deleting and more (this si also the case for JPARepository,
//which extends the CrudRepository as well).
//  I don't need to ever write a class for the CustomerRepository
//because the Spring Data JPA dependency does that for me.
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    //  The Spring Data JPA dependency will automatically
    //create a method within the auto-implemented class that
    //will return a list of all the customer objects
    //(tuples/rows) that contain the same last name as the
    //one given as an argument
    List<Customer> findByLastName(String lastName);

    //  Similiar to the findByLastName, this method will
    //be automatically created when the interface is implemented
    //and the method will return a Customer object (tuple)
    //that has the unique id given
    Customer findById(long id);

}
