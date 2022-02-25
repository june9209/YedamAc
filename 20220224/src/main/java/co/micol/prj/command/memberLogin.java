package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class memberLogin implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//로그인 처리
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();//서버가 가지고 있는 나의 세션 객체를 호출
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		
		vo = memberDao.memberLogin(vo);
		
		if(vo.getName() != null) {
			//세션 처리
			session.setAttribute("id", vo.getId()); //세션 아이디 담기
			session.setAttribute("author", vo.getAuthor()); //세션 권한담기
			session.setAttribute("name", vo.getName()); //이름담기
			return "home.do";
//			System.out.println(vo.getName());
//			request.setAttribute("message", vo.getName() + "님 환영합니다.");
		}else {
			request.setAttribute("message","아이디 또는 패스워드가 일치하지 않습니다.");
		}
	return "member/memberLogin";
	}
}
