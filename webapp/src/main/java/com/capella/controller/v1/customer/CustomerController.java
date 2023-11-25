package com.capella.controller.v1.customer;

import com.capella.domain.model.customer.CustomerModel;
import com.capella.facade.customer.CustomerFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerController {

   protected final CustomerFacade customerFacade;

   @GetMapping("/{name}")
   public CustomerModel getCustomerByName(@PathVariable String name){
      var customer = customerFacade.getCustomerByName(name);
      return customer;
   }

}
