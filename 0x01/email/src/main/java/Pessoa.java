public class Pessoa {
    
    /**
     * Valida se um email é válido.
     * 
     * @param email Email a ser validado
     * @return true se o email é válido, false caso contrário
     */
    public static boolean emailValid(String email) {
        if (email == null) {
            return false;
        }
        
        // Verifica se o email possui no máximo 50 caracteres
        if (email.length() > 50) {
            return false;
        }
        
        // Verifica se existe o "@" no valor de entrada
        if (!email.contains("@")) {
            return false;
        }
        
        return true;
    }
}
