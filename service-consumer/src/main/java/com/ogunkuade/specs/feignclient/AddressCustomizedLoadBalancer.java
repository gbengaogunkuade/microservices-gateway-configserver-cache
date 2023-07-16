package com.ogunkuade.specs.feignclient;



import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;


@LoadBalancerClient(name="ADDRESS-SERVICE", configuration= LoadBalancerConfiguration.class)
public class AddressCustomizedLoadBalancer {
    //
}




