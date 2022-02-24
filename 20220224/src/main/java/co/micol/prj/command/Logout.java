package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.common.Command;

public class Logout implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//로그아웃 처리
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");
		session.invalidate(); //세션을 삭제한다.
		request.setAttribute("message", name + "님 로그아웃 처리되었습니다.");
		return "member/memberLogin";
	}

}
