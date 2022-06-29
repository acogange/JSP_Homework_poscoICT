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
			
			BbsDao dao = BbsDao.getInstance();
			List<BbsDto> list = dao.getBbsList();
			
			req.setAttribute("list", list);		// 짐싸!
			
		//	RequestDispatcher dispatch = req.getRequestDispatcher("bbslist.jsp");
		//	dispatch.forward(req, resp);
			forward("bbs/bbslist.jsp", req, resp);	// 잘가!
			
		}		
	}
	
	public void forward(String arg, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher(arg);
		dispatch.forward(req, resp);
	}
	
}




