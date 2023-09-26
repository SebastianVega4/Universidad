package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class EmailValidatorTest {
    @Test
    public void testValidarDireccionDeCorreoValida() {
        EmailValidator validator = new EmailValidator();
        String email = "ejemplo@example.com";
        assertTrue(validator.validar(email));
    }

    @Test
    public void testValidarDireccionDeCorreoInvalida() {
        EmailValidator validator = new EmailValidator();
        String email = "correo_invalido";
        assertFalse(validator.validar(email));
    }
}
