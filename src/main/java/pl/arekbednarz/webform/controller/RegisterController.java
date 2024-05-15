package pl.arekbednarz.webform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.arekbednarz.webform.model.Owner;
import pl.arekbednarz.webform.model.formDTO.AdminFormModel;
import pl.arekbednarz.webform.model.formDTO.CompanyFormModel;
import pl.arekbednarz.webform.service.WebAppService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private WebAppService webAppService;

    @Autowired
    public RegisterController(WebAppService webAppService) {
        this.webAppService = webAppService;
    }

    @GetMapping()
    public String registerForm (Model model) {
        model.addAttribute("companyFormModel", new CompanyFormModel());

        return "registration";
    }

    @GetMapping("/admin")
    public String registerFormAdmin (Model model) {
        model.addAttribute("adminFormModel", new AdminFormModel());
        return "adminRegister";
    }

    @PostMapping("/admin")
    public String registerAction (@ModelAttribute @Valid AdminFormModel adminFormModel, BindingResult result) {
        Owner owner1 = webAppService.findUserByEmail(adminFormModel.getEmail());

        if (owner1 != null) {
            result.rejectValue("companyOwnerEmail", "error.user",
                    "User with that email address is already register.");
        }
        if (!adminFormModel.getPassword().equals(adminFormModel.getPasswordRepeat())) {
            result.rejectValue("password", "error.user", "Passwords are not same.");
            result.rejectValue("passwordRepeat", "error.user", "Passwords are not same.");
        }
        if (result.hasErrors()) {
            return "adminRegister";
        }
        webAppService.saveAdminUser(adminFormModel);
        return "redirect:/login";
    }


    @PostMapping()
    public String registerAction (@ModelAttribute @Valid CompanyFormModel companyFormModel, BindingResult result) {
        Owner owner1 = webAppService.findUserByEmail(companyFormModel.getCompanyOwnerEmail());

        if (owner1 != null) {
            result.rejectValue("companyOwnerEmail", "error.user",
                    "User with that email address is already register.");
        }
        if (!companyFormModel.getPassword().equals(companyFormModel.getPasswordRepeat())) {
            result.rejectValue("passwordRepeat", "error.user", "Passwords are not same.");
        }
        if (result.hasErrors()) {
            return "registration";
        }
        webAppService.saveOwnerWithCOmpany(companyFormModel);
        return "redirect:/login";
    }
}


