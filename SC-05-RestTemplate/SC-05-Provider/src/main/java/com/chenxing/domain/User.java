package com.chenxing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName User
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 09/02/2023 20:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String name;
    private Integer age;
}
