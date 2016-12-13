package langReco.reco;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import langModel.LanguageModel;
import langModel.MyNaiveLanguageModel;
import langModel.MyNgramCounts;

public class MyLanguageRecognizer1 extends LanguageRecognizer {

	private Map<String, LanguageModel> languagesMap;
	
	public MyLanguageRecognizer1(String fileParam) throws FileNotFoundException{
		super();
		languagesMap = new HashMap<>();
		MyNgramCounts ngc = new MyNgramCounts();
		loadNgramCountPath4Lang(fileParam);
		
		for(String langcode : langNgramCountMap.keySet()){
			for(String lname : langNgramCountMap.get(langcode).keySet()){
				String currentLMPath = langNgramCountMap.get(langcode).get(lname);
				//contruire le LM
				LanguageModel lm = new MyNaiveLanguageModel();
				ngc.readNgramCountsFile(currentLMPath);
				lm.setNgramCounts(ngc);
				// Stocker le LM
				languagesMap.put(currentLMPath, lm);
			}
		}
	}

	@Override
	public String recognizeSentenceLanguage(String sentence) {
		//pour chaque lm dispo
		
		//calculer la proba
		//conserver
		
		return null;
	}

}
