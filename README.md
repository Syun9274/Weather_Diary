# 날씨 일기 백엔드 API
> **날씨, 일기를 작성 / 조회 / 수정하는 백엔드**

---

## Stack

![Java](https://img.shields.io/badge/Java-007396?logo=java&logoColor=white&style=for-the-badge)

![Gradle](https://img.shields.io/badge/Gradle-02303A?logo=gradle&logoColor=white&style=for-the-badge)

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=spring-boot&logoColor=white&style=for-the-badge)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?logo=spring&logoColor=white&style=for-the-badge)

![Lombok](https://img.shields.io/badge/Lombok-FF6347?logo=lombok&logoColor=white&style=for-the-badge)

![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white&style=for-the-badge)

![Swagger](https://img.shields.io/badge/Swagger-85EA2D?logo=swagger&logoColor=black&style=for-the-badge)

---

# 📚 Diary API Documentation

## 최종 구현 API 리스트

### ✅ **POST /create/diary**
- **설명**: 새로운 일기를 생성하고 저장합니다.
- **파라미터**:
    - `date` (형식: `yyyy-MM-dd`): 날짜를 받아옵니다.
    - `text` (형식: `string`): 도시 이름을 받아옵니다.
    - `text` (형식: `string`): 일기 내용을 받아옵니다.
- **기능**: 외부 API에서 받아온 날씨 데이터를 함께 DB에 저장합니다.

### ✅ **GET /read/diary**
- **설명**: 특정 날짜의 일기를 조회합니다.
- **파라미터**:
    - `date` (형식: `yyyy-MM-dd`): 조회할 날짜를 받아옵니다.
- **기능**: 해당 날짜의 일기를 `List` 형태로 반환합니다.

### ✅ **GET /read/diaries**
- **설명**: 기간 내의 일기 목록을 조회합니다.
- **파라미터**:
    - `startDate` (형식: `yyyy-MM-dd`): 조회할 기간의 시작일.
    - `endDate` (형식: `yyyy-MM-dd`): 조회할 기간의 종료일.
- **기능**: 해당 기간의 일기를 `List` 형태로 반환합니다.

### ✅ **PUT /update/diary**
- **설명**: 특정 날짜의 일기를 수정합니다.
- **파라미터**:
    - `date` (형식: `yyyy-MM-dd`): 수정할 날짜를 받아옵니다.
    - `text` (형식: `string`): 수정할 새 일기 내용을 받아옵니다.
- **기능**: 해당 날짜의 첫 번째 일기 글을 새로운 내용으로 수정합니다.

### ✅ **DELETE /delete/diary**
- **설명**: 특정 날짜의 모든 일기를 삭제합니다.
- **파라미터**:
    - `date` (형식: `yyyy-MM-dd`): 삭제할 날짜를 받아옵니다.
- **기능**: 해당 날짜의 모든 일기를 삭제합니다.

---

## 📈 프로젝트 완성도를 높이기 위한 작업

✅ **DB**와 관련된 함수들은 트랜잭션 처리

✅ 매일 새벽 1시에 날씨 데이터를 외부 API에서 받아와 **DB**에 저장해두는 로직 구현

✅ **logback**을 이용하여 프로젝트에 로그 남기기

✅ **ExceptionHandler**를 이용한 예외처리

✅ **swagger**을 이용하여 **API documentation**하기

---

## 🌐 사용하는 사이트

✅ **[Open Weather Map API](https://openweathermap.org/)**
- 날씨 데이터를 얻어오는데에 사용
