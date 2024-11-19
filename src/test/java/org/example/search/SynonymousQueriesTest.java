package org.example.search;

import javafx.util.Pair;
import org.example.calculator.Calculator;
import org.example.login.LoginManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class SynonymousQueriesTest {

    private SynonymousQueries synonymousQueries;

    @BeforeEach
    void setUp() {
        this.synonymousQueries = new SynonymousQueries();
    }

    @Test
    void test_method_withNoInputs_returnsEmptyList() {

        assertThat(synonymousQueries.getSynonymousStrings(List.of(), List.of()).size()).isEqualTo(0);

    }

    @Test
    void test_method_withSignleSynonymousQuery_returnsListWithTrue() {

        // Build
        List<Pair<String,String>> synonyms = List.of(
                new Pair<>("previous", "last"),
                new Pair<>("location", "venue")
                );

        List<Pair<String, String>> queries = List.of(new Pair<>("previous location eurovision", "last venue eurovision"));


        // Act
        List<Boolean> res =  synonymousQueries.getSynonymousStrings(synonyms, queries);

        // Assert

        assertThat(res.size()).isEqualTo(1);
        assertThat(res.get(0)).isEqualTo(true);

    }

    @Test
    void test_method_withNonSynonymousQuery_returnsListWithFalse() {

        // Build
        List<Pair<String,String>> synonyms = List.of(
                new Pair<>("previous", "last"),
                new Pair<>("location", "venue")
        );

        List<Pair<String, String>> queries = List.of(new Pair<>("previous location eurovision", "next venue eurovision"));


        // Act
        List<Boolean> res =  synonymousQueries.getSynonymousStrings(synonyms, queries);

        // Assert

        assertThat(res.size()).isEqualTo(1);
        assertThat(res.get(0)).isEqualTo(false);

    }

    @Test
    void test_method_withMultipleQueries_returnsCorrectResult() {

        // Build
        List<Pair<String,String>> synonyms = List.of(
                new Pair<>("previous", "last"),
                new Pair<>("location", "venue")
        );

        List<Pair<String, String>> queries = List.of(
                new Pair<>("previous location eurovision", "last venue eurovision"),
                new Pair<>("previous locations eurovision", "last venue eurovision"),
                new Pair<>("previous location eurovision", "eurovision last venue")
        );


        // Act
        List<Boolean> res =  synonymousQueries.getSynonymousStrings(synonyms, queries);

        // Assert

        assertThat(res.size()).isEqualTo(3);
        assertThat(res.get(0)).isEqualTo(true);
        assertThat(res.get(1)).isEqualTo(false);
        assertThat(res.get(2)).isEqualTo(false);


    }


}