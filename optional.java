import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.SortedMap;
import java.util.function.Consumer;

class optional {

   static  Comparator<Student> s=Comparator.comparing(Student::getName);
   static Comparator<Student> s1=Comparator.comparing(Student::getGpa);

    static Optional<String> optionaltry() {

        Optional<Student> s = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        if (s.isPresent())
            return s.map(Student::getName);

        return Optional.empty();

    }

    public static void main(String[] args) {
       // System.out.println(optionaltry());
       sortmethod();

    }

   static void sortmethod(){
        List<Student> n=StudentDataBase.getAllStudents();
        // n.sort((s1,s2)->s2.getName().compareTo(s1.getName()));
         //System.out.println(n);
        n.sort(s.thenComparing(s1));
        n.forEach(s->System.out.println(s));

    }
}