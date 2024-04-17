package UtilityClasses;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MyRobot {
    static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public static void enterPath(String path) {
        // Type the file path character by character
        for (char c : path.toCharArray()) {
            if(c == ':') {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_SEMICOLON);
                robot.keyRelease(KeyEvent.VK_SEMICOLON);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
            else {
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                    throw new RuntimeException(
                            "Key code not found for character '" + c + "'");
                }
                robot.keyPress(keyCode);
                robot.delay(100);
                robot.keyRelease(keyCode);
                robot.delay(100);
            }
        }
    }
    public static void pressENTER(){
        // Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}



