package com.yzu;

import com.yzu.Panel.*;

public class App {
   public static void main(String[] args) {
      MainPanel window = new MainPanel();
      System.out.println("ObjCount in panelLeft: " + window.panelLeft.getComponentCount());
   }
}
