package daotest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.myproject.dao.GetUserDao;
import org.myproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserTest {

	@Autowired
	GetUserDao getUserDao;

	@Test
	public void test() {
		User user=getUserDao.getUser(1);
		System.out.println(user.getUserId());
		System.out.println(user.getUserName());
		System.out.println(user.getUserPassword());
		System.out.println(user.getAge());
	}

}
