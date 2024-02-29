package org.dbconfig;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.repositories.IPersonRepository;
import org.repositories.IProductsRepository;
import org.repositories.ProductsRepository;

public class UnitOfWork {
    private final Jdbi jdbi;
    private IProductsRepository productsRepository;
    private IPersonRepository personRepository;

    public UnitOfWork(Jdbi jdbi) {
        this.jdbi = jdbi;
        jdbi.installPlugin(new SqlObjectPlugin());
    }
    public IProductsRepository getProductsRepository() {
        return productsRepository != null ? productsRepository : (productsRepository = new ProductsRepository(jdbi));    }
    public IPersonRepository personRepository() {
        /*
        this repository is creating on demand, is similar, to a scoped variable, with, we are delegating
        to the jdbi the responsibility to create an instance of a class that implements the IPersonRepository interface,
        by this way, we can also specify the path to a directory that contains the .sql files that the repo will need
         */
        return personRepository != null ? personRepository : (personRepository = jdbi.onDemand(IPersonRepository.class));
    }
}
