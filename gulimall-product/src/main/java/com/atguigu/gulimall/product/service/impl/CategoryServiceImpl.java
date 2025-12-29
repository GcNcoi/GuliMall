package com.atguigu.gulimall.product.service.impl;

import com.atguigu.gulimall.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 1. 查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
        // 2. 组装成树形结构
        // 2.1 找到所有一级分类
        List<CategoryEntity> level1Categories = entities.stream()
                .filter(entity -> entity.getParentCid() == 0)
                .map((menu) -> {
                    menu.setChildren(getChildren(menu, entities));
                    return menu;
                })
                .sorted((menu1, menu2) -> {
                    return menu1.getSort() == null ? 0 : menu1.getSort() - (menu2.getSort() == null ? 0 : menu2.getSort());
                })
                .collect(Collectors.toList());

        return level1Categories;
    }

    @Override
    public void removeMenuByIds(List<Long> list) {
        //TODO 1. 检查当前删除的分类下是否有子分类
        baseMapper.deleteBatchIds(list);
    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> paths = new ArrayList<>();
        // 1. 从当前分类开始，向上查找，直到找到一级分类
        CategoryEntity category = getById(catelogId);
        while (category.getParentCid() != 0) {
            paths.add(category.getCatId());
            category = getById(category.getParentCid());
        }
        paths.add(category.getCatId());
        // 2. 反转路径
        Collections.reverse(paths);
        return paths.toArray(new Long[paths.size()]);
    }

    @Override
    @Transactional
    public void updateDetail(CategoryEntity category) {
        // 1. 更新分类
        updateById(category);
        // 2. 更新关联的品牌分类关联表
        categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());
    }

    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        return all.stream()
                .filter(entity -> entity.getParentCid().equals(root.getCatId()))
                .map((menu) -> {
                    menu.setChildren(getChildren(menu, all));
                    return menu;
                })
                .sorted((menu1, menu2) -> {
                    return menu1.getSort() == null ? 0 : menu1.getSort() - (menu2.getSort() == null ? 0 : menu2.getSort());
                })
                .collect(Collectors.toList());
    }

}