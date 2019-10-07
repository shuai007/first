package com.lening.controller;

import com.lening.entity.GoodsBean;
import com.lening.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创作时间：2019/8/16 10:36
 * 作者：李增强
 */
@Controller
public class GoodsController {
    @Resource
    GoodsService goodsService;

    @RequestMapping("/getGoodsList")
    public ModelAndView getGoodsList(){
        ModelAndView mv = new ModelAndView("goods/goods_list");
        List<GoodsBean> list = goodsService.getGoodsList();
        mv.addObject("list", list);
        return mv;
    }

}
