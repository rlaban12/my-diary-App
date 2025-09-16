package com.app.backend.service;

import com.app.backend.domain.dto.request.DiaryCreate;
import com.app.backend.domain.dto.response.DiaryDetailResponse;
import com.app.backend.domain.dto.response.DiaryResponse;
import com.app.backend.domain.entity.Diary;
import com.app.backend.domain.entity.User;
import com.app.backend.repository.DiaryRepository;
import com.app.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;

    // 전체 조회
    @Transactional(readOnly = true)
    public Map<String, Object> getDiarys(int pageNo, String email) {

        User currentLoggedInUser = getCurrentLoggedInUser(email);

        Slice<Diary> diarySlice = diaryRepository.findDiarys(
                currentLoggedInUser.getUserId(),
                PageRequest.of(pageNo-1, 4)
        );

        List<DiaryResponse> diarys = diarySlice.getContent()
                .stream()
                .map(DiaryResponse::from)
                .collect(Collectors.toList());

        return Map.of(
                "hasNext", diarySlice.hasNext(),
                "diaryList", diarys
        );

    }

    // 일기 생성
    public void saveDiary(DiaryCreate dto, String email) {

        Diary diary = dto.toEntity();
        User foundUser = getCurrentLoggedInUser(email);
        diary.setUser(foundUser);

        diaryRepository.save(diary);

    }

    // 일기 단일 조회
    @Transactional(readOnly = true)
    public DiaryDetailResponse findOne(Long id) {

        Diary diary = diaryRepository.findById(id).orElseThrow();

        return DiaryDetailResponse.from(diary);

    }

    // 일기 삭제
    public void deleteDiary(Long id) {
        diaryRepository.deleteById(id);
    }

    // 일기 수정
    public void modifyDiary(DiaryCreate dto, Long id) {
        Diary diary = diaryRepository.findById(id).orElseThrow();
        diary.changeDiary(dto);

        diaryRepository.save(diary);
    }

    // 로그인한 사용자의 엔터티정보를 불러오는 메서드
    private User getCurrentLoggedInUser(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

}
