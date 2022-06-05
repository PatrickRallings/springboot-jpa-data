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
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);
}
