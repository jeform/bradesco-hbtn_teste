import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonTest {
    
    private static Person person;
    
    /**
     * Setup que roda antes de todos os testes
     */
    @BeforeAll
    public static void setup() {
        person = new Person();
    }
    
    /**
     * Testa usuários válidos (devem passar)
     * Valores: "PaulMcCartney2", "NeilArms2"
     */
    @ParameterizedTest
    @ValueSource(strings = {"PaulMcCartney2", "NeilArms2"})
    void check_user_valid(String user) {
        assertTrue(person.checkUser(user));
    }
    
    /**
     * Testa usuários inválidos (não devem passar)
     * Valores: "Paul#McCartney", "Neil@Arms"
     */
    @ParameterizedTest
    @ValueSource(strings = {"Paul#McCartney", "Neil@Arms"})
    void check_user_not_valid(String user) {
        assertFalse(person.checkUser(user));
    }
    
    /**
     * Testa senhas que não possuem letras (não devem passar)
     * Valores: "123456789", "#$%1234"
     */
    @ParameterizedTest
    @ValueSource(strings = {"123456789", "#$%1234"})
    void does_not_have_letters(String password) {
        assertFalse(person.checkPassword(password));
    }
    
    /**
     * Testa senhas que não possuem números (não devem passar)
     * Valores: "Abcabcdefgh@", "#hbtn@%tc"
     */
    @ParameterizedTest
    @ValueSource(strings = {"Abcabcdefgh@", "#hbtn@%tc"})
    void does_not_have_numbers(String password) {
        assertFalse(person.checkPassword(password));
    }
    
    /**
     * Testa senhas que não possuem 8 caracteres (não devem passar)
     * Valores: "Abc@123", "12$@hbt"
     */
    @ParameterizedTest
    @ValueSource(strings = {"Abc@123", "12$@hbt"})
    void does_not_have_eight_chars(String password) {
        assertFalse(person.checkPassword(password));
    }
    
    /**
     * Testa senhas válidas (devem passar)
     * Valores: "abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123"
     */
    @ParameterizedTest
    @ValueSource(strings = {"abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123"})
    void check_password_valid(String password) {
        assertTrue(person.checkPassword(password));
    }
}
