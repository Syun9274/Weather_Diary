package zerobase.weather.controller;

import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "일기를 생성하는 API",
            notes = "일기 작성 날짜, 도시 이름, 일기 내용을 RequestBody로 받습니다.")
    @PostMapping("/create/diary")
    public CreateDiaryResponse createDiary(
            @RequestBody CreateDiaryRequest request) {

        return CreateDiaryResponse.from(
                createDiaryService.saveDiary(
                        request.getWriteAt(),
                        request.getCityName(),
                        request.getContents()));
    }

    @ApiOperation("선택한 날짜에 작성한 일기를 불러오는 API")
    @GetMapping("/read/diary")
    public ReadDiaryResponse readSingleDayDiary(
            @RequestBody ReadDiaryRequest.SingleDayRequest request) {

        return readDiaryService.findDiariesByDate(request.getWriteDate());
    }

    @ApiOperation("선택한 기간에 작성한 일기를 불러오는 API")
    @GetMapping("/read/diaries")
    public ReadDiaryResponse readMultipleDayDiary(
            @RequestBody ReadDiaryRequest.MultiDayRequest request) {

        return readDiaryService.findDiariesByMultiDay(
                request.getStartDate(), request.getEndDate());
    }

    @ApiOperation("선택한 날짜에 작성한 첫 번쨰 일기의 내용을 수정하는 API")
    @PutMapping("/update/diary")
    public UpdateDiaryResponse updateDiary(
            @RequestBody UpdateDiaryRequest request) {

        return UpdateDiaryResponse.from(
                updateDiaryService.updateDiary(
                        request.getWriteAt(),
                        request.getContents()));
    }

    @ApiOperation("선택한 날짜에 작성된 모든 일기를 삭제하는 API")
    @DeleteMapping("/delete/diary")
    public DeleteDiaryResponse deleteDiary(
            @RequestBody DeleteDiaryRequest request) {

        return DeleteDiaryResponse.fromEntityList(
                deleteDiaryService.deleteDiary(request.getWriteAt()));
    }
}
