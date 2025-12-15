import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {
    
    private Person person;
    
    /**
     * Setup que roda antes de todos os testes
     */
    @Before
    public void setup() {
        // Cria uma data para o ano 2000
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1);
        Date birthDate = calendar.getTime();
        
        // Inicializa person com os valores especificados
        person = new Person(
            "Paul",
            "McCartney",
            birthDate,
            true,  // anotherCompanyOwner
            true,  // pensioner
            true,  // publicServer
            1200f  // salary
        );
    }
    
    /**
     * Testa se o método fullName() retorna "Paul McCartney"
     */
    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }
    
    /**
     * Testa se calculateYearlySalary retorna 14400 para salário mensal de 1200
     */
    @Test
    public void test_calculateYearlySalary() {
        person.setSalary(1200f);
        assertEquals(14400f, person.calculateYearlySalary(), 0.01f);
    }
    
    /**
     * Testa se a pessoa pode ser MEI (deve retornar true)
     * Altera os dados para tornar a pessoa elegível ao MEI
     */
    @Test
    public void person_is_MEI() {
        // Altera os dados para que a pessoa seja elegível ao MEI
        person.setSalary(5000f);  // Salário anual: 60.000 (< 130.000)
        person.setAnotherCompanyOwner(false);  // Não possui outra empresa
        person.setPensioner(false);  // Não é pensionista
        person.setPublicServer(false);  // Não é servidor público
        // Idade: 25 anos (> 18) - birthDate: 2000
        
        assertTrue(person.isMEI());
    }
    
    /**
     * Testa se a pessoa NÃO pode ser MEI (deve retornar false)
     * Mantém os dados do setup que tornam a pessoa inelegível
     */
    @Test
    public void person_is_not_MEI() {
        // Mantém os valores do setup:
        // anotherCompanyOwner: true (possui outra empresa)
        // pensioner: true (é pensionista)
        // publicServer: true (é servidor público)
        // Isso torna a pessoa inelegível ao MEI
        
        assertFalse(person.isMEI());
    }
}
