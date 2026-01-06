package com.atguigu.gulimall.ware.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2026年01月06日 16:20
 */
@Data
public class PurchaseDoneVo {

    @NotNull
    private Long id;

    private List<PurchaseItemDoneVo> items;

}
