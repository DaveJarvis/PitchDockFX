package com.keenwrite.dock.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static java.lang.String.format;

public class Main extends Application {

  @Override
  public void start( Stage stage ) {
    final var pane = new MainPane();
    final var scene = new Scene( pane );
    final var stylesheets = scene.getStylesheets();
    stylesheets.add( getResource( "detachable-tab", "css" ) );
    stylesheets.add( getResource( "../dock", "css" ) );
    stage.setTitle( "Demo 1" );
    stage.setScene( scene );
    stage.setX( 10 );
    stage.setY( 10 );
    stage.show();
  }

  @SuppressWarnings("SameParameterValue")
  private static String getResource(
      final String filename, final String filetype ) {
    return format(
        "/%s/%s.%s",
        Main.class.getPackageName().replace( ".", "/" ),
        filename,
        filetype
    );
  }

  /**
   * The main() method is ignored in correctly deployed JavaFX application.
   * main() serves only as fallback in case the application can not be launched
   * through deployment artifacts, e.g., in IDEs with limited FX support.
   * NetBeans ignores main().
   *
   * @param args the command line arguments
   */
  public static void main( String[] args ) {
    launch( args );
  }
}
