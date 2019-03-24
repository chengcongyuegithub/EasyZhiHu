package com.ccy.easyzhihu;


import com.ccy.easyzhihu.Dao.UserDAO;
import com.ccy.easyzhihu.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IniT_DataBaseTest {

	@Autowired
	UserDAO userDAO;

	@Test
	public void contextLoads() {
        Random random=new Random();
        for(int i=0;i<11;i++)
		{
			User user = new User();
			user.setId(i+1);
			//user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
			//user.setName(String.format("USER%d", i));
			//user.setPassword("");
			//user.setSalt("");
			//添加
			//userDAO.addUser(user);
		    //修改
			user.setPassword("newpassword");
			userDAO.updatePassword(user);
		}
	}

}
