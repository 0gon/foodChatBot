package util;

public class ReturnTranslate {
	public static String Translate(String target) {
		if (target.equals("날씨")) {
			return "wether";
		} else if (target.equals("장소")) {
			return "place";
		} else if (target.equals("재료")) {
			return "ingredient";
		} else if (target.equals("사람")) {
			return "person";
		} else if (target.equals("행동")) {
			return "action";
		}

		return "잘못된거임";
//	wether 날씨
//	place 장소
//	ingredient 재료
//	person 사람
//	action 행동
	}
}
