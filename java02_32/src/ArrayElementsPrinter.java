public class ArrayElementsPrinter {
    public static void main(String[] args) {
        
        String[] dogTypes = {
            "Chiwawa",
            "Pomeranian",
            "Bulldog",
            "Akita",
            "Poodle"
        };

        for(int i=0; i<dogTypes.length; i++){
            System.out.printf("dogTypes の %d 番目の犬種は %s です. %n", i+1, dogTypes[i]);
        }
    }
}
