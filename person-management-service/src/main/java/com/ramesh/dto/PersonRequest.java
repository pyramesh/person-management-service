package com.ramesh.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ramesh.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ramesh.Yaleru on 1/31/2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonRequest {

    @JsonProperty("person")
    private List<PersonDTO> personDTOS =new ArrayList<>();


}
