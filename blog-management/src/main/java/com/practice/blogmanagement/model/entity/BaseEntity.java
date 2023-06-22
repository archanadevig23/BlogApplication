package com.practice.blogmanagement.model.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;

public class BaseEntity {

    @Id
    String id;

    @Builder.Default
    boolean active = true;

}
