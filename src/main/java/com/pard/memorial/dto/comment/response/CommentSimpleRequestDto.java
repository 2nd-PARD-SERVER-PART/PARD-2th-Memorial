package com.pard.memorial.dto.comment.response;

import com.pard.memorial.entity.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentSimpleRequestDto {
    private Long id;
    private String content;
    private Date uploadDate;

    public CommentSimpleRequestDto(Comment comment){
        this.id = comment.getId();
        this.content = comment.getContent();
        this.uploadDate = comment.getUploadDate();
    }
}
