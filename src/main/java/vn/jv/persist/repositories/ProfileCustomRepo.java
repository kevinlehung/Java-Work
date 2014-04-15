package vn.jv.persist.repositories;

public interface ProfileCustomRepo<Profile, Integer> {

	public Profile findOneByUserId(int userId);
}
