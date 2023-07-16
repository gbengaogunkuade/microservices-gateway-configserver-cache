package com.ogunkuade.specs.feignclient;


import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;

@LoadBalancerClient(name = "EMPLOYEE-SERVICE", configuration = LoadBalancerConfiguration.class)
public class EmployeeCustomizedLoadBalancer {
    //
}



