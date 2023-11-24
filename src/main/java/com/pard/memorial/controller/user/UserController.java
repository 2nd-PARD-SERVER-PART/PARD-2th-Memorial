package com.pard.memorial.controller.user;

import com.pard.memorial.dto.posting.response.PostingResponseDto;
import com.pard.memorial.dto.response.ResponseDto;
import com.pard.memorial.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{authorId}")
    public ResponseDto<List<PostingResponseDto>> getUser(@PathVariable String authorId){
        ResponseDto<List<PostingResponseDto>> result = userService.getUser(authorId);
        log.info("[Response getUser]");
        return result;
    }
}
