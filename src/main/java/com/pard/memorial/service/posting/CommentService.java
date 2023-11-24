package com.pard.memorial.service.posting;

import com.pard.memorial.dto.comment.requset.CommentRequestDto;
import com.pard.memorial.dto.posting.response.PostingResponseDto;
import com.pard.memorial.dto.response.ResponseDto;
import com.pard.memorial.entity.comment.Comment;
import com.pard.memorial.entity.posting.Posting;
import com.pard.memorial.repsitory.posting.CommentRepository;
import com.pard.memorial.repsitory.posting.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostingRepository postingRepository;

    public ResponseDto<PostingResponseDto> createComment(Long id, CommentRequestDto commentRequestDto){
        Posting posting;
        try{
            posting = postingRepository.findById(id).get();
        } catch (NoSuchElementException e){
            return ResponseDto.setFailed("Posting not found");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }

        Comment comment = new Comment(posting, commentRequestDto);

        try{
            commentRepository.save(comment);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }

        try{ //not good...
            posting = postingRepository.findById(id).get();
        } catch (NoSuchElementException e){
            return ResponseDto.setFailed("Posting not found");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }

        return ResponseDto.setSuccess("Successfully create comment.", new PostingResponseDto(posting));
    }
}
