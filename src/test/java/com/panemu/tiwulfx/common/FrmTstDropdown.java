/*
 * Copyright (C) 2015 Panemu.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package com.panemu.tiwulfx.common;

import com.panemu.tiwulfx.control.LookupField;
import com.panemu.tiwulfx.control.TypeAheadField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author amrullah
 */
public class FrmTstDropdown extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		TypeAheadField<String> cmb = new TypeAheadField<>();
		cmb.addItem("One", "1");
		cmb.addItem("Two", "2");
		cmb.addItem("Three", "3");
		cmb.addItem("Four", "4");
		cmb.addItem("Five", "5");
		
		Label lblFocus = new Label();
		Label lblValue = new Label();
		cmb.focusedProperty().addListener((observable, oldValue, newValue) -> {
			lblFocus.setText(newValue ? "Focused" : "Not focused");
		});
		
		lblValue.textProperty().bind(cmb.valueProperty());
		
		Button btn = new Button();
		btn.setText("Say 'Hello World'");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("value: " + cmb.getValue());
			}
		});
		
		
		VBox root = new VBox();
		root.setSpacing(10);
		root.setPadding(new Insets(10));
		final ComboBox cmb2 = new ComboBox();
		cmb2.setEditable(true);
		cmb2.getItems().add("abc");
		cmb2.getItems().add("def");
		root.getChildren().addAll(cmb2, new LookupField(), lblValue, cmb,lblFocus,btn);
		
		Scene scene = new Scene(root, 300, 250);
		
		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}
