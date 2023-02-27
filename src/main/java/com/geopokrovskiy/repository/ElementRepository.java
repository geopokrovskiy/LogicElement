package com.geopokrovskiy.repository;

import com.geopokrovskiy.model.And;
import com.geopokrovskiy.model.LogicElement;
import com.geopokrovskiy.model.Or;
import com.geopokrovskiy.model.Xor;
import com.geopokrovskiy.util.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * ElementRepository class in the Repository package.
 * The list of logical elements acts as a class field.
 */
public class ElementRepository{
    private ArrayList<LogicElement> listOfElements = new ArrayList<>();

    /**
     * The constructor takes the CSV file name at the input, where the entries of logical elements are located,
     * as well as Map<string, elementFactory> map, where Map is a dictionary,
     * storing the names of the types of logical elements and factories associated with them,
     * String - a type of logical element,
     * and elementFactory - implementation of the factory interface for this element
     * @param filename
     * @param map
     */
    public ElementRepository(String filename, HashMap<String, ElementFactory1> map){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))){
            while(bufferedReader.ready()){
                String line = bufferedReader.readLine();
                String[] entryStrings = line.split(";");
                String factoryType = entryStrings[0].toUpperCase();
                int numberOfEntriesInElement = entryStrings.length - 1;
                ElementFactory1 factory = map.get(factoryType);
                LogicElement logicElement = factory.newInstance(numberOfEntriesInElement);
                boolean[] entriesOfLogicElement = new boolean[numberOfEntriesInElement];
                for(int i = 0; i < numberOfEntriesInElement; i++){
                    entriesOfLogicElement[i] = Boolean.parseBoolean(entryStrings[i + 1]);
                }
                logicElement.fill(entriesOfLogicElement);
                this.listOfElements.add(logicElement);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Overload of the constructor, which accepts the name of the CSV file at the entrance, where the entries of logical elements are located,
     * and makes the list of logical elements without using the factory dictionary, but using a simple factory
     * @param filename
     */
    public ElementRepository(String filename) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))){
            while(bufferedReader.ready()){
                String line = bufferedReader.readLine();
                String[] entriesStrings = line.split(";");
                int lengthOfLogicElement = entriesStrings.length - 1;
                boolean[] entriesBooleans = new boolean[lengthOfLogicElement];
                for(int i = 0; i < lengthOfLogicElement; i++){
                    entriesBooleans[i] = (Boolean.parseBoolean(entriesStrings[i + 1]));
                }
                LogicElement logicElement = null;
                try {
                    logicElement = Elements.newInstance(LogicOperation.valueOf(entriesStrings[0].toUpperCase()), lengthOfLogicElement);
                } catch (IllegalArgumentException ignored) {
                }
                try {
                    logicElement.fill(entriesBooleans);
                } catch (NullPointerException ignored) {
                }
                this.listOfElements.add(logicElement);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<LogicElement> getListOfElements() {
        return listOfElements;
    }

    public void setListOfElements(ArrayList<LogicElement> listOfElements) {
        this.listOfElements = listOfElements;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < this.listOfElements.size(); i++){
            str += this.listOfElements.get(i);
            str += "\n";
        }
        return str;
    }

    /**
     * In the repository class, implement the sort method, which takes on the input implementation of the Comparator interface
     * and does the list of the list with this object if it is not NULL, or by the compareTo method otherwise
     * @param comparator
     * @return
     */
    public ArrayList<LogicElement> sort(Comparator<LogicElement> comparator){
        if(comparator == null){
            this.listOfElements.sort(new Comparator<LogicElement>() {
                @Override
                public int compare(LogicElement o1, LogicElement o2) {
                    return o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());
                }
            });
        }
        else {
            this.listOfElements.sort(comparator);
        }
        return this.listOfElements;
    }
}
