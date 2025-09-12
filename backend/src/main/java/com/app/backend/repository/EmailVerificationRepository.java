package com.app.backend.repository;

import com.app.backend.domain.entity.EmailVerification;
import com.app.backend.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailVerificationRepository extends JpaRepository<EmailVerification, Long> {

    // 사용자의 ID를 통해 인증코드정보 조회
    Optional<EmailVerification> findByEventUser(User eventUser);
}
