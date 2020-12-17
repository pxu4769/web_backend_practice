package dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public interface DaoInterface<E,K> {
	
public boolean insert(E entity)throws SQLException;
public E selectForObject(K[] key)throws SQLException;
public List<E> selectForList(K[] key)throws SQLException;
public int selectForCount(K[] key)throws SQLException;
public void setDataSource(DataSource dataSource);

}
