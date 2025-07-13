package com.college.main;

import com.college.controller.AdmissionController;

public class AppLauncher {
    public static void main(String[] args) {
        AdmissionController controller = new AdmissionController();
        controller.start();  // sirf yeh ek method call
    }
}
