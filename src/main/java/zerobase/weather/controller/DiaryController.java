package zerobase.weather.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zerobase.weather.dto.CreateDiary;

@RestController
public class DiaryController {

    @PostMapping("/create/diary")
    public void createDiary(
            @RequestBody CreateDiary.Request request) {

    }
}
