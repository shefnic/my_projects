/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nshefte;

import java.io.BufferedReader;
import java.util.ArrayDeque ;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Input a csv 'text' file and return a 2-day array
 * Allow for column and row headers
 * 
 * @author Nicholas
 */
public class CSVParser {
    
    private final static Logger LOGGER = Logger.getLogger(CSVParser.class.getName());
    
    private BufferedReader inCSV;
    private String[][] outCSV;
    
    public CSVParser() {
        inCSV = null;
        outCSV = null;
    }
    
    public CSVParser(BufferedReader inFile){
        outCSV = parse(inFile);
    }
    
    public String[][] parse(BufferedReader inFile){
        
        int maxDelim = 0;
        int maxRows = 0;
        String[][] output = null;
        ArrayDeque<String> tempList = new ArrayDeque(1);
        String line = null;
        String cell = "";
        boolean first = true;
        boolean quote = false;
        
        try {
            while((line = inFile.readLine()) != null){
                
                tempList.add(line);
                maxRows++;
                  
            }
        } catch (IOException ex) {
            Logger.getLogger(CSVParser.class.getName()).log(
                             Level.SEVERE, null, ex);
        }
        
        maxRows = tempList.size();
        
        output = new String[maxRows][];
        
        for(int i = 0; i < maxRows; i++){
            
//            if(first){
//                csvFSM unparsedLine = new csvFSM(tempList.pop());
//                maxDelim = unparsedLine.get_delimCount();
//                output[i] = unparsedLine.get_parsedLine();
//                unparsedLine = null;
//            }
//            else{
//                csvFSM unparsedLine = new csvFSM(tempList.pop(), maxDelim);
//                output[i] = unparsedLine.get_parsedLine();
//                unparsedLine = null;
//            }
                csvFSM unparsedLine = new csvFSM(tempList.pop());
                output[i] = unparsedLine.get_parsedLine();
                unparsedLine = null;
        }
        
        return output;
        
    }
    
    public String[][] getCSV(){
        return outCSV;
    }
        
}
