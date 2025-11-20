package com.example.AEM;


import lombok.*;

import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackRequest {
    private Integer score; // optional
    @NotBlank
    private String comment;
}
