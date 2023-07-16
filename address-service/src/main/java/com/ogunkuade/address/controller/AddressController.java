package com.ogunkuade.address.controller;


import com.ogunkuade.address.dto.AddressRequest;
import com.ogunkuade.address.entity.Address;
import com.ogunkuade.address.exceptions.AddressNotFoundException;
import com.ogunkuade.address.service.AddressService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/address")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    //CREATE NEW ADDRESS
    @PostMapping("/create")
    public Address savingAddress(@RequestBody AddressRequest addressRequest){
        return addressService.saveAddress(addressRequest);
    }

    //GET ADDRESS BY ID
    @GetMapping("/{id}")
    public Address gettingAddressById(@PathVariable Long id) throws AddressNotFoundException {
        System.out.println("Getting Address With Id " + id);
        return addressService.getAddressById(id);
    }

    //GET ALL ADDRESSES
    @GetMapping("/all")
    public List<Address> gettingAllAddresses(){
        System.out.println("Getting All Addresses");
        return addressService.getAllAddresses();
    }

    //DELETE ADDRESS BY ID
    @DeleteMapping(path = "/{id}/delete")
    public String deleteAddressById(@PathVariable Long id) throws AddressNotFoundException {
        return addressService.deleteAddressById(id);
    }



}
