package org.ochafloquet.model;

import lombok.*;

import java.util.UUID;

/**
 * @project streamApi
 * @autor Oscar Alfredo Chafloque Tampeck
 * @date 20/10/2023
 *
 * **/
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudent {

    @NonNull
    private UUID idStudent;
    @NonNull
    private UUID idCourse;
}
