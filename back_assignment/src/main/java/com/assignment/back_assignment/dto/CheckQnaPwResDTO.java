package com.assignment.back_assignment.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CheckQnaPwResDTO {
    private boolean CheckQnaPw;
    private Long qnaIdx;
}
