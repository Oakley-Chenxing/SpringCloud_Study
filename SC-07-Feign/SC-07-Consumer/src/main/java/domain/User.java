package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName User
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 10/02/2023 15:29
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {
    private String name;
    private Integer age;
}

