package com.main.psoos.controller;

import com.main.psoos.dto.CustomerDTO;
import com.main.psoos.dto.LoginDTO;
import com.main.psoos.dto.UserDTO;
import com.main.psoos.model.Customer;
import com.main.psoos.model.User;
import com.main.psoos.service.CustomerService;
import com.main.psoos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @Autowired
    CustomerService customerService;
    @Autowired
    UserService userService;

    @GetMapping("/registrationPage")
    public String registrationPage(){
        return "createAccount";
    }


    @PostMapping({"/createAccount"})
    public String createAccount(CustomerDTO customerDTO, Model model) {
        System.out.println(customerDTO.getCustomerEmail() + customerDTO.getCustomerName());

        boolean isSuccess = true;
        if(customerDTO.getCustomerName().equals("") || customerDTO.getCustomerName().contains("!")){
            model.addAttribute("nameBlank",true);
            isSuccess = false;
        }
        if(customerDTO.getCustomerHomeAddress().equals("")){
            model.addAttribute("addressBlank",true);
            isSuccess = false;
        }

        if(customerDTO.getCustomerEmail().equals("")){
            model.addAttribute("emailBlank",true);
            isSuccess = false;
        }

        if(customerDTO.getCustomerPhoneNumber().equals("")){
            model.addAttribute("phoneBlank",true);
            isSuccess = false;
        }

        if(customerDTO.getPassword().equals("")){
            model.addAttribute("passwordBlank",true);
            isSuccess = false;
        }

        if(isSuccess){
            Customer customer = new Customer(customerDTO);
            UserDTO userDTO = new UserDTO(customerDTO);
            User user = new User(userDTO);
            user.setRole("USER_CLIENT");
            userService.createUser(user);
            customerService.createCustomer(customer);
        }
        return "createAccount";
    }


    @PostMapping("/updateAccount")
    public String updateAccount(CustomerDTO customerDTO, Model model){
        Customer tempCustomer = customerService.getCustomerByName(customerDTO.getCustomerOldName());
        System.out.println(tempCustomer.toString());
        tempCustomer.setCustomerPhoneNumber(customerDTO.getCustomerPhoneNumber());
        tempCustomer.setCustomerName(customerDTO.getCustomerName());
        tempCustomer.setCustomerAddress(customerDTO.getCustomerHomeAddress());
        tempCustomer.setCustomerEmail(customerDTO.getCustomerEmail());
        customerService.updateCustomerDetails(tempCustomer);
        User user = userService.getUserByName(customerDTO.getCustomerOldName());
        user.setName(customerDTO.getCustomerName());
        user.setUserName(customerDTO.getCustomerEmail());
        user.setPassword(customerDTO.getPassword());
        userService.updateUser(user);
        model.addAttribute("customer", tempCustomer);
        return "myAccount_home";
    }

}
