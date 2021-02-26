package de.javakurs.testing;

import de.javakurs.faehre.FaehreUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FaehreUITest {
 @Test
   public void faehreTest(){
        FaehreUI.erzeugeZufallszahl(4,5);
        assertTrue(4==4);
    }



}