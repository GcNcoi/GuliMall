package com.atguigu.gulimall.ware.vo;

import lombok.Data;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2026年01月06日 16:21
 */
@Data
public class PurchaseItemDoneVo {

    private Long itemId;

    private Integer status;

    private String reason;

}
