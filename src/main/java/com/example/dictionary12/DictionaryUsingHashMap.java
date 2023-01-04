package com.example.dictionary12;

import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryUsingHashMap {
    private HashMap<String,String> hashMap;

    public DictionaryUsingHashMap() {
        this.hashMap = new HashMap<>();
        addAllWord();
    }
    public void addWord(String word,String meaning){
        try {
            hashMap.put(word,meaning);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    public String getMeaning(String word){
        if(hashMap.containsKey(word)) return hashMap.get(word);
        else{
            return "----word not found---!";
        }
    }
    public ArrayList<String> getSuggestion(String word){
        ArrayList<String> stringArrayList=new ArrayList<>();
        char firstCharacter=word.charAt(0);
        for(String s:hashMap.keySet()){
            if(firstCharacter==s.charAt(0)){
                stringArrayList.add(s);
            }
        }
       return stringArrayList;
    }
    public void addAllWord(){
        addWord("honest","free of deceit; truthful and sincere.");
        addWord("sincerity","the absence of pretence, deceit, or hypocrisy.");
        addWord("trust","firm belief in the reliability, truth, or ability of someone or something.");
        addWord("responsibility","the state or fact of being accountable or to blame for something.");
        addWord("programming","the process or activity of writing computer programs");
        addWord("information","facts provided or learned about something or someone.");
        addWord("technology","the application of scientific knowledge for practical purposes, especially in industry.");
        addWord("greedy","having an excessive desire or appetite for food");
        addWord("acknowledge","accept or admit the existence or truth of.");
        addWord("auction","a public sale in which goods or property are sold to the highest bidder.");
        addWord("coding","the process of assigning a code to something for classification or identification.");
        addWord("motivation","a reason or reasons for acting or behaving in a particular way.");
        addWord("blueprint","a design plan or other technical drawing");
        addWord("respect","a feeling of deep admiration for someone");
        addWord("accountability","the fact or condition of being accountable; responsibility.");
        addWord("success","the accomplishment of an aim or purpose.");
        addWord("upgrade","raise (something) to a higher standard");
        addWord("competition","the activity or condition of striving to gain or win something ");
        addWord("compensation","something, typically money, awarded to someone in recognition of loss, suffering");
        addWord("brand","a type of product manufactured by a particular company under a particular name.");
        addWord("passion","strong and barely controllable emotion.");
        addWord("promise","the quality of potential excellence.");
        addWord("deadline","the latest time or date by which something should be completed");

    }
}
