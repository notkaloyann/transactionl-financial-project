package com.example.transactionl.web;


import com.example.transactionl.models.binding.UserLoginBindingModel;
import com.example.transactionl.models.binding.UserRegisterBindingModel;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
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




}


