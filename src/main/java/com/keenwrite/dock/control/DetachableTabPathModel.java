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

import javafx.scene.shape.*;

/**
 * @author amrullah
 * @author Dave Jarvis
 */
class DetachableTabPathModel {
  private double tabPos;
  private double width;
  private double height;
  private double startX;
  private double startY;
  private final Path mPath;

  public DetachableTabPathModel( final Path path ) {
    mPath = path;
    mPath.getStyleClass().add( "drop-path" );
  }

  void refresh( double startX, double startY, double width, double height ) {
    boolean regenerate = this.tabPos != -1
        || this.width != width
        || this.height != height
        || this.startX != startX
        || this.startY != startY;
    this.tabPos = -1;
    this.width = width;
    this.height = height;
    this.startX = startX;
    this.startY = startY;
    if( regenerate ) {
      generateTabPath( mPath, startX + 2, startY + 2, width - 4, height - 4 );
    }
  }

  void refresh( double tabPos, double width, double height ) {
    boolean regenerate = this.tabPos != tabPos
        || this.width != width
        || this.height != height;
    this.tabPos = tabPos;
    this.width = width;
    this.height = height;
    startX = 0;
    startY = 0;
    if( regenerate ) {
      generateTabPath( mPath, tabPos, width - 2, height - 2 );
    }
  }

  private static void generateTabPath(
      Path path, double startX, double startY, double width, double height ) {
    path.getElements().clear();
    MoveTo moveTo = new MoveTo();
    moveTo.setX( startX );
    moveTo.setY( startY );
    path.getElements().add( moveTo );//start
    path.getElements().add( new HLineTo( startX + width ) );//path width
    path.getElements().add( new VLineTo( startY + height ) );//path height
    path.getElements().add( new HLineTo( startX ) );//path bottom left
    path.getElements().add( new VLineTo( startY ) );//back to start
  }

  private static void generateTabPath(
      Path path, double tabPos, double width, double height ) {
    int tabHeight = 28;
    int start = 2;
    tabPos = Math.max( start, tabPos );
    path.getElements().clear();
    MoveTo moveTo = new MoveTo();
    moveTo.setX( start );
    moveTo.setY( tabHeight );
    path.getElements().add( moveTo );//start

    path.getElements().add( new HLineTo( width ) );//path width
    path.getElements().add( new VLineTo( height ) );//path height
    path.getElements().add( new HLineTo( start ) );//path bottom left
    path.getElements().add( new VLineTo( tabHeight ) );//back to start

    if( tabPos > 20 ) {
      path.getElements().add( new MoveTo( tabPos, tabHeight + 5 ) );
      path.getElements()
          .add( new LineTo( Math.max( start, tabPos - 10 ), tabHeight + 15 ) );
      path.getElements().add( new HLineTo( tabPos + 10 ) );
      path.getElements().add( new LineTo( tabPos, tabHeight + 5 ) );
    }
    else {
      double tip = Math.max( tabPos, start + 5 );
      path.getElements().add( new MoveTo( tip, tabHeight + 5 ) );
      path.getElements().add( new LineTo( tip + 10, tabHeight + 5 ) );
      path.getElements().add( new LineTo( tip, tabHeight + 15 ) );
      path.getElements().add( new VLineTo( tabHeight + 5 ) );
    }
  }
}
