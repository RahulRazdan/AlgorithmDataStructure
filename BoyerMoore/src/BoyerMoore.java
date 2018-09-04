import java.util.Hashtable;

public class BoyerMoore {

	private String word;
	private String pattern;

	private Hashtable<Character, Integer> badMatchTable = new Hashtable<>();

	public BoyerMoore(String word, String pattern) {
		super();
		this.word = word;
		this.pattern = pattern;
		this.preProcessTable();
	}

	public int search() {

		int lengthOfPattern = this.pattern.length();
		int lengthOfWord = this.word.length();

		int numberOfSkips = 0;

		for (int i = 0; i <= lengthOfWord - lengthOfPattern; i += numberOfSkips) {
			numberOfSkips = 0;
			for (int j = lengthOfPattern - 1; j >= 0; j--) {
				if (word.charAt(i + j) != pattern.charAt(j)) {
					if (badMatchTable.get(pattern.charAt(j)) != null)
						numberOfSkips = badMatchTable.get(pattern.charAt(j));
					else
						numberOfSkips = lengthOfPattern;

					break;
				}
			}
			if(numberOfSkips == 0) return i;
		}
		
		return lengthOfWord;
	}

	private void preProcessTable() {

		int lengthOfPattern = this.pattern.length();
		for (int i = 0; i < lengthOfPattern; i++) {
			int value = Math.max(1, lengthOfPattern - i - 1);
			badMatchTable.put(this.pattern.charAt(i), value);
		}
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public Hashtable<Character, Integer> getBadMatchTable() {
		return badMatchTable;
	}

	public void setBadMatchTable(Hashtable<Character, Integer> badMatchTable) {
		this.badMatchTable = badMatchTable;
	}
}
