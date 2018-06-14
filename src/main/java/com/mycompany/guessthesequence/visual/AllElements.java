/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

/**
 *
 * @author grperets
 */
public enum AllElements {
    ONE("one","images/one.jpeg"), TWO("two","images/two.jpeg"), THREE("three","images/three.jpeg"),
    FOUR("four","images/four.jpeg"), FIVE("five","images/five.jpeg"), SIX("six","images/six.jpeg"),
    SEVEN("seven","images/seven.jpeg"), EIGHT("eight","images/eight.jpeg"), NINE("nine","images/nine.jpeg"),
    TEN("ten","images/ten.jpeg"), ZERO("zero","images/zero.jpeg");
    private String name;
    private String urlAddress;
    AllElements(String name, String urlAddress){
        this.name = name;
        this.urlAddress = urlAddress;
    }
    
    public String getName(){
        return name;
    }
    
    public String getUrlAddress(){
        return urlAddress;
    }
}
