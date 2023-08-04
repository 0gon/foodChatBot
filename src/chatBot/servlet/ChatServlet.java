package chatBot.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chatBot.dao.ChatBotDAO;
import chatBot.service.UnKnownService;
import chatBot.service.recommendService;
import imgFinder.ImageReturner;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
	UnKnownService us = new UnKnownService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(200);
		resp.setHeader("Content-Type", "application/json;charset=utf-8");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = req.getReader();
		String line;
		while((line = br.readLine()) != null) {
			sb.append(line);
		}
		String body = sb.toString();
		System.out.println("사용자 요청 body 확인: " + body);
		
		Pattern p = Pattern.compile("\\{\"chat\":\"(.+?)\"\\}");
		Matcher m = p.matcher(body);
		m.find();
		
		String chat = m.group(1);
		System.out.println(chat);
		
		String chatbot;
		chatbot = recommend(chat);
		
		
		
		// 분기 생성. 사용자 문자열 받은 경우(chat)와 모르는 단어 질문 후 응답받았을때(request)
		// chatbot = 사용자요청을 json 형식으로 
		// request = 재질문 받은 값을 json 형식으로 
		// wordList = 자연어 처리된 문자열 리스트
		if (chatbot != null) {
			String unKnownWord = us.unknownWord(wordList);
			if (unKnownWord != null) {
				// unKnownWord 를 이용하여 
			}
		} else (request != null){
			
		}
		
		if(chat.equals("사람") || chat.equals("날씨") || chat.equals("장소")) {
			chatbot = "그것은 어떤음식과 매칭?";
		} else if ( chat.equals("떡볶이") || chat.equals("돈가스") || chat.equals("죽") ) {
			chatbot = "감사합니다. 무엇을 먹고싶으세요?";
		} else if (chat.equals("모르는단어")){
			chatbot = "그것은 무엇?";
		}
		req.setAttribute("food", chatbot);
		System.out.println(chatbot);
		String resolve = "0";
		
		resp.setStatus(200);
		resp.setHeader("Content-Type", "application/json;charset=utf-8");
		resp.getWriter().write("{\"food\": \"" + chatbot + "\",");
		resp.getWriter().write("\"resolve\": \"" + resolve + "\"}");
		resp.getWriter().write("잘뜹니다");
	}
	
	public String recommend(String chat) {
		recommendService rs = new recommendService();
		List<String> wordList = new ArrayList<String>();
		System.out.println(rs.getFoodList());
		wordList.add(chat);
		String food = rs.recommendFood(wordList);
		return food;
	}


}
