package com.pard.memorial.entity.posting;

import com.pard.memorial.dto.posting.request.PostingRequestDto;
import com.pard.memorial.entity.comment.Comment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Posting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, nullable = false)
    private String title;

    @Column(length = 500, nullable = false)
    private String content;

    @Column(length = 100, nullable = false)
    private String authorId;

    @Column(length = 20, nullable = false)
    private String startDate;

    @Column(length = 20, nullable = false)
    private String endDate;

    @CreationTimestamp
    private Date uploadDate;

    @OneToMany(mappedBy = "posting", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comment;


    public Posting(PostingRequestDto postingRequestDto){
        this.title = postingRequestDto.getTitle();
        this.content = postingRequestDto.getContent();
        this.authorId = postingRequestDto.getAuthorId();
        this.startDate = postingRequestDto.getStartDate();
        this.endDate = postingRequestDto.getEndDate();
    }
}
