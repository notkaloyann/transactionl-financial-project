package com.example.transactionl.web;


import com.example.transactionl.models.binding.UserRegisterBindingModel;
import com.example.transactionl.models.entities.UserEntity;
import com.example.transactionl.models.service.UserRegisterServiceModel;
import com.example.transactionl.models.view.UserViewModel;
import com.example.transactionl.repositories.UserRepository;
import com.example.transactionl.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
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

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {


    private final UserService userService;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;


    public UserController(UserService userService, ModelMapper modelMapper,
                          UserRepository userRepository) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }


    @ModelAttribute("userRegisterBindingModel")
    public UserRegisterBindingModel createBindingModel(){
        return new UserRegisterBindingModel();
    }

   @PostMapping("/register")
   public String registerUser (@Valid UserRegisterBindingModel userRegisterBindingModel,
                               BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){


       UserRegisterServiceModel userRegisterServiceModel = this.modelMapper.map(userRegisterBindingModel, UserRegisterServiceModel.class);
        this.userService.registerUser(userRegisterServiceModel);

       return "redirect:profile";
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


  @PostMapping("/profile")
  public String setUserDetails(UserViewModel userViewModel){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        UserEntity userEntity = this.userService.returnUserEntityByUsername(username);
        userEntity.setFirstName(userViewModel.getFirstName());
        userEntity.setLastName(userViewModel.getLastName());
        userEntity.setBio(userViewModel.getBio());
        userRepository.save(userEntity);
        return "redirect:profile";
  }

    @ModelAttribute("userViewModel")
    public UserViewModel createViewModel(){
        return new UserViewModel();
    }


  @GetMapping("/register")
    public String register(){
        return "register";
  }






}


