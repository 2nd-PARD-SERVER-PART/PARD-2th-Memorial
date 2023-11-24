package com.pard.memorial.service.posting;

import com.pard.memorial.dto.posting.request.PostingRequestDto;
import com.pard.memorial.dto.posting.response.PostingResponseDto;
import com.pard.memorial.dto.response.ResponseDto;
import com.pard.memorial.entity.posting.Posting;
import com.pard.memorial.repsitory.posting.PostingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;

    public ResponseDto<PostingResponseDto> createPosting(PostingRequestDto postingRequestDto){
        Posting posting = new Posting(postingRequestDto);
        try{
            postingRepository.save(posting);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
        return ResponseDto.setSuccess("Successfully create posting.", new PostingResponseDto(posting));
    }

    public ResponseDto<List<PostingResponseDto>> getAllPosting(){
        List<Posting> postingList;
        try{
            postingList = postingRepository.findAll();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }

        List<PostingResponseDto> result = postingList.stream()
                .map(PostingResponseDto::new)
                .collect(Collectors.toList());

        return ResponseDto.setSuccess("Successfully get all posting.", result);
    }

    public ResponseDto<PostingResponseDto> getPosting(Long id){
        Posting posting;
        try {
            posting = postingRepository.findById(id).get();
        } catch (NoSuchElementException e){
            return ResponseDto.setFailed("Posting not found.");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }
        return ResponseDto.setSuccess("Successfully get posting.", new PostingResponseDto(posting));
    }

    @Transactional
    public ResponseDto<PostingResponseDto> updatePosting(Long id, PostingRequestDto postingRequestDto){
        Posting posting;
        try{
            posting = postingRepository.findById(id).get();
        } catch (NoSuchElementException e){
            return ResponseDto.setFailed("Posting not found");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }

        if(!posting.getAuthorId().equals(postingRequestDto.getAuthorId())){
            return ResponseDto.setFailed("User not match.");
        }

        if(postingRequestDto.getTitle() != null && !postingRequestDto.getTitle().isEmpty()){
            posting.setTitle(postingRequestDto.getTitle());
        }
        if(postingRequestDto.getContent() != null && !postingRequestDto.getContent().isEmpty()){
            posting.setContent(postingRequestDto.getContent());
        }
        if(postingRequestDto.getStartDate() != null && !postingRequestDto.getStartDate().isEmpty()){
            posting.setStartDate(postingRequestDto.getStartDate());
        }

        return ResponseDto.setSuccess("Successfully update posting.", new PostingResponseDto(posting));
    }

    public ResponseDto<?> deletePosting(Long id, String authorId){
        Posting posting;
        try{
            posting = postingRepository.findById(id).get();
        } catch (NoSuchElementException e){
            return ResponseDto.setFailed("Posting not found.");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }

        if(!posting.getAuthorId().equals(authorId)){
            return ResponseDto.setFailed("User not match.");
        }

        try{
            postingRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB Error");
        }

        return ResponseDto.setSuccess("Successfully delete posting.", null);
    }
}
