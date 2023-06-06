package com.hhw.api.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "boardDetail")
public class BoardDetail {
    @Id
    private Integer id;

    @Column(name = "detail_text")
    private String detailText;

    // 게터, 세터, 생성자 등 필요한 코드 작성
}
