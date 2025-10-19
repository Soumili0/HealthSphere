import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String fullName;

    private int age;
    private String gender;

    @Email
    private String email;

    @NotNull
    @Size(min = 10, max = 15)
    private String phone;

    private String address;
    private String medicalHistory;
}
