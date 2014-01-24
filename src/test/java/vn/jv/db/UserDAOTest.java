package vn.jv.db;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import vn.jv.persist.domain.User;
import vn.jv.persist.repositories.IUserRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/dao-config.xml")
public class UserDAOTest {

	@Autowired
	IUserRepo userRepo;
	
	@Test
	public void test() {
		try {
			List<User> users = userRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
