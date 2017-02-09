/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nshefte;

/**
 * Uses FSM principles to parse a String array in to 
 * comma-separated String array 'cells'
 * 
 * TODO: Refactor to use Chars instead of Strings
 * TODO: Thread states to ensure no race conditions between
 * accessing delim count or output and the processing of input
 * 
 * @author Nicholas
 */
public class csvFSM {
    
    private String[] input;
    private String[][] output;
    private int delimCount;
    private int pos;
    
    public csvFSM(String[] in){
        delimCount = 0;
        pos = 0;
        input = new String[in.length];
        output = new String[in.length][in.length];
        
        System.arraycopy(in, 0, input, 0, in.length);
        
        state_i();
                
    }
    
    /**
     * Initial state: Checks for empty array and evaluates first character
     * If the character is ',' move to state 1
     * If the character is '"' move to state 3
     * Otherwise, move to state 2
     * 
     */
    private void state_i(){
        
    }
    
    /**
     * State at ','
     * Tallies delimiter then advances on the array
     * If ',' then stay in state 1
     * If '"' then move to state 3
     * If not at the end of the array, move to state 2
     * Otherwise, if EOL move to final state
     * 
     */
    private void state_1(){
        
    }
    
    /**
     * State when in between delimiters
     * Moves characters to output array
     * If ',' move to state 1
     * If end of array, then move to final state
     * Otherwise, stay in state 2
     * 
     */
    private void state_2(){
        
    }
    
    /**
     * State in between delimiters of a 'cell' surrounded in quotations
     * Moves characters, including ',' in to output array
     * If '"' then moves to state 4
     * Otherwise, stay in state 3
     * 
     * TODO: If end of array met before a closing '"' is found, insert the
     * '"' to the beginning of the output array 'cell' and move to final state
     * 
     */
    private void state_3(){
        
    }
    
    /**
     * State that determines if the '"' from state 3 should be put in to
     * output array or is the closing quotation of the 'cell'
     * If the subsequent character is a ',' then move to state 1
     * If the end of array is met, then move to final state
     * Otherwise, add '"' to output array and move to state 3
     * 
     */
    private void state_4(){
        
    }
    
    /**
     * Copies the output array to one of appropriate size
     */
    private void state_f(){
        
    }
    
    public int get_delimCount(){
        return delimCount;
    }
    
}
