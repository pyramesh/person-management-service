package com.ramesh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ramesh.Yaleru on 1/31/2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonResponse {

    private String message;
    private String errorCode="";

}
