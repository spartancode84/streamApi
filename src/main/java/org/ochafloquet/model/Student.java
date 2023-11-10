package org.ochafloquet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @project streamApi
 * @autor Oscar Alfredo Chafloque Tampeck
 * @date 14/10/2023
 **/
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private UUID idStudent;
    private String name;
    private int rolNumber;
    private String location;
    private String favoriteColor;
    private Double salary;
}
