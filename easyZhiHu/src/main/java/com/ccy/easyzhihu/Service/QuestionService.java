package com.ccy.easyzhihu.Service;

import com.ccy.easyzhihu.Dao.QuestionDAO;
import com.ccy.easyzhihu.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chengcongyue
 * @version 1.0
 * @description com.ccy.easyzhihu.Service
 * @date 2019/3/27
 */
@Service
public class QuestionService {
     @Autowired
     QuestionDAO questionDAO;


     public List<Question> getSelectLatestQuestions(int userId,int offset,int limit)
     {
          return questionDAO.selectLatestQuestions(userId,offset,limit); }
}
