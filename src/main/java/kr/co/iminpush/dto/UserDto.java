package kr.co.iminpush.dto;

import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String token;
    private String os_type;
    private int is_push;
    private String created_at;
    private String updated_at;
}
