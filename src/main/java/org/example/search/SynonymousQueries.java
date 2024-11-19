package org.example.search;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

//Let us say that we have a list of synonyms:
//SYNONYMS = [
//        ('previous', 'last'),
//        ('location', 'venue')
//        ]
//and a given list of pairs of test queries as input:
//QUERIES = [
//        ('previous location eurovision', 'last venue eurovision'),
//        ('previous locations eurovision', 'last venue eurovision'),
//        ('previous location eurovision', 'eurovision last venue')
//        ]
//write a Java application to output a boolean value for each pair of queries that indicates
//if the two strings are synonymous, searching for the same thing.


public class SynonymousQueries {

    public List<Boolean> getSynonymousStrings(List<Pair<String,String>> synonyms, List<Pair<String, String>> queries){
        List<Boolean> res = new ArrayList<>();
        for (Pair<String, String> query : queries){
            res.add(getSynonymousString(query, synonyms));
        }

        return res;
    }

    private Boolean getSynonymousString(Pair<String, String> query, List<Pair<String,String>> synonyms ) {
        String[] str1 = query.getKey().split(" ");
        String[] str2 = query.getValue().split(" ");


        for (int i=0; i<str1.length; i++){

            if (str1[i].equals(str2[i])){
                continue;
            }

            boolean wordInSynonyms = false;
            for (Pair<String, String> synonym : synonyms){

                if (synonym.getKey().equals(str1[i])){
                    wordInSynonyms = true;
                    if (!synonym.getValue().equals(str2[i])){
                        return false;
                    }
                } else if (synonym.getValue().equals(str1[i])){
                    wordInSynonyms = true;
                    if (!synonym.getKey().equals(str2[i])){
                        return  false;
                    }
                }
            }
            if (!wordInSynonyms){
                return false;
            }
        }
        return true;
    }


}
