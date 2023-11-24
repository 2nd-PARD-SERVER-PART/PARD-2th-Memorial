package com.pard.memorial.dto.posting.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostingRequestDto {
    private String title;
    private String content;
    private String authorId;
    private String startDate;
}
