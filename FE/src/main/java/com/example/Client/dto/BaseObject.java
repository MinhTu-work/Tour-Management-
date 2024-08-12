package com.example.Client.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@MappedSuperclass
@Getter
@Setter
public class BaseObject implements Serializable {
}
