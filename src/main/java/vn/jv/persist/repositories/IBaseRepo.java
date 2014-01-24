package vn.jv.persist.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBaseRepo<T, ID extends Serializable> extends JpaRepository<T, ID>{

}
