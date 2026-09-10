package shop;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    Map<String, String> errors = new HashMap<>();

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationExceptions(MethodArgumentNotValidException ex){
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();          // 例: "cart_quantity"
            String errorMessage = error.getDefaultMessage(); // 例: "99個までしか登録できません"
            errors.put(fieldName, errorMessage);
        });

        // 400 Bad Request ステータスと一緒に、エラーのJSONを返す
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
