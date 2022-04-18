package grad.design.mapper;

import grad.design.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     *  用户登录查询信息
     * @param name
     * @return
     */
    User findByUsername(String name);

    User findById(int id);

    int addUser(User userInfo);
}
