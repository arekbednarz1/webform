package pl.arekbednarz.webform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.arekbednarz.webform.model.Product;
import pl.arekbednarz.webform.model.enums.ApplicationStatus;
import pl.arekbednarz.webform.model.enums.ProductType;
import pl.arekbednarz.webform.service.WebAppService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private WebAppService webAppService;


    @GetMapping({"/", "viewProducts"})
    public String viewProductsCurrentUserCompany(Model model, @ModelAttribute("message") String message, Principal principal) {
        if (principal == null){
            return  "redirect:/login";
        }
        var user = webAppService.findUserByEmail(principal.getName());

        if (user.getIsAdminUser()) {
            model.addAttribute("list", webAppService.findAllCompany());
            model.addAttribute("message", message);
            return "companyList";
        }
        model.addAttribute("list", webAppService.getAllCompanyProductsByUser(user));
        model.addAttribute("message", message);
        return "viewProductList";
    }


    @GetMapping({"viewProducts/{id}"})
    public String viewProductCompanyById(@PathVariable Long id, Model model, @ModelAttribute("message") String message, Principal principal) {
        var user = webAppService.findUserByEmail(principal.getName());

        if (user.getIsAdminUser()) {
            model.addAttribute("list", webAppService.getAllCompanyProductsById(id));
        } else {
            model.addAttribute("list", webAppService.getAllCompanyProductsByUser(user));
        }
        model.addAttribute("message", message);

        return "viewProductList";
    }

    @GetMapping("/addProduct")
    public String addToDoItem(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("types", ProductType.getListOfHumanReadableStrings());
        return "addProduct";
    }

    @PostMapping("/saveProduct")
    public String saveToDoItem(@Valid @ModelAttribute Product product, BindingResult result, RedirectAttributes redirectAttributes, Principal principal, Model model) {
        var user = webAppService.findUserByEmail(principal.getName());
        if (product.getProductType().equals("NONE")) {
            result.rejectValue("productType", "error.user",
                    "This field is mandatory.");
        }
        if (result.hasErrors()) {
            model.addAttribute("product", product);
            model.addAttribute("types", ProductType.getListOfHumanReadableStrings());
            return "addProduct";
        }
        if (webAppService.saveOrUpdateProductItem(product, user)) {
            redirectAttributes.addFlashAttribute("message", "Save Success");
            return "redirect:/viewProducts";
        }
        redirectAttributes.addFlashAttribute("message", "Save Failure");
        return "redirect:/addProduct";
    }

    @GetMapping("/editProduct/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", webAppService.getProductItemById(id));
        model.addAttribute("types", ProductType.getListOfHumanReadableStrings());
        return "editProduct";
    }

    @PostMapping("/editSaveProduct")
    public String editSaveToDoItem(@Valid @ModelAttribute Product product, BindingResult result, RedirectAttributes redirectAttributes, Principal principal, Model model) {
        var user = webAppService.findUserByEmail(principal.getName());

        if (product.getProductType().equals("NONE")) {
            result.rejectValue("productType", "error.user",
                    "This field is mandatory.");
        }
        if (result.hasErrors()){
            return "redirect:/editProduct/" + product.getId();
        }

            if (webAppService.saveOrUpdateProductItem(product, user)) {
                redirectAttributes.addFlashAttribute("message", "Save Success");
                return "redirect:/viewProducts";
            }

        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/editProduct/" + product.getId();
    }


    @GetMapping("/deleteProduct/{id}")
    public String deleteToDoItem(@PathVariable Long id, RedirectAttributes redirectAttributes, Principal principal) {
        var user = webAppService.findUserByEmail(principal.getName());
        if (webAppService.deleteProductItem(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
            return "redirect:/viewProducts";
        }

        redirectAttributes.addFlashAttribute("message", "Delete Failure");
        return "redirect:/viewProducts";
    }




    @GetMapping("/companyApprove/{id}")
    public String approveApplication(@PathVariable Long id, RedirectAttributes redirectAttributes, Principal principal) {
        var company = webAppService.getCompanyById(id);

        if (company != null) {
            company.setStatus(ApplicationStatus.APPROVED.getValue());
            if (webAppService.saveOrUpdateCompany(company)) {
                redirectAttributes.addFlashAttribute("message", "Save Success");
                return "redirect:/";
            }
        }

        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/";

    }

    @GetMapping("/deleteCompany/{id}")
    public String denyApplication(@PathVariable Long id, RedirectAttributes redirectAttributes, Principal principal) {
        if (webAppService.deleteCompany(id)) {
                redirectAttributes.addFlashAttribute("message", "Save Success");
                return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/";

    }

    @GetMapping("/filterCompanyList")
    public String filterCompanyLIst(@Param("inputValue") String inputValue, Model model, @ModelAttribute("message") String message) {
        if (!inputValue.isEmpty()){
            model.addAttribute("list", webAppService.filterCompanies(inputValue));
            model.addAttribute("message", message);
            return "companyList";
        }
        return "redirect:/";
    }
}
