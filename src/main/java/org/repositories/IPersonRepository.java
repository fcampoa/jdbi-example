package org.repositories;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.model.Person;

import java.util.List;

public interface IPersonRepository {
    @SqlUpdate("INSERT INTO Person(name, lastname, email, dni) VALUES(:person.name, :person.lastname, :person.email, :person.dni)")
    int create(@BindBean("person") Person person);
    @SqlUpdate("UPDATE Person SET name = :person.name, lastname = :person.lastname, email = :person.email, dni = :person.dni WHERE id = :person.id")
    int update(@BindBean("person") Person person);
    @SqlUpdate("DELETE FROM Person WHERE id = :id")
    void delete(@Bind("id") int id);
    @SqlQuery("SELECT * FROM PERSON")
    List<Person> get();
    @SqlQuery("SELECT * FROM PERSON WHERE id = :id")
    Person read(@Bind("id") int id);
}
