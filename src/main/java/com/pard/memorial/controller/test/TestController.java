package com.pard.memorial.controller.test;

import com.pard.memorial.dto.response.ResponseDto;
import com.pard.memorial.dto.test.DateTestDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/test")
public class TestController {

    @PostMapping("/date")
    public ResponseDto<DateTestDto> dateTest(@RequestBody DateTestDto dto){
        return ResponseDto.setSuccess("good", dto);
    }
}
