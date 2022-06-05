package me.rallings.springbootjpadata;


import javax.persistence.*;

//@Entity states that this class is being used as the structure for data
//to be stored within a database.
//Each 'instance' of this class will be a tuple within a table (containing
//the info within that particular instance)
//Bc there is no @Table annotation, it is assumed that this entity will be
//mapped to a table of the same name (Customer)
@Entity
public class Customer {

    //Need an id for every entity bc you need a primary
    //key for your relational table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //(In intelliJ) you can see the primary key to the left
    private String firstName; //Column for first name
    private String lastName; //Column for last name
    //You can set individual column names with @Column if you want

    protected Customer(){}; //Only subclasses can instantiate this
                            //with no params (bc of protected)
                            //Therefore only useful for JPA

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
