package com.ogunkuade.specs.controller;


import com.ogunkuade.specs.dto.*;
import com.ogunkuade.specs.service.SpecsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class SpecsController {

    private final SpecsService specsService;


    public SpecsController(SpecsService specsService) {
        this.specsService = specsService;
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SpecsResponse gettingSpecsById(@PathVariable Long id){
        return specsService.getSpecsById(id);
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public SpecsResponse savingSpecs(@RequestBody SpecsRequest specsRequest){
        System.out.println(specsRequest);
        return specsService.saveSpecs(specsRequest);
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<SpecsResponse> gettingAllSpecs(){
        return specsService.getAllSpecs();
    }



}
