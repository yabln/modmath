package langModel;

public class Application {

	public static void main(String[] args) {
		String string = "a b c d e f g ";
		int order = 3;
		System.out.println(NgramUtil.getSequenceSize(string));
		System.out.println(NgramUtil.getHistory(string, order));
		System.out.println(NgramUtil.decomposeIntoNgrams(string, order));
		System.out.println(NgramUtil.generateNgrams(string, 1, 3));
	}

}
