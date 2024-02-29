package org.example;

import org.dbconfig.Connection;
import org.mappers.PersonMapper;
import org.dbconfig.UnitOfWork;
import org.jdbi.v3.core.Jdbi;
import org.model.Person;
import org.model.Product;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /* create the jdbi connection, for this example will wrap into a Connection class in order decouple
        * and keep as a singleton.
        * */
        Jdbi jdbi = Connection.getConnection("jdbc:mysql://localhost:3306/pos", "root", "root");
        Connection.registerMapper(new PersonMapper());
        /*
         *create an instance of our unitOfWork which contains all the repos instances
         */
        UnitOfWork uow = new UnitOfWork(jdbi);
        /*
         *The product is created as a record and mapped from the database with a builder class
         */
        Product product = new Product(0, "fanta fresa", 15, "coca cola", "123457");

        uow.getProductsRepository().create(product);
        /*
        The person is a single class that include getters and setters in order to be bind to the query in the
        repository interface
         */
        Person person = new Person("jhon", "doe", "jhon@email.com", "jd124");

        uow.personRepository().create(person);
    }
}