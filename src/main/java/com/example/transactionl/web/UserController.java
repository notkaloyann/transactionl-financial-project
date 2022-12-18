package com.example.transactionl.web;


import com.example.transactionl.models.binding.UserRegisterBindingModel;
import com.example.transactionl.models.view.UserViewModel;
import com.example.transactionl.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registerPage(){
        return null;
    }

   @PostMapping
   public String registerUser (@Valid UserRegisterBindingModel userRegisterBindingModel,
                               BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){




       return null;
  }

  @GetMapping("login")
    public String login(){
        return "login";
  }

  @PostMapping("/login-error")
    public String loginError(@ModelAttribute (UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username,
                            RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("username", username);
        redirectAttributes.addFlashAttribute("bad_credentials", true);


        return "redirect:login";
  }

  @GetMapping("/profile")
    public String profilePage(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        UserViewModel userViewModel = this.userService.getUserViewModelByUsername(username);
        model.addAttribute("userViewModel",userViewModel);
        return "profile-page";
  }





}


