package com.ramesh.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Ramesh.Yaleru on 1/31/2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTO {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("age")
    private String age;

    @JsonProperty("favourite_colour")
    private String favouriteColour;

    @JsonProperty("hobby")
    private List<HobbyDTO> hobbies;


}
