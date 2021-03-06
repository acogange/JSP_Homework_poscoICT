package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dto.MemberDto;
@WebServlet("/cont")
public class MemberController extends HttpServlet{
	private String myid="";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	
	public void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MemberController doProcess");
		req.setCharacterEncoding("utf-8");
		
		
		String param = req.getParameter("param");
		
		if(param.equals("login")) {
			resp.sendRedirect("./member/login.jsp");
		}
		else if(param.equals("loginAf")) {
			String id = req.getParameter("id");
			
			String pwd = req.getParameter("pwd");
			
			MemberDao dao = MemberDao.getInstance();			
			MemberDto dto = dao.login(new MemberDto(id, pwd, null,null, null, 0));
			
			String msg = "";
			if(dto != null) {
				req.getSession().setAttribute("login", dto);
				msg = "OK";
				
				
				
				myid=id;
			}else {
				msg = "NG";
			}
			
			resp.sendRedirect("message.jsp?proc=login&msg=" + msg);	
		}
		else if(param.equals("makeaccount"))
		{
			resp.sendRedirect("./member/makeaccount.jsp");
		}
		else if(param.equals("makeaccountAf")) {
			String id = req.getParameter("id");
			String pwd = req.getParameter("password");
			String name = req.getParameter("name");
			String birth =req.getParameter("birth");
			String  addr= req.getParameter("address");
			String h=req.getParameter("height");
		
			int height=Integer.parseInt(h);
			
			MemberDao dao = MemberDao.getInstance();
			MemberDto dto = new MemberDto(id, pwd, name, birth, addr,height);
			boolean isS = dao.addMember(dto);
			
			String msg = "OK";
			if(isS == false) {
				msg = "NG";
			}
			
			resp.sendRedirect("message.jsp?proc=makeaccount&msg=" + msg);			
		}
		else if(param.equals("out")) {
			resp.sendRedirect("./member/out.jsp");
		}
		else if(param.equals("outAf")) {
			String pwdd = req.getParameter("password");
			String id=req.getParameter("id");
			MemberDao dao = MemberDao.getInstance();
			
			System.out.println("thisisuserid"+id);
			MemberDto dto = new MemberDto(id, null, null, null, null,0);
			boolean isS = dao.out(pwdd,dto);
			
			String msg = "OK";
			if(isS == false) {
				msg = "NG";
			}
			
			resp.sendRedirect("message.jsp?proc=out&msg=" + msg);		
		}
		
		
	}
}
