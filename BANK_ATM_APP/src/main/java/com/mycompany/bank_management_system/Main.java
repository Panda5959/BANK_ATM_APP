package com.mycompany.bank_management_system;

import com.formdev.flatlaf.FlatLightLaf;

public class Main {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        LOGIN loginFrame = new LOGIN();
        loginFrame.pack();
        loginFrame.setVisible(true);
    }
}
