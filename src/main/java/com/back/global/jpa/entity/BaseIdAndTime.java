package com.back.global.jpa.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@MappedSuperclass
@Getter
public abstract class BaseIdAndTime extends BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime modifyDate;
}