package com.example.AEM;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceCreateRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String description;
}
