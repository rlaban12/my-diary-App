package com.app.backend.domain.entity;

import com.app.backend.domain.dto.request.DiaryCreate;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@ToString(exclude = {"user"})
@EqualsAndHashCode(of = "diaryId")
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "diary")

public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_id")
    private Long diaryId;

    @CreationTimestamp
    private LocalDateTime createdAt; // 이벤트 등록 날짜

    @Column(name = "write_start_date")
    private LocalDate date; // 일기 작성 날짜

    @Column(name = "diary_title", nullable = false, length = 50)
    private String title; // 일기 제목

    @Column(name = "diary_content")
    private String diaryContent; // 일기 내용

    // 회원과 연관관계를 성정 - 단방향 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Setter
    private User user;

    // 수정 편의 메서드
    public void changeDiary(DiaryCreate dto) {
        this.title = dto.title();
        this.diaryContent = dto.diaryContent();
        this.date = dto.beginDate();
    }

}
