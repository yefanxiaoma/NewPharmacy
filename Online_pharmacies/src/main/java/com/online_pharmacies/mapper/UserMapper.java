package com.online_pharmacies.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Wang
 * @since 2024-09-12
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User selectUserno(String userno);

    User selectAdminno(String userno);

    List<User> listPersonal(Integer userId);

    IPage<User> paging(IPage<User> page, @Param(Constants.WRAPPER) Wrapper<User> wrapper);
}
