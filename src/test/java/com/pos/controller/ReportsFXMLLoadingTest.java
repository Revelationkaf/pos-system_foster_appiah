package com.pos.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

class ReportsFXMLLoadingTest {

    @Test
    void loadsReportsViewWithoutException() throws Exception {
        FXMLLoader loader = new FXMLLoader(ReportsFXMLLoadingTest.class.getResource("/com/pos/view/reports.fxml"));
        Parent root = loader.load();

        assertNotNull(root);
        assertNotNull(loader.getController());
    }
}
