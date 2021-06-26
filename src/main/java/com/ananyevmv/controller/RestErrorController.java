package com.ananyevmv.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер ошибок
 */
@RestController
public class RestErrorController implements ErrorController {
    /**
     * Метод-обработчик ошибок выбрасывает исключение, которое перехватит com.ananyevmv.aop.RestExceptionHandler
     */
    @RequestMapping("/error")
    public void handleError() {
        throw new RuntimeException("BAD REQUEST");
    }

}
