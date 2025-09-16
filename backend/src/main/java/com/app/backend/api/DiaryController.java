package com.app.backend.api;

import com.app.backend.domain.dto.request.DiaryCreate;
import com.app.backend.domain.dto.response.DiaryDetailResponse;
import com.app.backend.service.DiaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/diarys")
@Slf4j
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    // 전체 조회 요청
    @GetMapping
    public ResponseEntity<?> getList(
            @RequestParam(defaultValue = "1") int page,
            @AuthenticationPrincipal String email
    ) {
        Map<String, Object> diarys = diaryService.getDiarys(page, email);

        return ResponseEntity.ok().body(diarys);
    }

    // 생성 요청
    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody DiaryCreate dto,
            @AuthenticationPrincipal String email
    ) {
        diaryService.saveDiary(dto, email);

        return ResponseEntity.ok().body(Map.of(
                "message", "일기가 정상 등록되었습니다."
        ));
    }

    // 단일 조회 요청
    @GetMapping("/{diaryId}")
    public ResponseEntity<?> getDiary(@PathVariable Long diaryId) {

        if (diaryId == null || diaryId < 1) {
            String errorMessage = "diaryId가 유효하지 않습니다.";
            log.warn(errorMessage);
            return ResponseEntity.badRequest()
                    .body(Map.of(
                            "message", errorMessage
                    ));
        }

        DiaryDetailResponse detailResponse = diaryService.findOne(diaryId);

        return ResponseEntity.ok().body(detailResponse);
    }

    // 삭제 요청
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDiary(
            @PathVariable Long id
    ) {
        diaryService.deleteDiary(id);

        return ResponseEntity.ok().body(Map.of(
                "message", "일기가 삭제되었습니다. id - " + id
        ));
    }

    // 수정 요청
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDiary(
            @PathVariable Long id
            , @RequestBody DiaryCreate dto
    ) {
        diaryService.modifyDiary(dto, id);

        return ResponseEntity.ok().body(Map.of(
                "message", "일기가 수정되었습니다. id - " + id
        ));
    }

}
