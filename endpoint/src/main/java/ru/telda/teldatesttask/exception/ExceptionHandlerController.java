package ru.telda.teldatesttask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Контроллер-обработчик ошибки парсинга тела запоса.
 */
@ControllerAdvice
public class ExceptionHandlerController {

	/**
	 * Возвращает ответ со статусом BAD_REQUEST и пояснительным сообщением.
	 */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Запрос содержит недопустимые значения полей!")
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public void handleBadRequest(){}

}
