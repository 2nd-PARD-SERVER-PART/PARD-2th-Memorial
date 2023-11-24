package com.pard.memorial.service.image;

import com.pard.memorial.dto.response.ResponseDto;
import com.pard.memorial.entity.posting.Posting;
import com.pard.memorial.repsitory.posting.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final PostingRepository postingRepository;

    @Value("${user-file.directory.path}")
    private String UserFileDirPath;

    @Value("${server.api.url}")
    private String ApiUrl;

    public ResponseDto createImage(MultipartFile image, Long postingId){


        if(image.isEmpty()){
            return ResponseDto.setFailed("Image is empty.");
        }
        Posting posting;
        try{
            if(!postingRepository.existsById(postingId)){
                return ResponseDto.setFailed("Posting not found.");
            }
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
        String path = UserFileDirPath+"/"+postingId;

        File folderPath = new File(path);
        if(!folderPath.exists()){
            try{
                folderPath.mkdirs();
            } catch (Exception e){
                e.printStackTrace();
                return ResponseDto.setFailed("Failed to save file.");
            }
        }

        String filePath = path+"/image.jpeg";

        File saveFile = new File(filePath);



        try{
            image.transferTo(saveFile);
        } catch (IOException e){
            return ResponseDto.setFailed("Failed to save file.");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("Server Error");
        }

        return ResponseDto.setSuccess("Successfully create image.", ApiUrl+"/api/v1/image/"+postingId);

    }

    public ResponseEntity<byte[]> getImage(Long postingId){
        try{
            InputStream image = new FileInputStream(UserFileDirPath+"/"+postingId+"/image.jpeg");
            System.out.println(UserFileDirPath+"/"+postingId+"/image.jpeg");
            byte[] imageByteArray = IOUtils.toByteArray(image);
            image.close();
            return new ResponseEntity<byte[]>(imageByteArray, HttpStatus.OK);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
