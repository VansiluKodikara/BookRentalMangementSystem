package holder;

import javafx.scene.layout.AnchorPane;

public class PaneHolder {
    private static AnchorPane dashRoot;

    public static void setDashRoot (AnchorPane pane) {
        dashRoot = pane;
    }

    public static AnchorPane getPane(){
        return dashRoot;
    }
}
