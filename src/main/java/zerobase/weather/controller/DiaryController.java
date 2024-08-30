package zerobase.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zerobase.weather.dto.DiaryDTO;
import zerobase.weather.request.CreateDiaryRequest;
import zerobase.weather.request.ReadDiaryRequest;
import zerobase.weather.response.CreateDiaryResponse;
import zerobase.weather.response.ReadDiaryResponse;
import zerobase.weather.service.CreateDiaryService;
import zerobase.weather.service.ReadDiaryService;

@RestController
@RequiredArgsConstructor
public class DiaryController {

    private final CreateDiaryService createDiaryService;
    private final ReadDiaryService readDiaryService;

    @PostMapping("/create/diary")
    public CreateDiaryResponse createDiary(
            @RequestBody CreateDiaryRequest request) {

        DiaryDTO diaryDTO = createDiaryService.saveDiary(
                request.getWriteAt(),
                request.getCityName(),
                request.getContents()
        );
        return CreateDiaryResponse.builder()
                .id(diaryDTO.getId())
                .writeAt(diaryDTO.getWriteAt())
                .contents(diaryDTO.getContents())
                .weatherId(diaryDTO.getWeatherDTO().getId())
                .build();
    }

    @GetMapping("/read/diary")
    public ReadDiaryResponse readSingleDayDiary(
            @RequestBody ReadDiaryRequest.SingleDayRequest request) {

        return readDiaryService.findDiariesByDate(request.getWriteDate());
    }

    @GetMapping("/read/diaries")
    public ReadDiaryResponse readMultipleDayDiary(
            @RequestBody ReadDiaryRequest.MultiDayRequest request) {

        return readDiaryService.findDiariesByMultiDaya(
                request.getStartDate(), request.getEndDate());
    }
}
