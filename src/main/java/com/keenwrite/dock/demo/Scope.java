package com.keenwrite.dock.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Set;

/**
 * @author amrullah
 */
public class Scope extends VBox {
  public Scope() {
    final var clazz = Scope.class;
    final var resource = clazz.getResource( clazz.getSimpleName() + ".fxml" );
    final var fxmlLoader = new FXMLLoader( resource );
    fxmlLoader.setRoot( this );
    fxmlLoader.setController( this );

    try {
      fxmlLoader.load();
    } catch( IOException exception ) {
      throw new RuntimeException( exception );
    }
  }
}
