package kr.co.iminpush.mappers;

import kr.co.iminpush.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import kr.co.iminpush.mappers.UserMapper;

@Mapper
public interface UserMapper {
    List<UserDto> getUser();
}
