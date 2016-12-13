package langReco.reco;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import langModel.LanguageModel;
import langModel.MyLaplaceLanguageModel;
import langModel.MyNaiveLanguageModel;
import langModel.MyNgramCounts;
import langModel.NgramCounts;

public class MyLanguageRecognizer1 extends LanguageRecognizer {

	private Map<String, LanguageModel> languagesMap;
	
	public MyLanguageRecognizer1(String fileParam) {
		super();
		languagesMap = new HashMap<>();
		loadNgramCountPath4Lang(fileParam);
		
		for(String langcode : langNgramCountMap.keySet()){
			for(String lname : langNgramCountMap.get(langcode).keySet()){
				String currentLMPath = langNgramCountMap.get(langcode).get(lname);
				//contruire le LM
				NgramCounts ngc = new MyNgramCounts();
				ngc.readNgramCountsFile(currentLMPath);
				LanguageModel lm = new MyLaplaceLanguageModel();
				lm.setNgramCounts(ngc);
				// Stocker le LM
				languagesMap.put(langcode, lm);
			}
		}
	}

	@Override
	public String recognizeSentenceLanguage(String sentence) {
		//pour chaque lm dispo
		double currentProb = 0D, prevProb = 0D;
		String codeRet = "unk";
		Set<String> codes = languagesMap.keySet();
		
		for(String code : codes){
			LanguageModel lm = languagesMap.get(code);
			//calculer la proba
			currentProb = lm.getSentenceProb(sentence);
			//conserver le resultat
			if(currentProb >= prevProb){
				prevProb = currentProb;
				codeRet = code;
			}
		}
		return codeRet;
	}

}
