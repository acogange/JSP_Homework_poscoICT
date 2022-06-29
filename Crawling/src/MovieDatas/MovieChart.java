package MovieDatas;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dto.MovieVo;

public class MovieChart {

	public static List<MovieVo> getCGVdata() throws Exception{
		Document doc=Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ft=0").get();	//cgv 차트 link
		
		Elements titles=doc.select("div.box-contents strong.title");
		
		Elements percents=doc.select("div.box-contents div.score strong.percent span");
		
		List<MovieVo> list=new ArrayList<MovieVo>();
		for (int i = 0; i < 19; i++) {
			Element title=titles.get(i);
			Element percent=percents.get(i);
			
			String t=title.text();
			double p=Double.parseDouble(percent.text().replace("%", ""));
			
			System.out.println(title.text()+" "+percent.text());
			list.add(new MovieVo(t,p));
		}
		return list;
		}
}
