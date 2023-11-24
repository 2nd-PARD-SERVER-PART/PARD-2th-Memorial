package com.pard.memorial.dto.posting.response;

import com.pard.memorial.dto.comment.response.CommentSimpleRequestDto;
import com.pard.memorial.entity.comment.Comment;
import com.pard.memorial.entity.posting.Posting;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostingResponseDto {
    private Long id;
    private String title;
    private String content;
    private String authorId;
    private String startDate;
    private String endDate;
    private Date uploadDate;
    private List<CommentSimpleRequestDto> comment;

    public PostingResponseDto(Posting posting){
        this.id = posting.getId();
        this.title = posting.getTitle();
        this.content = posting.getContent();
        this.authorId = posting.getAuthorId();
        this.startDate = posting.getStartDate();
        this.endDate = posting.getEndDate();
        this.uploadDate = posting.getUploadDate();
        if(posting.getComment() != null){
            this.comment = posting.getComment().stream()
                    .map(CommentSimpleRequestDto::new)
                    .collect(Collectors.toList());
        }
    }

}
