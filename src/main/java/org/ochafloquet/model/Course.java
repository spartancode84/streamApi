package org.ochafloquet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @project streamApi
 * @autor Oscar Alfredo Chafloque Tampeck
 * @date 19/10/2023
 **/
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private UUID idCourse;
    private String name;
}
