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

import com.panemu.tiwulfx.control.TypeAheadField;
import com.panemu.tiwulfx.table.TableControl;
import com.panemu.tiwulfx.table.TableController;
import com.panemu.tiwulfx.table.TextColumn;
import com.panemu.tiwulfx.table.TypeAheadColumn;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author amrullah
 */
public class FrmTableView extends Application {

	@Override
	public void start(Stage primaryStage) {
		TableView<Record> tbl = new TableView<>();
//		TextColumn<Record> clm2 = new TextColumn<>("name");
		/*tbl.setController(new TableController<Record>() {
		
		@Override
		public TableData<Record> loadData(int startIndex, List<TableCriteria> filteredColumns, List<String> sortedColumns, List<TableColumn.SortType> sortingOrders, int maxResult) {
		List<Record> lst = new ArrayList<>();
		
		for (int i = 0; i < 3; i++) {
		lst.add(new Record("Name " + i +"\nLorem ipsum dolor sit amet", "option" + i));
		clmCmb.addItem("OPTION " + i, "option" + i);
		}
		return new TableData<>(lst, false, lst.size());
		}
		
		@Override
		public List<Record> update(List<Record> records) {
		return records;
		}
		
		});*/
		List<Record> lst = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			lst.add(new Record("Name " + i + "\nLorem ipsum dolor sit amet", "option" + i));
		}
		TableColumn<Record, String> clmOri = new TableColumn<>("Ori");
		clmOri.setCellValueFactory(new PropertyValueFactory<>("name"));
//		tbl.getColumns().addAll(clm, clm2);
		tbl.getColumns().addAll(clmOri);
		tbl.getItems().setAll(lst);
		StackPane root = new StackPane();
		root.getChildren().add(tbl);
		TiwulFXUtil.setApplicationId("tiwulfx-samples", null);
		Scene scene = new Scene(root, 500, 250);
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

}
