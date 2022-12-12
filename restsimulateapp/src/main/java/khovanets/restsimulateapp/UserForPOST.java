package khovanets.restsimulateapp;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserForPOST {
    private String login;
    private String date;
}
