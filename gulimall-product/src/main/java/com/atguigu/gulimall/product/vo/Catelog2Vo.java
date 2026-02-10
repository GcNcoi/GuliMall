package com.atguigu.gulimall.product.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2026年02月10日 17:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catelog2Vo {

    private String catalog1Id;

    private List<Catelog3Vo> catalog3List;

    private String id;

    private String name;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Catelog3Vo {

        private String catalog2Id;

        private String id;

        private String name;

    }

}
