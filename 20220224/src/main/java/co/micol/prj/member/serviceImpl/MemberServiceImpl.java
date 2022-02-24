package co.micol.prj.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.prj.common.DataSource;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private Connection conn = DataSource.getInstance();
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<MemberVO> memberSelectList() {
		// 전체리스트 가져오기
		List<MemberVO> members = new ArrayList<MemberVO>();
		MemberVO vo; 
		String sql = "SELECT * FROM MEMBER";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setAddress(rs.getString("address"));
				vo.setAuthor(rs.getString("author"));
				members.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return members;
	}

	private void close() {
		//Connection 연결 종료
		try {
			if(rs != null)rs.close();
			if(psmt != null)psmt.close();
			if(conn != null)conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		//한명분 조회
		String sql = "select * from member where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,vo.getId());
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setAddress(rs.getString("address"));
				vo.setAuthor(rs.getString("author"));
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// 멤버 추가
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getAddress());
			psmt.setString(5, vo.getTel());
			psmt.setString(6, vo.getAuthor());
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		String sql = "update member set password =? , tel=?, author=?" + " where id = ? ";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPassword());
			psmt.setString(2, vo.getTel());
			psmt.setString(3, vo.getAuthor());
			psmt.setString(4, vo.getId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		String sql = "DELETE FROM MEMBER WHERE ID = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,  vo.getId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public boolean isIdcheck(String id) {
		String sql = "SELECT CASE WHEN COUNT(ID) = 1 THEN 0 ELSE 1 END AS ID"
				+ " from member where id = ?";
		boolean b = false;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt("id") != 0) {
					b = true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return b;
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,vo.getId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setAddress(rs.getString("address"));
				vo.setAuthor(rs.getString("author"));
			}
		} catch (Exception e) {
				e.printStackTrace();
				
		} finally {
				close();
			}
		return vo;
		}
	}


