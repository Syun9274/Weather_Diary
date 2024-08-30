package zerobase.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import zerobase.weather.request.CreateDiaryRequest;
import zerobase.weather.request.DeleteDiaryRequest;
import zerobase.weather.request.ReadDiaryRequest;
import zerobase.weather.request.UpdateDiaryRequest;
import zerobase.weather.response.CreateDiaryResponse;
import zerobase.weather.response.DeleteDiaryResponse;
import zerobase.weather.response.ReadDiaryResponse;
import zerobase.weather.response.UpdateDiaryResponse;
import zerobase.weather.service.CreateDiaryService;
import zerobase.weather.service.DeleteDiaryService;
import zerobase.weather.service.ReadDiaryService;
import zerobase.weather.service.UpdateDiaryService;

@RestController
@RequiredArgsConstructor
public class DiaryController {

    private final CreateDiaryService createDiaryService;
    private final ReadDiaryService readDiaryService;
    private final UpdateDiaryService updateDiaryService;
    private final DeleteDiaryService deleteDiaryService;

    @PostMapping("/create/diary")
    public CreateDiaryResponse createDiary(
            @RequestBody CreateDiaryRequest request) {

        return CreateDiaryResponse.from(
                createDiaryService.saveDiary(
                        request.getWriteAt(),
                        request.getCityName(),
                        request.getContents()));
    }

    @GetMapping("/read/diary")
    public ReadDiaryResponse readSingleDayDiary(
            @RequestBody ReadDiaryRequest.SingleDayRequest request) {

        return readDiaryService.findDiariesByDate(request.getWriteDate());
    }

    @GetMapping("/read/diaries")
    public ReadDiaryResponse readMultipleDayDiary(
            @RequestBody ReadDiaryRequest.MultiDayRequest request) {

        return readDiaryService.findDiariesByMultiDay(
                request.getStartDate(), request.getEndDate());
    }

    @PutMapping("/update/diary")
    public UpdateDiaryResponse updateDiary(
            @RequestBody UpdateDiaryRequest request) {

        return UpdateDiaryResponse.from(
                updateDiaryService.updateDiary(
                        request.getWriteAt(),
                        request.getContents()));
    }

    @DeleteMapping("/delete/diary")
    public DeleteDiaryResponse deleteDiary(
            @RequestBody DeleteDiaryRequest request) {

        return DeleteDiaryResponse.fromEntityList(
                deleteDiaryService.deleteDiary(request.getWriteAt()));
    }
}
