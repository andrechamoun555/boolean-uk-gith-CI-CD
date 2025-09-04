
package org.booleanuk.demo;

import org.booleanuk.demo.controller.StatusController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(StatusController.class)
public class StatusControllerTest {

    private StatusController statusController;

    public StatusControllerTest() {
        statusController = new StatusController();
    }

    @Test
    void statusControllerReturn() throws Exception {
        Assertions.assertEquals("Service is active", statusController.status());
    }
}
