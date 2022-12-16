package com.example.transactionl.web;


import com.example.transactionl.models.binding.UserRegisterBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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

   // @PostMapping
 //   public String registerUser (@Valid UserRegisterBindingModel userRegisterBindingModel,
                           //     BindingResult bindingResult,
                             //   RedirectAttributes redirectAttributes){




      //  return null;
 //   }


}
