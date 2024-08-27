package zerobase.weather.exception;

import lombok.*;
import zerobase.weather.enums.ErrorCode;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiException extends RuntimeException {

    private ErrorCode errorCode;
    private String description;

    public ApiException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.description = errorCode.getDescription();
    }

}
