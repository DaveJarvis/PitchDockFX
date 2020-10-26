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

import com.panemu.tiwulfx.control.DetachableTabPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author amrullah
 */
public class FrmTabPaneTester extends Application {

	@Override
	public void start(Stage primaryStage) {
		Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("uncaught exception");
				e.printStackTrace();
			}
		});
		DetachableTabPane tabPane = new DetachableTabPane();

		tabPane.getTabs().add(new Tab("Tab AAAAAAAA"));
		tabPane.getTabs().add(new Tab("Tab BBBBBBBB"));
		tabPane.getTabs().add(new Tab("Tab CCCCCCCC"));
		tabPane.getTabs().add(new Tab("Tab DDDDDDDD"));
		tabPane.getTabs().add(new Tab("Tab EEEEE"));
		BorderPane root = new BorderPane();
		final Button button = new Button("LeftAAAAAAAAAAAAAAAAAAa");
		button.setOnAction((e) -> {
			if (!tabPane.getTabs().isEmpty()) {
				tabPane.getTabs().remove(tabPane.getTabs().get(0));
			}
		});
		root.setLeft(button);
		root.setTop(new Button("Top"));
		StackPane stackPane = new StackPane();
		stackPane.getChildren().add(tabPane);
		root.setCenter(stackPane);

		Scene scene = new Scene(root, 800, 600);
		TiwulFXUtil.setTiwulFXStyleSheet(scene);
		primaryStage.setTitle("Hello World! " + System.identityHashCode(tabPane));
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
