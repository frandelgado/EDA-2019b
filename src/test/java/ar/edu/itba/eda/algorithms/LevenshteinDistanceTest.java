package ar.edu.itba.eda.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LevenshteinDistanceTest {

    @Test
    void testLevenshteinDistance(){
        Assertions.assertEquals(
                3,
                LevenshteinDistance.levenshteinDistance("kitten", "sitting")
        );
    }

    @Test
    void testNormalizedLevenshteinDistance(){
        Assertions.assertEquals(
                1d-(3d/7d),
                LevenshteinDistance.normalizedLevenshteinDistance("kitten", "sitting")
        );
    }
}
