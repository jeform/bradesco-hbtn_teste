public class Person {
    
    private String user;
    private String password;
    
    /**
     * Construtor padrão
     */
    public Person() {
    }
    
    /**
     * Construtor com parâmetros
     */
    public Person(String user, String password) {
        this.user = user;
        this.password = password;
    }
    
    /**
     * Valida o nome de usuário
     * 
     * Regras:
     * - Ter no mínimo 8 caracteres
     * - Não deve conter caractere especial
     * 
     * @param user Nome de usuário a ser validado
     * @return true se o usuário é válido, false caso contrário
     */
    public boolean checkUser(String user) {
        if (user == null) {
            return false;
        }
        
        // Verifica se tem no mínimo 8 caracteres
        if (user.length() < 8) {
            return false;
        }
        
        // Verifica se não contém caracteres especiais
        // Permite apenas letras (maiúsculas e minúsculas) e números
        if (!user.matches("^[a-zA-Z0-9]+$")) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Valida a senha
     * 
     * Regras:
     * - Deve possuir pelo menos 1 letra maiúscula
     * - Deve possuir pelo menos 1 número
     * - Deve possuir pelo menos 1 caractere especial
     * - Ter no mínimo 8 caracteres
     * 
     * @param password Senha a ser validada
     * @return true se a senha é válida, false caso contrário
     */
    public boolean checkPassword(String password) {
        if (password == null) {
            return false;
        }
        
        // Verifica se tem no mínimo 8 caracteres
        if (password.length() < 8) {
            return false;
        }
        
        // Verifica se possui pelo menos 1 letra maiúscula
        boolean hasUpperCase = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
                break;
            }
        }
        if (!hasUpperCase) {
            return false;
        }
        
        // Verifica se possui pelo menos 1 número
        boolean hasNumber = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumber = true;
                break;
            }
        }
        if (!hasNumber) {
            return false;
        }
        
        // Verifica se possui pelo menos 1 caractere especial
        // Caractere especial é qualquer caractere que não seja letra ou número
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
                break;
            }
        }
        if (!hasSpecialChar) {
            return false;
        }
        
        return true;
    }
    
    // Getters e Setters
    
    public String getUser() {
        return user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
