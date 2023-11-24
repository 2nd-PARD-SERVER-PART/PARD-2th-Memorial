package com.pard.memorial.controller.posting;

import com.pard.memorial.dto.comment.requset.CommentRequestDto;
import com.pard.memorial.dto.posting.response.PostingResponseDto;
import com.pard.memorial.dto.response.ResponseDto;
import com.pard.memorial.service.posting.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/posting/{id}/comment")
    public ResponseDto<PostingResponseDto> createComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto){
        ResponseDto<PostingResponseDto> result = commentService.createComment(id, commentRequestDto);
        log.info("[Response createComment]");
        return result;
    }

}
