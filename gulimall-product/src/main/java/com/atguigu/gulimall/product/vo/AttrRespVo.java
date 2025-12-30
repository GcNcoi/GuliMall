package com.atguigu.gulimall.product.vo;

import lombok.Data;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年12月30日 11:30
 */
@Data
public class AttrRespVo extends AttrVo {

    /**
     * 所属分类名称
     */
    private String catelogName;

     /**
      * 所属分组名称
      */
    private String groupName;

     /**
      * 分类完整路径
      */
    private Long[] catelogPath;

}
