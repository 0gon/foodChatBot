package nlp;

import java.util.List;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.Token;

public class NLPServletTest {

    public static void main(String[] args) {
        Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
        komoran.setUserDic("user_data/dic.user");
        List<Token> tokens = komoran.analyze("자동차 차 찻잔 차키 홍차 녹차 보리차 보이차 우렁차").getTokenList();
        for(Token token : tokens)
            System.out.println(token);
        	
        	
        	
        	
        
        
        	System.out.println("------------------------------");
        	System.out.println("여기부터는 다 짤라서 나오는 영역 입니다.");
        	System.out.println("------------------------------");
        
        	
        	
        	
        	System.out.println("시작 Index: " + tokens.get(0).getBeginIndex());
        	System.out.println("끝 Index: " + tokens.get(0).getEndIndex());
        	System.out.println("문자열(형태소): " + tokens.get(0).getMorph());
        	System.out.println("품사: "+tokens.get(0).getPos());
    }
}