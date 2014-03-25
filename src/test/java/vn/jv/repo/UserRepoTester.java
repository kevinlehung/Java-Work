package vn.jv.repo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import vn.jv.BaseTester;
import vn.jv.persist.domain.User;
import vn.jv.persist.repositories.UserRepo;

/**
 *
 * @author hunglevn@outlook.com
 *
 */
public class UserRepoTester extends BaseTester {

	@Autowired@Qualifier("userRepo")
	UserRepo userRepo;
	
	@Test
	public void test() {
		userRepo.save(new User());
	}
	
}