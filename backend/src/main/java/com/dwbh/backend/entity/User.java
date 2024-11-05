package com.dwbh.backend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity @Getter
@DynamicInsert
@Table(name = "tb_user")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;
    private String userEmail;
    private String userPassword;
    private String userNickname;
    private String userGender;
    private LocalDateTime userBirthday;
    private String userMbti;
    private String userStatus;
    private String userTemperature;
    @CreatedDate
    private LocalDateTime userRegDate;
    private LocalDateTime userDelDate;

    // 패스워드 암호화
    public void encryptPassword(String encodedPwd) {
        this.userPassword = encodedPwd;
    }
}
