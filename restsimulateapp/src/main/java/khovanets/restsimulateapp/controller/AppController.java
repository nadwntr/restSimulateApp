package khovanets.restsimulateapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import khovanets.restsimulateapp.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class AppController {

    // Метод GET
    @GetMapping("/getMethod")
    public String getMethod() throws JsonProcessingException {
        // Создаем пользовательские данные для ответа
        User user = new User();
        user.setLogin("testlogin");
        user.setPassword("testpassword");

        // Вносим логин и пароль в упорядоченную хэш-таблицу
        LinkedHashMap<String, String> lhmap = new LinkedHashMap<>();
        lhmap.put("login", user.getLogin());
        lhmap.put("password", user.getPassword());

        // Формируем из хэш-таблицы json-ответ
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String result = ow.writeValueAsString(lhmap);

        // Возвращаем ответ
        return result;
    }

    // Метод POST
    @PostMapping("/postMethod")
    // Принимаем json с данными пользователя
    public String postMethod(@RequestBody User user) throws JsonProcessingException {
        // Получаем логин из принятого json
        String userLogin = user.getLogin();

        // Формируем текущую дату
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");
        String date = formatter.format(LocalDateTime.now());

        // Вносим логин и дату в упорядоченную хэш-таблицу
        LinkedHashMap<String, String> lhmap = new LinkedHashMap<>();
        lhmap.put("login", userLogin);
        lhmap.put("date", date);

        // Формируем из хэш-таблицы json-ответ
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String result = ow.writeValueAsString(lhmap);

        // Возвращаем ответ
        return result;
    }
}
