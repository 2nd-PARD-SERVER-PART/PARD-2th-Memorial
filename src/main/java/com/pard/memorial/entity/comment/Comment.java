package com.pard.memorial.entity.comment;

import com.pard.memorial.dto.comment.requset.CommentRequestDto;
import com.pard.memorial.entity.posting.Posting;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String content;

    @CreationTimestamp
    private Date uploadDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posting")
    private Posting posting;


    public Comment(Posting posting, CommentRequestDto commentRequestDto){
        this.posting = posting;
        this.content = commentRequestDto.getContent();
    }
}
