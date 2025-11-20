package com.example.AEM;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PerformanceResponse {
    private Long id;
    private String title;
    private String description;
    private Integer score;
    private Long employeeId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<FeedbackDto> feedbacks;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class FeedbackDto {
        private Long id;
        private Long authorId;
        private String authorName;
        private String comment;
        private LocalDateTime createdAt;
    }
}
