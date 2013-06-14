/*
 * Copyright © 2013 Nokia Corporation. All rights reserved. Nokia and Nokia
 * Connecting People are registered trademarks of Nokia Corporation. Oracle and
 * Java are trademarks or registered trademarks of Oracle and/or its affiliates.
 * Other product and company names mentioned herein may be trademarks or trade
 * names of their respective owners. See LICENSE.TXT for license information.
 */
package com.nokia.example;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;

public class HelloWorldMIDlet extends MIDlet {

    public HelloWorldMIDlet() {
    }

    // Sets the MIDlet's current Display to a HelloScreen object.
    public void startApp() {
        Displayable current = Display.getDisplay(this).getCurrent();
        if (current == null) {
            HelloScreen helloScreen = new HelloScreen(this, "Hello, world!");
            Display.getDisplay(this).setCurrent(helloScreen);
        }
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
