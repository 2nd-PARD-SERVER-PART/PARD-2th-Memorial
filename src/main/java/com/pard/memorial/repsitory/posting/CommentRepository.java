package com.pard.memorial.repsitory.posting;

import com.pard.memorial.entity.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
