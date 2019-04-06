package com.ccy.easyzhihu.controller;

import com.ccy.easyzhihu.Dao.QuestionDAO;
import com.ccy.easyzhihu.Service.QuestionService;
import com.ccy.easyzhihu.model.HostHolder;
import com.ccy.easyzhihu.model.Question;
import com.ccy.easyzhihu.util.ZhiHuUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author chengcongyue
 * @version 1.0
 * @description com.ccy.easyzhihu.controller
 * @date 2019/4/3
 */
@Controller
public class QuestionController {

    private static final Logger logger= LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    private HostHolder hostHolder;
    @Autowired
    private QuestionService questionService;

    @RequestMapping(path = {"/question/add"},method = RequestMethod.POST)
    @ResponseBody
    public String addQuestion(@RequestParam("title")String title,@RequestParam("content")String content)
    {
        try {
           Question question=new Question();
           question.setContent(content);
           question.setCreatedDate(new Date());
           question.setTitle(title);
           if(hostHolder.getUser()==null)
           {
               question.setUserId(ZhiHuUtil.ANONYMOUS_USERID);
           }else
           {
               question.setUserId(hostHolder.getUser().getId());
           }
           if(questionService.addQuestion(question)>0)
           {
               return ZhiHuUtil.getObjectJson(0);
           }
        }catch (Exception e)
        {
             logger.error("增加题目失败"+e.getMessage());
        }
        return ZhiHuUtil.getJSONString(1,"失败");
    }
}
