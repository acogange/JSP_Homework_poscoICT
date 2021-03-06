package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BbsDao;
import dao.MemberDao;
import dto.BbsDto;

@WebServlet("/bbs")
public class BbsController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	public void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("BbsController doProcess");
		req.setCharacterEncoding("utf-8");
		
		String param = req.getParameter("param");
		if(param.equals("bbslist")) {
			String choice=req.getParameter("choice");
			String search=req.getParameter("search");
			String Number =req.getParameter("pageNumber");
			if (Number==null) {
				Number="0"; 
			}
			int pageNumber=Integer.parseInt(Number);

			BbsDao dao = BbsDao.getInstance();
			
			if (choice ==null||search==null) {
				choice = "";
				search = "";
				
			}
			
			List<BbsDto> list = dao.getBbsPagingList(choice, search,pageNumber);
	
			req.setAttribute("list", list);		// 짐싸!
			
		//	RequestDispatcher dispatch = req.getRequestDispatcher("bbslist.jsp");
		//	dispatch.forward(req, resp);
			forward("bbs/bbslist.jsp", req, resp);	// 잘가!
			
			
		}	
		
		else if(param.equals("bbswrite")) {
			resp.sendRedirect("bbs/bbswrite.jsp");
		}
		else if(param.equals("bbswriteAf")) {
			String id = req.getParameter("id");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			BbsDao dao = BbsDao.getInstance();
			String msg="NG";
			boolean isS = dao.writeBbs(new BbsDto(id, title, content));
			System.out.println("isS: "+isS);
			if(isS==true){
				msg="OK";
				resp.sendRedirect("message.jsp?proc=bbswrite&msg="+msg);	
				
			
			}else{
				
				resp.sendRedirect("message.jsp?proc=bbswrite&msg="+msg);
			
				
				
			}	
		}
		else if(param.equals("bbsdetail"))
		{
			int seq = Integer.parseInt(req.getParameter("seq"));
			resp.sendRedirect("bbs/bbsdetail.jsp?seq="+seq);
		}
		else if(param.equals("update")) {
			
			int seq = Integer.parseInt(req.getParameter("seq"));
			resp.sendRedirect("bbs/update.jsp?seq="+seq);
		}
		else if(param.equals("updateAf")) {
			String s = req.getParameter("seq");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			BbsDao dao = BbsDao.getInstance();
			String msg="OK";
			int seq=Integer.parseInt(s);
			boolean isS=dao.updateBbs(seq,title, content);
			if (isS==true) {
				resp.sendRedirect("message.jsp?proc=update&msg="+msg);
			}
			else {
				msg="NG";
				resp.sendRedirect("message.jsp?proc=update&msg="+msg);
			}
		}
		else if(param.equals("delete")) {
			BbsDao dao = BbsDao.getInstance();
			String s = req.getParameter("seq");
			int seq=Integer.parseInt(s);
			boolean isS = dao.deleteBbs(seq);
			String msg="OK";
			if (isS==true) {
				resp.sendRedirect("message.jsp?proc=delete&msg="+msg);
			}
			else 
			{
				msg="NG";
				resp.sendRedirect("message.jsp?proc=delete&msg="+msg);
			}
		}
		else if(param.equals("answer")){
			String s = req.getParameter("seq");
			int seq=Integer.parseInt(s);
			resp.sendRedirect("bbs/answer.jsp?seq="+seq);
			
		}
		else if(param.equals("answerAf")) {
			String s= req.getParameter("seq");
			String id = req.getParameter("id");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			int seq=Integer.parseInt(s);
			
			BbsDao dao = BbsDao.getInstance();
			boolean isS = dao.answer(seq, new BbsDto(id, title, content));
			String msg="OK";
			if (isS==true) {
				resp.sendRedirect("message.jsp?proc=answer&msg="+msg);
			}
			else 
			{
				msg="NG";
				resp.sendRedirect("message.jsp?proc=answer&msg="+msg);
			}
			
		}

	}
	
	public void forward(String arg, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher(arg);
		dispatch.forward(req, resp);
	}
	
}




