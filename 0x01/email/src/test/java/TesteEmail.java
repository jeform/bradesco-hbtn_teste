import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TesteEmail {
    
    /**
     * Verifica se o método emailValid() ao receber como parâmetro 
     * "email_teste@dominio.com.br" retorna true
     */
    @Test
    public void testar_email_com_arroba() {
        assertTrue(Pessoa.emailValid("email_teste@dominio.com.br"));
    }
    
    /**
     * Verifica se o método emailValid() ao receber como parâmetro 
     * "email_testedominio.com.br" retorna false
     */
    @Test
    public void testar_email_sem_arroba() {
        assertFalse(Pessoa.emailValid("email_testedominio.com.br"));
    }
    
    /**
     * Verifica se o método emailValid() ao receber como parâmetro 
     * "email_teste_muito_longo_nao_deve_ser_valido@dominio.com.br" retorna false
     */
    @Test
    public void testar_email_mais_50_caracteres() {
        assertEquals(false, Pessoa.emailValid("email_teste_muito_longo_nao_deve_ser_valido@dominio.com.br"));
    }
}
