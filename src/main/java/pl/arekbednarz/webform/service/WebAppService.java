package pl.arekbednarz.webform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.arekbednarz.webform.model.Company;
import pl.arekbednarz.webform.model.Owner;
import pl.arekbednarz.webform.model.Product;
import pl.arekbednarz.webform.model.formDTO.AdminFormModel;
import pl.arekbednarz.webform.model.formDTO.CompanyFormModel;
import pl.arekbednarz.webform.repository.CompanyRepository;
import pl.arekbednarz.webform.repository.ProductRepository;
import pl.arekbednarz.webform.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static pl.arekbednarz.webform.model.enums.ApplicationStatus.IN_PROGRESS;


@Service
public class WebAppService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public Company getCompanyById(final Long companyId){
        return companyRepository.findById(companyId).orElse(null);
    }
    public boolean saveOrUpdateCompany(final Company company){
        Company updatedObj = companyRepository.save(company);
        return getCompanyById(updatedObj.getId()) != null;
    }

    public boolean deleteCompany(final Long companyId){
        List<Product> companyProducts = getAllCompanyProductsById(companyId);
        if (!companyProducts.isEmpty()){
            productRepository.deleteAll(companyProducts);
        }
        companyRepository.deleteById(companyId);
        return companyRepository.findById(companyId).isEmpty();
    }

    public Company findCompanyByUser(final Owner owner){
        return companyRepository.findByCompanyOwners(owner);
    }

    public List<Company> findAllCompany(){
        return companyRepository.findAll();
    }

    public List<Product> getAllCompanyProductsByUser(final Owner owner){
        var company = companyRepository.findByCompanyOwners(owner);
        if(company != null){
            return productRepository.findAllByCompany_Id(company.getId());
        }
        return new ArrayList<>();
    }
    public List<Company>filterCompanies(final String keyword){
        return companyRepository.getCompaniesByFieldValue(keyword);
    }


    public Owner findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
    public void saveOwnerWithCOmpany(CompanyFormModel companyFormModel) {
        Owner owner = new Owner();
        owner.setEnable(true);
        owner.setEmail(replaceHtmlTags(companyFormModel.getCompanyOwnerEmail()));
        owner.setFirstName(replaceHtmlTags(companyFormModel.getCompanyOwnerName()));
        owner.setLastName(replaceHtmlTags(companyFormModel.getCompanyOwnerSurname()));
        owner.setIsAdminUser(false);
        owner.setPassword(bCryptPasswordEncoder.encode(replaceHtmlTags(companyFormModel.getPassword())));

        Company company = new Company();
        company.setCompanyName(replaceHtmlTags(companyFormModel.getCompanyName()));
        company.setCompanyOwners(userRepository.save(owner));
        company.setStreet(replaceHtmlTags(companyFormModel.getStreet()));
        company.setHouseNo(replaceHtmlTags(companyFormModel.getHouseNumber()));
        company.setApprtNo(replaceHtmlTags(companyFormModel.getApprtNumber()));
        company.setCity(replaceHtmlTags(companyFormModel.getCity()));
        company.setZip(replaceHtmlTags(companyFormModel.getZipCode()));;
        company.setStatus(IN_PROGRESS.getValue());
        companyRepository.saveAndFlush(company);
    }
    public void saveAdminUser(final AdminFormModel adminFormModel){
        Owner owner = new Owner();
        owner.setEnable(true);
        owner.setEmail(replaceHtmlTags(adminFormModel.getEmail()));
        owner.setFirstName(replaceHtmlTags(adminFormModel.getName()));
        owner.setLastName(replaceHtmlTags(adminFormModel.getSurname()));
        owner.setIsAdminUser(true);
        owner.setPassword(bCryptPasswordEncoder.encode(replaceHtmlTags(adminFormModel.getPassword())));

        userRepository.saveAndFlush(owner);
    }

    public boolean saveOrUpdateProductItem(Product productsFormModel,Owner user) {
        productsFormModel.setCompany(findCompanyByUser(user));
        Product updatedObj = productRepository.save(productsFormModel);
        return getProductItemById(updatedObj.getId()) != null;
    }

    public boolean deleteProductItem(Long id) {
        productRepository.deleteById(id);
        return productRepository.findById(id).isEmpty();
    }
    public Product getProductItemById(Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> getAllCompanyProductsById(final Long companyId){
        var company = companyRepository.findById(companyId);
        if(company.isPresent()){
            return productRepository.findAllByCompany_Id(company.get().getId());
        }
        return new ArrayList<>();
    }


    private String replaceHtmlTags(final String value){
        return value.replaceAll("\\<.*?\\>", "");
    }
}
