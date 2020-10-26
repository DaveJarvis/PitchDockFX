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

import com.panemu.tiwulfx.control.NumberField;
import java.math.BigDecimal;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author amrullah
 */
public class FrmTstNumberField extends Application {

	@Override
	public void start(Stage primaryStage) {
		TiwulFXUtil.DEFAULT_NEGATIVE_ALLOWED = true;
		NumberField<Double> txt1 = new NumberField<>(Double.class);txt1.setId("txt1");
		txt1.setDigitBehindDecimal(2);
		txt1.setNegativeAllowed(false);
		NumberField<Double> txt2 = new NumberField<>(Double.class);txt2.setId("txt2");
		txt2.setDigitBehindDecimal(4);
		NumberField<BigDecimal> txt3 = new NumberField<>(BigDecimal.class);txt3.setId("txt3");
		txt3.setDigitBehindDecimal(4);
		NumberField<Integer> txt4 = new NumberField<>(Integer.class);txt4.setId("txt4");
		txt4.setDigitBehindDecimal(4);

		Button btn = new Button("Set Value");
		btn.setOnAction(e -> {
			txt1.setValue(-123.456);
			txt2.setValue(123.4565678);
			txt3.setValue(new BigDecimal("123.4565678"));
			txt4.setValue(900);
			
			txt2.setNegativeAllowed(!txt2.isNegativeAllowed());
			txt3.setNegativeAllowed(!txt3.isNegativeAllowed());
			txt4.setNegativeAllowed(!txt4.isNegativeAllowed());
		});
		Button btn2 = new Button("Get Value");
		btn2.setOnAction(e -> {
			System.out.println("txt1: " + txt1.getValue());
			System.out.println("txt2: " + txt2.getValue());
			System.out.println("txt3: " + txt3.getValue());
			System.out.println("txt4: " + txt4.getValue());
		});
		
		txt1.valueProperty().addListener(new ChangeListener<Double>() {

			@Override
			public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
				System.out.println(txt1.getId() + ": " + newValue);
			}
		});
		txt2.valueProperty().addListener(new ChangeListener<Double>() {

			@Override
			public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
				System.out.println(txt2.getId() + ": " + newValue);
			}
		});
		
		txt3.valueProperty().addListener(new ChangeListener<BigDecimal>() {

			@Override
			public void changed(ObservableValue<? extends BigDecimal> observable, BigDecimal oldValue, BigDecimal newValue) {
				System.out.println(txt3.getId() + ": " + newValue);
			}
		});
		txt4.valueProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				System.out.println(txt4.getId() + ": " + newValue);
			}
		});
		
		

		VBox root = new VBox();
		root.getChildren().addAll(txt1, txt2, txt3, txt4, btn, btn2);

		Scene scene = new Scene(root, 500, 250);
		TiwulFXUtil.setTiwulFXStyleSheet(scene);
		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
