package com.ogunkuade.specs.feignclient;


import com.ogunkuade.specs.dto.AddressRequest;
import com.ogunkuade.specs.dto.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


/*
    use "path" for internal API
    use "url" for external API
 */

@FeignClient(name = "ADDRESS-SERVICE", path = "/address-app/api/address")
public interface AddressClient {

    @PostMapping("/create")
    AddressResponse savingAddress(@RequestBody AddressRequest addressRequest);

    @GetMapping("/{id}")
    AddressResponse gettingAddressById(@PathVariable Long id);

    @GetMapping("/all")
    List<AddressResponse> gettingAllAddresses();

}




