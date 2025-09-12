package com.app.backend.repository;

import com.app.backend.domain.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long>,  DiaryRepositoryCustom{
}
