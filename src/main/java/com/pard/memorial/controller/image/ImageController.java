package com.pard.memorial.controller.image;

import com.pard.memorial.dto.response.ResponseDto;
import com.pard.memorial.service.image.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ImageController {

    private final ImageService imageService;

    @Value("${user-file.directory.path}")
    private String UserFileDirPath;

    @PostMapping(value = "/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseDto createImage(@RequestBody MultipartFile multipartFile, @RequestParam Long postingId){
        ResponseDto result = imageService.createImage(multipartFile, postingId);
        log.info("[Response createImage]");
        return result;
    }

    @GetMapping(value = "/image/{postingId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable Long postingId){
        return imageService.getImage(postingId);
    }


}
