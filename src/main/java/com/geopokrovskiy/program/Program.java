package com.geopokrovskiy.program;

import com.geopokrovskiy.model.LogicElement;
import com.geopokrovskiy.repository.ElementRepository;
import com.geopokrovskiy.util.AndFactory;
import com.geopokrovskiy.util.ElementFactory1;
import com.geopokrovskiy.util.OrFactory;
import com.geopokrovskiy.util.XorFactory;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        try {
            System.out.println("Simple factory demonstration");
            ElementRepository repository = new ElementRepository("input.csv");
            System.out.println(repository);
            var list = repository.getListOfElements();

            System.out.println();
            System.out.println("Result demonstration");
            for(LogicElement element : list){
                if(element != null) {
                    System.out.println(element.result());
                }
            }

            System.out.println();
            System.out.println("Union demonstration");
            int size = repository.getListOfElements().size();
            System.out.println(repository.getListOfElements().get(size - 1).union(repository.getListOfElements().get(size - 2)));

            System.out.println();
            System.out.println("HashMap factory demonstration");
            HashMap<String, ElementFactory1> hashMap = new HashMap<>();
            hashMap.put("OR", new OrFactory());
            hashMap.put("AND", new AndFactory());
            hashMap.put("XOR", new XorFactory());
            ElementRepository repository1 = new ElementRepository("input.csv", hashMap);
            System.out.println(repository1);
            System.out.println();

            System.out.println("Sorting demonstration");
            System.out.println("Without a comparator");
            System.out.println(repository.sort(null));
            System.out.println();


            Comparator<LogicElement> comparator = (o1, o2) -> o1.getLength() - o2.getLength();
            System.out.println("With a comparator");
            System.out.println(repository.sort(comparator));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}