import java.util.Calendar;
import java.util.Date;

public class Person {
    
    private String name;
    private String surname;
    private Date birthDate;
    private boolean anotherCompanyOwner;
    private boolean pensioner;
    private boolean publicServer;
    private float salary;
    
    /**
     * Construtor padrão
     */
    public Person() {
    }
    
    /**
     * Construtor com parâmetros
     */
    public Person(String name, String surname, Date birthDate, boolean anotherCompanyOwner, 
                  boolean pensioner, boolean publicServer, float salary) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.anotherCompanyOwner = anotherCompanyOwner;
        this.pensioner = pensioner;
        this.publicServer = publicServer;
        this.salary = salary;
    }
    
    /**
     * Retorna o nome completo (nome + sobrenome)
     */
    public String fullName() {
        return name + " " + surname;
    }
    
    /**
     * Getter para salary
     */
    public float getSalary() {
        return salary;
    }
    
    /**
     * Setter para salary
     */
    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    /**
     * Calcula o salário anual (salário mensal * 12)
     */
    public float calculateYearlySalary() {
        return salary * 12;
    }
    
    /**
     * Calcula a idade da pessoa
     */
    private int getAge() {
        if (birthDate == null) {
            return 0;
        }
        
        Calendar birthCalendar = Calendar.getInstance();
        birthCalendar.setTime(birthDate);
        
        Calendar today = Calendar.getInstance();
        
        int age = today.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
        
        // Ajusta se ainda não fez aniversário este ano
        if (today.get(Calendar.MONTH) < birthCalendar.get(Calendar.MONTH) ||
            (today.get(Calendar.MONTH) == birthCalendar.get(Calendar.MONTH) &&
             today.get(Calendar.DAY_OF_MONTH) < birthCalendar.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }
        
        return age;
    }
    
    /**
     * Verifica se a pessoa pode ser MEI (Microempreendedor Individual)
     * 
     * Regras:
     * - Faturamento anual (salary * 12) < 130.000
     * - Idade > 18 anos
     * - Não pode ter participação em outra empresa (anotherCompanyOwner = false)
     * - Não pode ser pensionista (pensioner = false)
     * - Não pode ser servidor público (publicServer = false)
     */
    public boolean isMEI() {
        float yearlySalary = calculateYearlySalary();
        int age = getAge();
        
        return yearlySalary < 130000 &&
               age > 18 &&
               !anotherCompanyOwner &&
               !pensioner &&
               !publicServer;
    }
    
    // Getters e Setters adicionais
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public Date getBirthDate() {
        return birthDate;
    }
    
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    public boolean isAnotherCompanyOwner() {
        return anotherCompanyOwner;
    }
    
    public void setAnotherCompanyOwner(boolean anotherCompanyOwner) {
        this.anotherCompanyOwner = anotherCompanyOwner;
    }
    
    public boolean isPensioner() {
        return pensioner;
    }
    
    public void setPensioner(boolean pensioner) {
        this.pensioner = pensioner;
    }
    
    public boolean isPublicServer() {
        return publicServer;
    }
    
    public void setPublicServer(boolean publicServer) {
        this.publicServer = publicServer;
    }
}
