package com.dwbh.backend.entity;

import com.dwbh.backend.common.entity.YnType;
import com.dwbh.backend.common.util.DateTimeUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity @Getter
@Table(name = "tb_chat")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat {

    @Id @Column(name = "chat_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatSeq;

    @Column(name = "counsel_offer_seq")
    private Long counselOfferSeq;

    @Column(name = "chat_send_seq")
    private Long sendSeq;

    @Column(name = "chat_receive_seq")
    private Long receiveSeq;

    @CreationTimestamp
    @Column(name = "chat_reg_date", updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime regDate;

    @Column(name = "chat_del_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime delDate;

    @Column(name = "chat_read_yn")
    @Enumerated(EnumType.STRING)
    private YnType readYn = YnType.N;

    public void parseDate(String delDate) {
        this.delDate = DateTimeUtil.parse(delDate, "yyyy-MM-dd HH:mm:ss");
    }

}
