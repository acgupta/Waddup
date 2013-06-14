/*
 * Copyright © 2013 Nokia Corporation. All rights reserved. Nokia and Nokia
 * Connecting People are registered trademarks of Nokia Corporation. Oracle and
 * Java are trademarks or registered trademarks of Oracle and/or its affiliates.
 * Other product and company names mentioned herein may be trademarks or trade
 * names of their respective owners. See LICENSE.TXT for license information.
 */
package com.nokia.example;

import com.nokia.mid.ui.orientation.Orientation;
import com.nokia.mid.ui.orientation.OrientationListener;
import javax.microedition.lcdui.*;

/** The HelloScreen Class implements OrientationListener to detect a change in the orientation of the device's display */
class HelloScreen
        extends Form
        implements CommandListener, OrientationListener {

    private final HelloWorldMIDlet midlet;
    private final Command exitCommand; // Exit command for closing the MIDlet in the device UI.

    public HelloScreen(HelloWorldMIDlet midlet, String string) {        
           
             super("FT_HelloWorld");   //added for 3.0   


        /** 
         * Orientation is supported for Java Runtime 2.0.0 for Series 40
         * onwards. Registers the orientation listener. Applications that need
         * information about events related to display orientation changes 
         * need to register with Orientation to get notifications of the events.
         */
        Orientation.addOrientationListener(this);

        StringItem helloText = new StringItem("", string);
        super.append(helloText);
        this.midlet = midlet;
        exitCommand = new Command("Exit", Command.EXIT, 1);
        addCommand(exitCommand);
        setCommandListener(this);
    }

    public void commandAction(Command command, Displayable displayable) {
        if (command == exitCommand) {
            midlet.notifyDestroyed();
        }
    }

    /**  
     * Orientation is supported for Java Runtime 2.0.0 for Series 40
     * onwards. Called when display's orientation has changed. 
     */
    public void displayOrientationChanged( int newDisplayOrientation ){
            /** Change MIDlet UI orientation */
            Orientation.setAppOrientation(newDisplayOrientation);        
    }
}
