package zerobase.weather.exception;

import lombok.*;
import zerobase.weather.enums.ErrorCode;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiaryException extends RuntimeException {

    private ErrorCode errorCode;
    private String description;

    public DiaryException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.description = errorCode.getDescription();
    }
}
