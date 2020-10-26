/*
 * Copyright 2020 Panemu and White Magic Software, Ltd.
 * All rights reserved.
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
package com.keenwrite.dock.control;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Node;
import javafx.scene.control.Tab;

/**
 * @author amrullah
 */
public class DetachableTab extends Tab {
  private final BooleanProperty mDetachable = new SimpleBooleanProperty( true );

  public DetachableTab() {
  }

  public DetachableTab( String string ) {
    super( string );
  }

  public DetachableTab( String text, Node content ) {
    super( text, content );
  }

  public boolean isDetachable() {
    return mDetachable.get();
  }

  public void setDetachable( boolean detachable ) {
    mDetachable.set( detachable );
  }

  public BooleanProperty detachableProperty() {
    return mDetachable;
  }
}
