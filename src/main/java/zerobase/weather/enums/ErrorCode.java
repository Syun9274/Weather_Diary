package zerobase.weather.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // ApiService
    CANT_GET_API_KEY("API KEY를 불러오는 과정에서 문제가 발생했습니다."),
    ERROR_API_RESPONSE("API 응답을 받아오는 과정에서 문제가 발생했습니다."),
    PARSE_FAIL_JSON("JSON파일을 파싱하는 과정에서 문제가 발생했습니다."),
    ERROR("ERROR"),
    ;

    private final String description;
}
