package kr.co.iminpush.dto;

import lombok.Data;

@Data
public class UserDto {
    int id;
    String token;
    String os_type;
    Boolean is_push;
    String created_at;
    String updated_at;
}
