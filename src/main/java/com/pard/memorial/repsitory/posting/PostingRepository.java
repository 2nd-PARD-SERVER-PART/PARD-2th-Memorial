package com.pard.memorial.repsitory.posting;

import com.pard.memorial.entity.posting.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostingRepository extends JpaRepository<Posting, Long> {
    List<Posting> findAllByAuthorId(String authorId);
}
