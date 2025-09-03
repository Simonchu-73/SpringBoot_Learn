package com.xzit.mybatisX.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzit.mybatisX.model.Article;
import com.xzit.mybatisX.service.ArticleService;
import com.xzit.mybatisX.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

/**
* @author chu26
* @description 针对表【article】的数据库操作Service实现
* @createDate 2025-09-03 20:10:37
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{

}




