package zerobase.weather.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zerobase.weather.dto.DiaryDTO;
import zerobase.weather.entity.Diary;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReadDiaryResponse {

    private List<DiaryDTO> diaryList;

    public static ReadDiaryResponse fromEntityList(List<Diary> diaries) {
        List<DiaryDTO> diaryDTOList = diaries.stream()
                .map(DiaryDTO::fromEntityList)
                .collect(Collectors.toList());
        return new ReadDiaryResponse(diaryDTOList);
    }


}