package textanalyzer;


import java.io.File;
import java.util.Map;

public class TextAnalyzer {

	private File file;

	public TextAnalyzer(String fileName) {
		file = new File(fileName);
	}



	// Opgave 2:   Nearly as Listing 21.9 from Liang

	public Map<String, Integer> countWords() {
		Map<String, Integer> map = null;

			//map = //create hashmap instance

		// gennemlæs filen "alice30.txt" et ord ad gangen
		// kald clean() metoden på hvert ord
		// benyt mappen til at tælle forekomsten af hvert ord

		return map;
	}



	// Denne metode forsøger at fjerne alt 'snavs' fra en String,
	// så kun bogstaver bevares og store gøres til små
	private String clean(String s) {
		String r = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				r = r + c;
			}
		}
		return r.toLowerCase();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TextAnalyzer ta = new TextAnalyzer("alice30.txt");


		// Opgave 2. Tæl forekomster af ord
		// Fjern udkommenteringen, når countWords() er programmeret:

//		Map<String, Integer> map = ta.countWords();
//		System.out.println(map);
//
		System.out.println("\n------------------------------------------------------------------\n");

	}

}
