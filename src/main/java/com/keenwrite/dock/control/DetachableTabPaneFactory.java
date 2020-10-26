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

/**
 * Factory responsible to Instantiate new DetachableTabPane when a Tab is
 * detached/docked. Extend this class then implement
 * {@link #init(DetachableTabPane)} method.
 *
 * @author amrullah
 * @author Dave Jarvis
 */
public abstract class DetachableTabPaneFactory {

  DetachableTabPane create( final DetachableTabPane source ) {
    final var tabPane = new DetachableTabPane();
    tabPane.setSceneFactory( source.getSceneFactory() );
    tabPane.setStageOwnerFactory( source.getStageOwnerFactory() );
    tabPane.setScope( source.getScope() );
    tabPane.setTabClosingPolicy( source.getTabClosingPolicy() );
    tabPane.setCloseIfEmpty( true );
    tabPane.setDetachableTabPaneFactory( source.getDetachableTabPaneFactory() );
    init( tabPane );
    return tabPane;
  }

  /**
   * Callback method to initialize newly created DetachableTabPane for the Tab
   * that is being detached/docked.
   */
  protected abstract void init( final DetachableTabPane newTabPane );
}
