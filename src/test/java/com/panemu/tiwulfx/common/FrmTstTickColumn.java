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

import com.panemu.tiwulfx.table.TableControl;
import com.panemu.tiwulfx.table.TableController;
import com.panemu.tiwulfx.table.TickColumn;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author amrullah
 */
public class FrmTstTickColumn extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		TableControl<Record> tbl = new TableControl<>(Record.class);
		TickColumn<Record> clm = new TickColumn<>();
		tbl.setController(new TableController<Record>() {

			@Override
			public TableData<Record> loadData(int startIndex, List<TableCriteria> filteredColumns, List<String> sortedColumns, List<TableColumn.SortType> sortingOrders, int maxResult) {
				List<Record> lst = new ArrayList<>();
				for (int i = 0; i < 10; i++) {
					lst.add(new Record());
				}
				return new TableData<>(lst, false, lst.size());
			}
		});
		tbl.getColumns().add(clm);
		ToggleButton btn = new ToggleButton("Disable Tick");
		clm.editableProperty().bind(btn.selectedProperty().not());
		tbl.addNode(btn);
		StackPane root = new StackPane();
		root.getChildren().add(tbl);
		
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
	
	private class Record{};
	
}
