package com.atguigu.gulimall.product.service;

import com.atguigu.gulimall.product.vo.AttrGroupRelationVo;
import com.atguigu.gulimall.product.vo.AttrGroupWithAttrsVo;
import com.atguigu.gulimall.product.vo.AttrRespVo;
import com.atguigu.gulimall.product.vo.AttrVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.AttrEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author Ggg
 * @email 2284467180@qq.com
 * @date 2025-12-17 16:50:59
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String type);

    AttrRespVo getAttrInfo(Long attrId);

    void updateAttr(AttrVo attr);

    List<AttrEntity> getRelationAttr(Long attrgroupId);

    void deleteRelation(AttrGroupRelationVo[] vos);

    /**
     * @description: 获取当前分组没有关联的所有属性
     * @author: Gxf
     * @date: 2025/12/30 16:43
     * @param:
     * @return:
     **/
    PageUtils getNoRelationAttr(Map<String, Object> params, Long attrgroupId);

    /**
     * @description: 在指定的所有属性集合里面，挑出检索属性
     * @author: Gxf
     * @date: 2026/2/5 17:48
     * @param: [attrIds]
     * @return: java.util.List<java.lang.Long>
     **/
    List<Long> selectSearchAttrsIds(List<Long> attrIds);
}

