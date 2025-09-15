package com.app.backend.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class DiaryRepositoryImplTest {

    @Autowired
    DiaryRepository diaryRepository;

//    @Test
//    @DisplayName("bulkInsert")
//    void bulkInsert() {
//        for (int i = 1; i <= 300; i++) {
//            Diary diary = Diary.builder()
//                    .title("더미 제목 " + i)
//                    .diaryContent("더미 내용 " + i)
//                    .date(LocalDate.now())
//                    .build();
//
//            diaryRepository.save(diary);
//        }
//    }

    //
//    @Test
//    @DisplayName("페이징 테스트")
//    void pagingTest() {
//        //given
//        int pageNo = 16;
//        int size = 20;
//        Pageable pageable = PageRequest.of(pageNo - 1, size);
//
//        //when
//        Slice<Diary> diarySlice = diaryRepository.findEvents(pageable);
//        List<Diary> content = diarySlice.getContent();
//
//        //then
//        System.out.println("hasNext: " + diarySlice.hasNext());
//        System.out.println("size: " + content.size());
//    }



}