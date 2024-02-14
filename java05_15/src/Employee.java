public class Employee {
    
    private static int staticCounter;
    private int id;
    private String name;
    private String email;
    private String address;

    {
        incrementStaticCounter();
        assignId();
    }

    Employee(String name, String email, String address){

        this.name = name;
        this.email = email;
        this.address = address;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getAddress(){
        return this.address;
    }

    private void assignId(){
        this.id = staticCounter;
    }

    private static void incrementStaticCounter(){
        staticCounter++;
    }

    static class Validator {

        public void showValidatedResult(Employee employee){

            boolean isNotValid = false;
            if(!isValidName(employee.getName())){
                System.out.printf(
                        "従業員ID %d に名前が設定されていません. %n",
                        employee.id
                    );
                
                    isNotValid = true;
            }

            if(!isValidEmail(employee.getEmail())){
                System.out.printf(
                    "従業員ID %d にメールアドレスが設定されていません. %n",
                    employee.id
                );
            
                isNotValid = true;
            }

            if (isNotValid) return;

            System.out.printf(
                    "従業員ID %d は正しく設定されています. %n",
                    employee.id
                );
        }

    private boolean isValidName(String name){
        
        if (name == null) return false;

        if (name.length() == 0) return false;

        return true;
    }

    private boolean isValidEmail(String email){
        
        if (email == null) return false;

        if (email.length() == 0) return false;

        return true;
    }

    }
}
