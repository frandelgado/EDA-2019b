package ar.edu.itba.eda.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SoundexTest {

    @Test
    public void testSoundex(){
        String expectedEncoding = "S436";
        String inputString ="szlloydtirul";
        String encodedString = Soundex.encode(inputString);
        Assertions.assertEquals(expectedEncoding, encodedString);
    }
}
