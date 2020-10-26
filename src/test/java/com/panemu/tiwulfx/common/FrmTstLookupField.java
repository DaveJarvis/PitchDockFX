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
import com.panemu.tiwulfx.control.LookupFieldController;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author amrullah
 */
public class FrmTstLookupField extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		LookupField<Record> lkField = new LookupField<>();
		lkField.setController(new LookupFieldController<Record>(Record.class) {
			@Override
			public String[] getColumns() {
				return new String[]{"id", "name", "gender"};
			}
			
			@Override
			protected TableData loadData(int startIndex, List<TableCriteria> filteredColumns, List<String> sortedColumns, List<TableColumn.SortType> sortingTypes, int maxResult) {
				List<Record> lst = new ArrayList<>();
				for (int i = 0; i < 10; i++) {
					Record r = new Record(i + 1, "Name " + i, "female");
					lst.add(r);
					if (i > 5) r.setGender("male");
				}
				return new TableData(lst, false, lst.size());
			}
		});
		
		lkField.setPropertyName("name");
		
		Label lblFocus = new Label();
		Label lblValue = new Label();
		lkField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			lblFocus.setText(newValue ? "Focused" : "Not focused");
		});
		
		lblValue.textProperty().bind(lkField.valueProperty().asString());
		
		Button btn = new Button();
		btn.setText("Say 'Hello World'");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println(lkField.getValue());
			}
		});
		
		VBox root = new VBox();
		root.setSpacing(10);
		root.setPadding(new Insets(10));
		root.getChildren().addAll(new TextField(), lkField, lblFocus, lblValue,btn);
		
		Scene scene = new Scene(root, 300, 250);
		TiwulFXUtil.setTiwulFXStyleSheet(scene);
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
	
	public static class Record {
		private int id;
		private String name;
		private String gender;

		public Record() {
		}

		public Record(int id, String name, String gender) {
			this.id = id;
			this.name = name;
			this.gender = gender;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Record{" + "id=" + id + ", name=" + name + ", gender=" + gender + '}';
		}
		
	}
	
}
