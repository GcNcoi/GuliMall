package com.atguigu.gulimall.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2026年01月06日 15:03
 */
@Data
public class MergeVo {
    /**
     * 采购单id
     */
    private Long purchaseId;
    /**
     * 采购单中选中的项
     */
    private List<Long> items;
}
