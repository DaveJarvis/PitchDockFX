/*
 * Copyright 2020 Panemu and White Magic Software, Ltd.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.keenwrite.dock.demo;

import com.keenwrite.dock.control.DetachableTab;
import com.keenwrite.dock.control.DetachableTabPane;
import com.keenwrite.dock.control.DetachableTabPaneFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * @author amrullah
 */
public class MainPane extends VBox {

  @FXML
  private DetachableTabPane tpnScope1;

  @FXML
  private DetachableTabPane tpnScope2;

  @FXML
  private DetachableTabPane tpnNoScope;

  public MainPane() {
    final var clazz = MainPane.class;
    final var resource = clazz.getResource( clazz.getSimpleName() + ".fxml" );
    final var fxmlLoader = new FXMLLoader( resource );
    fxmlLoader.setRoot( this );
    fxmlLoader.setController( this );

    try {
      fxmlLoader.load();
    } catch( final Exception exception ) {
      throw new RuntimeException( exception );
    }

    init();
  }

  private void init() {
    tpnScope1.getTabs()
             .add( new DetachableTab( "1 Scope1", createTabContent() ) );
    tpnScope1.getTabs()
             .add( new DetachableTab( "2 Scope1", createTabContent() ) );

    tpnScope1.setSceneFactory( ( param ) -> {
      Scope frm = new Scope();
      SplitPane sp = new SplitPane( param );
      VBox.setVgrow( sp, Priority.ALWAYS );
      frm.getChildren().add( sp );
      return new Scene( frm );
    } );

    tpnScope1.setStageOwnerFactory( param -> {
      param.setTitle( "Custom Stage & Scene" );
      //return parent for the detached stage
      return getScene().getWindow();
    } );

    tpnScope2.getTabs()
             .add( new DetachableTab( "1 Scope2", createTabContent() ) );
    tpnScope2.getTabs()
             .add( new DetachableTab( "2 Scope2", createTabContent() ) );
    tpnScope2.setTabClosingPolicy( TabPane.TabClosingPolicy.ALL_TABS );
    tpnNoScope.getTabs()
              .add( new DetachableTab( "1 No Scope", createTabContent() ) );
    tpnNoScope.getTabs()
              .add( new DetachableTab( "2 No Scope", createTabContent() ) );
    tpnNoScope.getTabs().add( new Tab( "traditional tab" ) );
    tpnNoScope.setTabClosingPolicy( TabPane.TabClosingPolicy.UNAVAILABLE );
    tpnNoScope.setDetachableTabPaneFactory( new DetachableTabPaneFactory() {
      @Override
      protected void init( DetachableTabPane newTabPane ) {
        newTabPane.setTabClosingPolicy( TabPane.TabClosingPolicy.SELECTED_TAB );
      }
    } );
  }

  private Control createTabContent() {
    return new ColorPicker();
  }
}
