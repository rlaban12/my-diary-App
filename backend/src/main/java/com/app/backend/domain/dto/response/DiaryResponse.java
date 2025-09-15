package com.app.backend.domain.dto.response;

import com.app.backend.domain.entity.Diary;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record DiaryResponse (
        String diaryId,
        String title,
        @JsonFormat(pattern = "yyyy년 MM월 dd일")
        LocalDate startDate
){

    // 엔터티를 DTO로 바꿔주는 편의 메서드
    public static DiaryResponse from(Diary diary) {
        return DiaryResponse.builder()
                .diaryId(diary.getDiaryId().toString())
                .title(diary.getTitle())
                .startDate(diary.getDate())
                .build();
    }

}
