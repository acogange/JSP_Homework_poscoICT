package ajax4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import net.sf.json.JSONObject;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		System.out.println("id:"+id);
		System.out.println("pw:"+pw);
		
		String str="안녕하세요";
		JSONObject jObj=new JSONObject();
		//jObj.put("str",str);
		
		//다수 데이터 treeMap
		HashMap<String,Object> map=new HashMap<String, Object>();
		map.put("title","여기는 제목");
		map.put("content","이건 내용");
		jObj.put("mydatas", map);
		
		
		List<HumanDto>list =new ArrayList<HumanDto>();
		list.add(new HumanDto(1001,"성수동"));
		list.add(new HumanDto(1002,"박민지"));
		list.add(new HumanDto(1003,"유재석"));
		
		jObj.put("list", list);
		
		resp.setContentType("application/x-json; charset=utf-8");//인코딩 방식
		resp.getWriter().print(jObj);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
