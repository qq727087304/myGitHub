package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * 功能描述:
 *
 * @ClassName: BrandController
 * @Author: Lhy、
 * @Date: 2019/6/30 20:41
 * @Version: V1.0
 */
@RestController
@RequestMapping("brand")
public class BrandController {
    @Reference
    private BrandService brandService;
    @RequestMapping("list")
    @ResponseBody
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }
    @RequestMapping("save")
    public void save(TbBrand tbBrand){
        edit(tbBrand);
    }
    public void edit(TbBrand tbBrand){
        Random rd=new Random();
        if(tbBrand.getId()==null){
            tbBrand.setId(rd.nextLong()+99999);
            tbBrand.setFirstChar("H");
            tbBrand.setName("字节跳动");
            brandService.save(tbBrand);
        }else{
            tbBrand.setName("今日头条");
            tbBrand.setFirstChar("D");
            brandService.update(tbBrand);
        }
    }
    @RequestMapping("update")
    public void  update(){
        TbBrand tbBrand = brandService.findById(26l);
        edit(tbBrand);
    }
    @RequestMapping("delete")
    public void delete(){
        brandService.delete(26l);
    }
}
