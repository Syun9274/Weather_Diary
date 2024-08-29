package zerobase.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zerobase.weather.dto.DiaryDTO;
import zerobase.weather.request_response.CreateDiary;
import zerobase.weather.service.CreateDiaryService;

@RestController
@RequiredArgsConstructor
public class DiaryController {

    private final CreateDiaryService createDiaryService;

    @PostMapping("/create/diary")
    public ResponseEntity<DiaryDTO> createDiary(
            @RequestBody CreateDiary.Request request) {

        DiaryDTO diaryDTO = createDiaryService.saveDiary(
                request.getWriteAt(),
                request.getCityName(),
                request.getContents()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(diaryDTO);

    }
}
