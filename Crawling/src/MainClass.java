import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Document doc=Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ft=0").get();	//cgv 차트 link
		
		
		/*
		 <div class="box-contents">
                        <a href="/movies/detail-view/?midx=85813">
                            <strong class="title">범죄도시 2</strong>
                        </a>

                        <div class="score">
                            <strong class="percent">예매율<span>44.2%</span></strong> 
		 */
		Elements titles=doc.select("div.box-contents strong.title");
		
		Elements percents=doc.select("div.box-contents div.score strong.percent span");
		
		for (int i = 0; i < 19; i++) {
			Element title=titles.get(i);
			Element percent=percents.get(i);
			
			System.out.println(title.text()+" "+percent.text());
			
		}
	}

}
