package zerobase.weather.response;

import lombok.*;
import zerobase.weather.dto.DiaryDTO;
import zerobase.weather.entity.Diary;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteDiaryResponse {

    private List<DiaryDTO> diaryList;

    public static DeleteDiaryResponse fromEntityList(List<Diary> diaries) {
        List<DiaryDTO> diaryDTOList = diaries.stream()
                .map(DiaryDTO::fromEntityList)
                .collect(Collectors.toList());
        return new DeleteDiaryResponse(diaryDTOList);
    }
}
