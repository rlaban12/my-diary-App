package com.app.backend.repository;

import com.app.backend.domain.entity.Diary;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
public class DiaryRepositoryImpl {

    private final JPAQueryFactory factory;

    public Slice<Diary> findDiarys(Long userId, Pageable pageable) {

        /*
            총 데이터 수 23개, 한번에 가져올 데이터 5개
            1회차 로딩 - 5개
            2회차 로딩 - 5개
            3회차 로딩 - 5개
            4회차 로딩 - 5개
            5회차 로딩 - 3개

            서버는 클라이언트에게 그만요청하라는 표시를 전달해야함

            서버가 데이터의 끝을 확인하는 방법
            1. 실제로 가져갈 데이터보다 1개 더 조회해본다.

            총 데이터 수 23개, 한번에 가져올 데이터 5개
            1회차 로딩 - 6개 -> 리턴 5개 -> 남은데이터 18개
            2회차 로딩 - 6개 -> 리턴 5개 -> 남은데이터 13개
            3회차 로딩 - 6개 -> 리턴 5개 -> 남은데이터 8개
            4회차 로딩 - 6개 -> 리턴 5개 -> 남은데이터 3개
            5회차 로딩 - 6개 -> 실제로 3개만 보임 -> 끝이구나 (6개이하로 나오면)
         */

        return new SliceImpl<>();

    }


}
