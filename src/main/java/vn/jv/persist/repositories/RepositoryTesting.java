package vn.jv.persist.repositories;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class RepositoryTesting {
	public static void main(String args[]) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(RepoConfig.class);
		IUserRepo userRepo = ctx.getBean(IUserRepo.class);
		System.out.println(userRepo.findByUserEmail("kevin.le.hung@clearpathdevelopment.com").getUserPassword());
	}
}
