package com.hhw.api.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "boardDetail")
public class BoardDetail {
    @Id
    private String id;

    @Column(name = "detail_text")
    private String detailText;

    // 게터, 세터, 생성자 등 필요한 코드 작성
}
