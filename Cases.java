import java.util.ArrayList;

public class Cases {
    ArrayList<Integer> cases = new ArrayList<Integer>();

    Cases () {
        cases.add(1);
        cases.add(5);
        cases.add(10);
        cases.add(50);
        cases.add(100);
        cases.add(500);
}

public String getCaseValue (Integer index) {
    Integer temp = cases.get(index - 1);
    
    return Integer.toString(temp);
}


}

   



