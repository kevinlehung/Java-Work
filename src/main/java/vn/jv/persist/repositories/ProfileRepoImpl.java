package vn.jv.persist.repositories;

import java.util.List;

import javax.persistence.Query;

import vn.jv.persist.BaseRepoImpl;
import vn.jv.persist.domain.Profile;

public class ProfileRepoImpl extends BaseRepoImpl implements ProfileCustomRepo<Profile, Integer> {

	public Profile findOneByUserId(int userId) {
		Query query = this.em.createQuery("SELECT p FROM Profile p WHERE p.user.userId = :userId", Profile.class)
								.setParameter("userId", userId).setMaxResults(1);
		
		@SuppressWarnings("unchecked")
		List<Profile> profiles = query.getResultList();
		
		if((profiles!= null) && (profiles.size() > 0)) {
			return profiles.get(0);
		}
		return null;
	}
}
