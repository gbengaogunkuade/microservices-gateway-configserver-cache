package com.ogunkuade.address.service;


import com.ogunkuade.address.dto.AddressRequest;
import com.ogunkuade.address.entity.Address;
import com.ogunkuade.address.exceptions.AddressNotFoundException;
import com.ogunkuade.address.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AddressService {

    Logger logger = LoggerFactory.getLogger(AddressService.class);

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    //CREATE NEW ADDRESS
    public Address saveAddress(AddressRequest addressRequest){
        Address addressNew = new Address(
                addressRequest.getLane1(),
                addressRequest.getLane2(),
                addressRequest.getZip(),
                addressRequest.getState()
        );
        Address address = addressRepository.save(addressNew);
        return address;
    }


    //GET ADDRESS BY ID
    @Cacheable(cacheNames = "addresses", key = "#id")
    public Address getAddressById(Long id) throws AddressNotFoundException {
        Address address = addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException("address with this Id not found"));
        logger.info(String.format("ADDRESS FETCH FROM DATABASE"));
        return address;
    }


    //GET ALL ADDRESSES
    public List<Address> getAllAddresses(){
        List<Address> addressList = addressRepository.findAll();
        return addressList;
    }



    //DELETE ADDRESS BY ID
    @CacheEvict(cacheNames = "addresses", key = "#id")
    public String deleteAddressById(Long id) throws AddressNotFoundException {
        Address address = addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException("address with this Id not found"));
        addressRepository.delete(address);
        logger.info(String.format("ADDRESS DELETED FROM DATABASE"));
        return String.format("address with the id %d has been deleted", id);
    }




}
