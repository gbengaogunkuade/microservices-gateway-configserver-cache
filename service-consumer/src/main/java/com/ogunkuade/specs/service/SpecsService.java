package com.ogunkuade.specs.service;


import com.ogunkuade.specs.dto.*;
import com.ogunkuade.specs.feignclient.AddressClient;
import com.ogunkuade.specs.feignclient.EmployeeClient;
import feign.FeignException;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


@Service
public class SpecsService {


    //SPRING CLOUD LOAD BALANCER
    private final LoadBalancerClient loadBalancerClient;


    private final EmployeeClient employeeClient;
    private final AddressClient addressClient;


    public SpecsService(LoadBalancerClient loadBalancerClient, EmployeeClient employeeClient, AddressClient addressClient) {
        this.loadBalancerClient = loadBalancerClient;
        this.employeeClient = employeeClient;
        this.addressClient = addressClient;
    }




    //GET SPECS BY ID
    public SpecsResponse getSpecsById(Long id){
        SpecsResponse specsResponse = new SpecsResponse();
        try{
            EmployeeResponse employeeResponse = employeeClient.gettingEmployeeById(id);
            specsResponse.setId(employeeResponse.getId());
            specsResponse.setName(employeeResponse.getName());
            specsResponse.setEmail(employeeResponse.getEmail());
            specsResponse.setBloodGroup(employeeResponse.getBloodGroup());
            AddressResponse addressResponse = addressClient.gettingAddressById(id);
            specsResponse.setLane1(addressResponse.getLane1());
            specsResponse.setLane2(addressResponse.getLane2());
            specsResponse.setZip(addressResponse.getZip());
            specsResponse.setState(addressResponse.getState());
        }
        catch(FeignException.FeignClientException.NotFound e){
            e.getMessage();
        }
        return specsResponse;
    }






    //CREATE BOTH NEW EMPLOYEE AND NEW ADDRESS FROM SPECS
    public SpecsResponse saveSpecs(SpecsRequest specsRequest){
        EmployeeRequest employeeRequest = new EmployeeRequest(
                specsRequest.getName(),
                specsRequest.getEmail(),
                specsRequest.getBloodGroup()
        );
        AddressRequest addressRequest = new AddressRequest(
                specsRequest.getLane1(),
                specsRequest.getLane2(),
                specsRequest.getZip(),
                specsRequest.getState()
        );
        EmployeeResponse employeeResponse = employeeClient.savingEmployee(employeeRequest);
        AddressResponse addressResponse = addressClient.savingAddress(addressRequest);

        SpecsResponse specsResponse = new SpecsResponse();
        specsResponse.setId(employeeResponse.getId());
        specsResponse.setName(employeeResponse.getName());
        specsResponse.setEmail(employeeResponse.getEmail());
        specsResponse.setBloodGroup(employeeResponse.getBloodGroup());
        specsResponse.setLane1(addressResponse.getLane1());
        specsResponse.setLane2(addressResponse.getLane2());
        specsResponse.setZip(addressResponse.getZip());
        specsResponse.setState(addressResponse.getState());
        return specsResponse;
    }



    //GET ALL EMPLOYEES AND ADDRESSES
//    public List<SpecsResponse> getAllSpecs2(){
//        List<SpecsResponse> specsResponseList = new ArrayList<>();
//        List<EmployeeResponse> employeeResponseList = employeeClient.gettingAllEmployees();
//        List<AddressResponse> addressResponseList = addressClient.gettingAllAddresses();
//        //convert each list to an iterator object
//        ListIterator<EmployeeResponse> employeeResponseListIterator = employeeResponseList.listIterator();
//        ListIterator<AddressResponse> addressResponseListIterator = addressResponseList.listIterator();
//
//        while(employeeResponseListIterator.hasNext()){
//            SpecsResponse specsResponse = new SpecsResponse();
//            specsResponse.setEmployeeResponse(employeeResponseListIterator.next());
//            specsResponse.setAddressResponse(addressResponseListIterator.next());
//            specsResponseList.add(specsResponse);
//        }
//        return specsResponseList;
//    }



    //GET ALL EMPLOYEES AND ADDRESSES
    public List<SpecsResponse> getAllSpecs(){
        List<SpecsResponse> specsResponseList = new ArrayList<>();
        try{
            List<EmployeeResponse> employeeResponseList = employeeClient.gettingAllEmployees();
            for(EmployeeResponse employeeResponse : employeeResponseList){
                SpecsResponse specsResponse = new SpecsResponse();
                specsResponse.setId(employeeResponse.getId());
                specsResponse.setName(employeeResponse.getName());
                specsResponse.setEmail(employeeResponse.getEmail());
                specsResponse.setBloodGroup(employeeResponse.getBloodGroup());
                AddressResponse addressResponse = addressClient.gettingAddressById(employeeResponse.getId());
                specsResponse.setLane1(addressResponse.getLane1());
                specsResponse.setLane2(addressResponse.getLane2());
                specsResponse.setZip(addressResponse.getZip());
                specsResponse.setState(addressResponse.getState());
                specsResponseList.add(specsResponse);
            }
        }
        catch(FeignException.FeignClientException.NotFound e){
            e.getMessage();
        }
        return specsResponseList;
    }








}



