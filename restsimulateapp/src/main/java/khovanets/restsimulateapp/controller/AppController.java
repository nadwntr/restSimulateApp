package khovanets.restsimulateapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import khovanets.restsimulateapp.User;
import khovanets.restsimulateapp.UserForPOST;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class AppController {
    // Метод GET
    @GetMapping("/getMethod")
    public User getMethod() throws JsonProcessingException {
        // Создаем пользовательские данные для ответа
        User user = new User();
        user.setLogin("testLogin");
        user.setPassword("testPassword");

        // Возвращаем ответ
        return user;
    }

    // Метод POST
    @PostMapping("/postMethod")
    // Принимаем json с данными пользователя
    public UserForPOST postMethod(@RequestBody User user) throws JsonProcessingException {
        // Формируем текущую дату
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");
        String date = formatter.format(LocalDateTime.now());

        // Создаем ответ из принятого json
        UserForPOST postUser = new UserForPOST(user.getLogin(), date);

        // Возвращаем ответ
        return postUser;
    }
}
