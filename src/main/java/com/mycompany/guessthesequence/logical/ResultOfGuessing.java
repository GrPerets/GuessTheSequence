/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.logical;

import java.util.Collection;

/**
 *
 * @author grperets
 */
public interface ResultOfGuessing {
    int getGuessedElements();
    int getPositionElements();
    void setGuessedElements(Object[] collection1, Object[] collection2);
    void setPositionElements(Object[] collection1, Object[] collection2);
}
