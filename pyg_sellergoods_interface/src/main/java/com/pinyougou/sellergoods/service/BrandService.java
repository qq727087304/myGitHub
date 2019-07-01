package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;

import java.util.List;

/**
 * 功能描述:
 *
 * @ClassName: BrandService
 * @Author: Lhy、
 * @Date: 2019/6/30 20:42
 * @Version: V1.0
 */
public interface BrandService {
    List<TbBrand> findAll();
    void update(TbBrand tbBrand);
    void save (TbBrand tbBrand);
    TbBrand findById(long id);
    void delete(long id);
}
