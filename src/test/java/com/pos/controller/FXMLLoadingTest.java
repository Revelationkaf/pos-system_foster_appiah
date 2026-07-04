package com.pos.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

class FXMLLoadingTest {

    @BeforeAll
    static void initToolkit() {
        Platform.startup(() -> {});
    }

    @Test
    void loadsMainPosViewWithoutException() throws Exception {
        FXMLLoader loader = new FXMLLoader(FXMLLoadingTest.class.getResource("/com/pos/view/pos.fxml"));
        Parent root = loader.load();

        assertNotNull(root);
        assertNotNull(loader.getController());
    }
}
