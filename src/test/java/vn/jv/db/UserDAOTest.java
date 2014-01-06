package vn.jv.db;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import vn.jv.db.dao.UserDAO;
import vn.jv.db.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/dao-config.xml")
public class UserDAOTest {

	@Autowired
	UserDAO userDAO;
	
	@Test
	public void test() {
		try {
			List<User> users = userDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
