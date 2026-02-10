package com.atguigu.gulimall.product.dao;

import com.atguigu.common.constant.ProductConstant;
import com.atguigu.gulimall.product.entity.SpuInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * spu信息
 * 
 * @author Ggg
 * @email 2284467180@qq.com
 * @date 2025-12-17 16:50:59
 */
@Mapper
public interface SpuInfoDao extends BaseMapper<SpuInfoEntity> {

    void updateSpuStatus(@Param("spuId") Long spuId, @Param("code") Integer code);
}
