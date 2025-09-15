package com.app.backend.repository;

import com.app.backend.domain.entity.Diary;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface DiaryRepositoryCustom {
    // 이벤트 목록조회 페이징처리 (무한스크롤 전용)
    Slice<Diary> findDiarys(Long userId, Pageable pageable);
}
