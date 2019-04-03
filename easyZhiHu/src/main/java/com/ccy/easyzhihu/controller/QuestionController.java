package com.ccy.easyzhihu.controller;

import com.ccy.easyzhihu.Dao.QuestionDAO;
import com.ccy.easyzhihu.model.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chengcongyue
 * @version 1.0
 * @description com.ccy.easyzhihu.controller
 * @date 2019/4/3
 */
@Controller
public class QuestionController {

    @Autowired
    private HostHolder hostHolder;
    @Autowired
    private QuestionDAO questionDAO;

    @RequestMapping(path = {"/question/add"},method = RequestMethod.POST)
    @ResponseBody
    public String addQuestion()
    {

        return null;
    }
}
