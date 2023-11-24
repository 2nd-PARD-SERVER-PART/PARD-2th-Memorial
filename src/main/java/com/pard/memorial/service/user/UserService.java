package com.pard.memorial.service.user;

import com.pard.memorial.dto.posting.response.PostingResponseDto;
import com.pard.memorial.dto.response.ResponseDto;
import com.pard.memorial.entity.posting.Posting;
import com.pard.memorial.repsitory.posting.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PostingRepository postingRepository;

    public ResponseDto<List<PostingResponseDto>> getUser(String authorId){
        List<Posting> postingList;
        try{
            postingList = postingRepository.findAllByAuthorId(authorId);
        } catch (NoSuchElementException e){
            return ResponseDto.setFailed("Posting not found");
        } catch (Exception e){
            return ResponseDto.setFailed("DB Error");
        }

        List<PostingResponseDto> result = postingList.stream()
                .map(PostingResponseDto::new)
                .collect(Collectors.toList());

        return ResponseDto.setSuccess("Successfully get user.", result);
    }
}
