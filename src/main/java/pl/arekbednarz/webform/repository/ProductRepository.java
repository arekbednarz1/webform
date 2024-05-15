package pl.arekbednarz.webform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arekbednarz.webform.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByCompany_Id (Long companyId);
}
