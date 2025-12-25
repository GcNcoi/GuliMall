package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author Ggg
 * @email 2284467180@qq.com
 * @date 2025-12-18 10:31:11
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
