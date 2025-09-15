package com.app.backend.domain.dto.response;

import com.app.backend.domain.entity.Diary;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record DiaryDetailResponse(
        String id,
        String title,
        String desc,
        @JsonProperty("start-date")
        @JsonFormat(pattern = "yyyy년 MM월 dd일")
        LocalDate startDate
) {

    public static DiaryDetailResponse from(Diary diary) {
        return DiaryDetailResponse.builder()
                .id(diary.getDiaryId().toString())
                .title(diary.getTitle())
                .desc(diary.getDiaryContent())
                .startDate(diary.getDate())
                .startDate(diary.getDate())
                .build();
    }

}
