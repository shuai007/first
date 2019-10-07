package com.lening.service;

import com.lening.entity.GoodsBean;
import com.lening.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创作时间：2019/8/16 10:37
 * 作者：李增强
 */
@Service
public class GoodsService {
    @Resource
    GoodsMapper goodsMapper;

    public List<GoodsBean> getGoodsList() {
        return goodsMapper.getGoodsList();
    }
}
