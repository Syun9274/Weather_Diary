package zerobase.weather.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import zerobase.weather.service.ApiService;
import zerobase.weather.enums.ErrorCode;

class ApiExceptionTest {

    private final ApiService apiService = new ApiService();

    @Test
    public void testApiException() {
        ApiException exception = Assertions.assertThrows(ApiException.class, apiService::getApiKey);
        Assertions.assertEquals(ErrorCode.CANT_GET_API_KEY, exception.getErrorCode());
    }

}