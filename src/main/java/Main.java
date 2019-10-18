package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.PrimaryLoop;

// 80 lines wide
// 54 lines high

public class Main {



	public static void main(String[] args){

		WindowManager wm = new WindowManager();
		PrimaryLoop pl = new PrimaryLoop(wm);

	}



	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_Q){
			System.out.println("Goodbye");
			System.exit(0);
		}
	}

}