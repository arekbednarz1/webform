package pl.arekbednarz.webform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.arekbednarz.webform.model.Company;
import pl.arekbednarz.webform.model.Owner;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

    Company findByCompanyOwners(final Owner owner);

    @Query("SELECT c from Company c where c.companyName like %:keyword% or c.city like %:keyword% or c.status like %:keyword% or c.companyOwners.firstName like %:keyword% or c.companyOwners.lastName like %:keyword%")
    List<Company> getCompaniesByFieldValue(String keyword);
}
