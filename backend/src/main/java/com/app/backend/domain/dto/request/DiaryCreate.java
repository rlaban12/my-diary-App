package com.app.backend.domain.dto.request;

import com.app.backend.domain.entity.Diary;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record DiaryCreate (
        String title,
        String diaryContent,
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate beginDate
) {
    public Diary toEntity() {
        return Diary.builder()
                .title(this.title)
                .diaryContent(this.diaryContent)
                .date(this.beginDate)
                .build();
    }
}
