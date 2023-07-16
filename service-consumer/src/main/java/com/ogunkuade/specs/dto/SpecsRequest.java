package com.ogunkuade.specs.dto;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SpecsRequest {

    private String name;
    private String email;
    private String bloodGroup;
    private String lane1;
    private String lane2;
    private Long zip;
    private String state;


}
