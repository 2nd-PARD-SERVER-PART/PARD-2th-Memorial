package com.pard.memorial.controller.posting;

import com.pard.memorial.dto.posting.request.PostingRequestDto;
import com.pard.memorial.dto.posting.response.PostingResponseDto;
import com.pard.memorial.dto.response.ResponseDto;
import com.pard.memorial.service.posting.PostingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PostingController {

    private final PostingService postingService;

    @PostMapping("/posting")
    public ResponseDto<PostingResponseDto> createPosting(@RequestBody PostingRequestDto postingRequestDto){
        ResponseDto<PostingResponseDto> result = postingService.createPosting(postingRequestDto);
        log.info("[Response createPosting]");
        return result;
    }

    @GetMapping("/posting/{id}")
    public ResponseDto<PostingResponseDto> getPosting(@PathVariable Long id){
        ResponseDto<PostingResponseDto> result = postingService.getPosting(id);
        log.info("[Response getPosting]");
        return result;
    }

    @PatchMapping("/posting/{id}")
    public ResponseDto<PostingResponseDto> updatePosting(@PathVariable Long id, @RequestBody PostingRequestDto postingRequestDto){
        ResponseDto<PostingResponseDto> result = postingService.updatePosting(id, postingRequestDto);
        log.info("[Response updatePosting]");
        return result;
    }

    @DeleteMapping("/posting/{id}")
    public ResponseDto<?> deletePosting(@PathVariable Long id, @RequestParam String authorId){
        ResponseDto<?> result = postingService.deletePosting(id, authorId);
        log.info("[Response deletePosting]");
        return result;
    }
}
