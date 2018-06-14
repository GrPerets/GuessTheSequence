/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

import java.awt.EventQueue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author grperets
 */
public class VisualMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:META-INF/config/visualXMLConfig.xml");
        //EventQueue.invokeLater(new Runnable(){public void run(){GameJFrame gameJFrameWithStartJPanel = ctx.getBean("gameJFrameWithStartJPanel", GameJFrame.class);}});
        EventQueue.invokeLater(() -> {
            GameJFrame gameJFrame = ctx.getBean("gameJFrame", GameJFrame.class);
        });
        //GameJFrame gameJFrameWithPlayJPanel = ctx.getBean("gameJFrameWithPlayJPanel", GameJFrame.class);
                
        
        
    }
    
}
