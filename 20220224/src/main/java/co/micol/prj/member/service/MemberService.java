package co.micol.prj.member.service;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList(); //전체 회원 목록 -R
	MemberVO memberSelect(MemberVO vo); //회원 단일정보 호출-R
	int memberInsert(MemberVO vo);//회원 추가-C
	int memberUpdate(MemberVO vo);//회원 수정-U
	int memberDelete(MemberVO vo);//회원 삭제-D
	
	boolean isIdcheck(String id); //ID 중복 체크 존재하면 false
	MemberVO memberLogin(MemberVO vo);//로그인
}
