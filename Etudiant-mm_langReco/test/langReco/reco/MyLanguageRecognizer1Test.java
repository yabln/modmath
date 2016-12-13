package langReco.reco;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import langReco.eval.Performance;


/**
 * Class BaselineLanguageRecognizerTest: JUnit Test class to evaluate the baseline recognition system.
 * 
 * @author N. Hernandez and S. Quiniou (2015)
 *
 */
public class MyLanguageRecognizer1Test {

	@Test
	public void testMylineLanguageRecognizer1() {
		String goldSentPath = "data/gold/gold-sent.txt";
		String goldLangPath = "data/gold/gold-lang.txt";
		String path = "lm/fichConfig_bigram-100.txt";

		
		LanguageRecognizer languageRecognizer = new MyLanguageRecognizer1(path);
		// or use the following if you want to consider all the languages
		// LanguageRecognizer baseline = new BaselineLanguageRecognizer();

		String hypLangFilePath = "/tmp/hyp";
		
		languageRecognizer.recognizeFileLanguage(goldSentPath, hypLangFilePath);
		System.out.printf("System performance = %f\n", Performance.evaluate(goldLangPath, hypLangFilePath));
	}


	@Rule
	public TestName name = new TestName();

	
	@Before
	public void printSeparator()
	{
		System.out.println("\n=== " + name.getMethodName() + " =====================");
	}

}
