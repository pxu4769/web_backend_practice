package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import bean.Member;

public class MemberDao implements DaoInterface<Member,String>{
	public DataSource dataSource;

	@Override
	public boolean insert(Member member) throws SQLException {
		if(this.dataSource==null) {
			throw new SQLException("尚未注入dataSource");
		}
		Connection connection=dataSource.getConnection();
		String sql="insert into trpgmember(username,password) values(?,?)";
		PreparedStatement st=connection.prepareStatement(sql);
		
		st.setString(1,member.getUsername());
		st.setString(2,member.getPassword());
		st.execute();
		
		connection.close();
		
		return true;
	}

	@Override
	public Member selectForObject(String[] key) throws SQLException {
		return null;
	}

	@Override
	public List<Member> selectForList(String[] key) throws SQLException {
		return null;
	}

	@Override
	public int selectForCount(String[] key) throws SQLException {
		if(this.dataSource==null) {
			throw new SQLException("尚未注入dataSource");
		}
		Connection connection = dataSource.getConnection();
		String sql = "select count(*) from trpgmember where username=? and password=?";
		PreparedStatement st = connection.prepareStatement(sql);

		st.setString(1, key[0]);
		st.setString(2, key[1]);
		ResultSet rs = st.executeQuery();
		rs.next();
		
		int result=rs.getInt(1);
		connection.close();
		
		return result;
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}

}
