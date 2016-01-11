package quiz.trying;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;


public class Q3 {

	/**
	 *  태그 매칭
	 *  구글 : [안드로이드, 검색, 모바일]
	 *  애플 : [IOS, 맥북, 모바일]
	 *  
	 *  I: 모바일, O: 구글, 애플
	 *  I: [모바일, 검색], O: 구글
	 */
	
	public Map<String, List<String>> tagMap = new HashMap<>();
	
	@Before
	public void setup() {
		String[] googleTags = {"안드로이드", "검색", "모바일"};
		String[] appleTags = {"IOS", "맥북", "모바일"};
		
		this.classifyTags("구글", googleTags);
		this.classifyTags("애플",appleTags);
	}
	
	@Test
	public void t1() {
		String[] inputs = {"모바일"};
		this.solve(inputs);
		
		
	}
	
	public void solve(String[] inputs) {
		List<String> results = new ArrayList<>();
		
		for (String string : results) {
			
		}
		
	}
	

	public void classifyTags(String title, String[] tags) {
		List<String> keyList;
		for (String tagKey : tags) {
			keyList = tagMap.get(tagKey); 
			
			if(keyList != null) {
				keyList.add(title);
			} else {
				keyList = new ArrayList<String>();
				keyList.add(title);
				tagMap.put(tagKey, keyList);
			}
		}
	}
}
