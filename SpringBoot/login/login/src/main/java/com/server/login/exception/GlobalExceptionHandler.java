package com.server.login.exception;


import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.server.login.exception.ErrorCode.DUPLICATE_RESOURCE;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * hibernate 관련 Exception
	 * * 데이터 관련 예외를 처리하는 메서드
	 *      * - ConstraintViolationException: 데이터베이스 제약 조건 위반 예외
	 *      * - DataIntegrityViolationException: 데이터 무결성 위반 예외
	 *      *
	 *      * @return ErrorResponse 응답 객체를 생성하여 반환합니다.
	 */
	@ExceptionHandler(value = { ConstraintViolationException.class, DataIntegrityViolationException.class })
	protected ResponseEntity<ErrorResponse> handleDataException() {
		log.error("handleDataException throw Exception : {}", DUPLICATE_RESOURCE);
		// DUPLICATE_RESOURCE 에러 코드를 사용하여 ErrorResponse를 생성하고 반환합니다.
		return ErrorResponse.toResponseEntity(DUPLICATE_RESOURCE);
	}


	/**
	 * 사용 방법
	 * 로직 내에서 throw new CustomException(ErrorCode.enum);
	 * * 커스텀 예외를 처리하는 메서드
	 *      * - CustomException: 직접 정의한 커스텀 예외 클래스
	 *      *
	 *      * @param exception 처리할 커스텀 예외
	 *      * @return ErrorResponse 응답 객체를 생성하여 반환합니다.
	 */
	@ExceptionHandler(value = { CustomException.class })
	protected ResponseEntity<ErrorResponse> handleCustomException(CustomException exception) {
		log.error("handleCustomException throw CustomException : {}", exception.getErrorCode());
		// 예외 객체에서 ErrorCode를 가져와서 ErrorResponse를 생성하고 반환합니다.
		return ErrorResponse.toResponseEntity(exception.getErrorCode());
	}

}
