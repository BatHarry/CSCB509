package com.sewingfactory.UI.Scenes;

import javafx.scene.layout.VBox;

public abstract class BaseScene extends VBox {
    public BaseScene() {
        super();
        this.setSpacing(10);
    }

    public void refresh() {};
}
