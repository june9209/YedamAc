package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.command.HomeCommand;
import co.micol.prj.command.LoginForm;
import co.micol.prj.command.Logout;
import co.micol.prj.command.MemberJoin;
import co.micol.prj.command.MemberJoinForm;
import co.micol.prj.command.MemberList;
import co.micol.prj.command.memberLogin;
import co.micol.prj.common.Command;

/**
 * Servlet implementation class FrontControleer
 */
@WebServlet("*.do")
public class FrontControleer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>();
    
    public FrontControleer() {
        super();
    }
    public void init(ServletConfig config) throws ServletException{
    	//명령 그룹을 담아 두는 곳
    	map.put("/home.do", new HomeCommand() ); // 처음 접근하는 페이지
    	map.put("/memberList.do", new MemberList()); //멤버목록 보기
    	map.put("/loginForm.do", new LoginForm()); //로그인 폼 호출
    	map.put("/memberLogin.do", new memberLogin()); //로그인처리
    	map.put("/logOut.do", new Logout()); // 로그아웃 처리
    	map.put("/memberJoinForm.do",new MemberJoinForm()); // 회원가입 폼 호출
    	map.put("/memberJoin.do", new MemberJoin()); //회원가입 처리
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//실제 요청을 분석 하고 처리해서 결과 page를 돌려주는 역할을 한다
		request.setCharacterEncoding("utf-8");  //한글깨짐 방지
		String uri = request.getRequestURI(); //URI가져옴
		String contextPath = request.getContextPath(); //ContextPath 가져옴
		String page = uri.substring(contextPath.length()); // 실제 요청을 구함 (처리해야 할 요청)
		
		Command command = map.get(page); //Command command = new HomeCommand();
		String viewPage = command.run(request, response);
		
		if(viewPage != null && !viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request,response);
	}


}
