package com.codecool.battleofcards;

import java.util.List;
import java.util.ArrayList;


class CardsPrinter {


    private List<String> content;
    private int collumnsWidth[] = {0,0};
    private String toPrint;

    
    public CardsPrinter(List<String> content) {

        this.content = content;
        getCollumnsWidth();
    }

    public String getOutput() {
        return toPrint;
    }

    public void prepareToPrint() {
        
        List<String> table = new ArrayList<>();
        String fieldSeparator = "│";
        String rowSeparator = generateTopMiddleOrBottomLine("rowSeparator");
        int counter = 0;

        table.add(generateTopMiddleOrBottomLine("top"));
        for (String string : content) {
            table.add(fieldSeparator);
            table.add(centerField(string, collumnsWidth[counter]));
            counter ++;
            if (counter == 2) {
                table.add(fieldSeparator);
                table.add(rowSeparator);
                counter = 0;
            }
        }
        table.set(table.size() - 1, generateTopMiddleOrBottomLine("bottom"));
        toPrint =  String.join("", table);
    }

    private void getCollumnsWidth() {

        boolean flip = true;

        for (String string: content) {
            if (flip) {
                if (collumnsWidth[0] < string.length()) {
                    collumnsWidth[0] = string.length();
                    flip = !flip;
                }
            } else {
                if (collumnsWidth[1] < string.length()) {
                    collumnsWidth[1] = string.length();
                    flip = !flip;
                } 
            }  
        }
    }

    private String generateTopMiddleOrBottomLine(String modifier) {
        List<String> output = new ArrayList<>();
        String start;
        String middle;
        String end;

        switch (modifier) {
            case "top": default:
                start = "\n╭";
                middle = "┬";
                end = "╮\n";
                break;
            case "rowSeparator": 
                start = "\n├";
                middle = "┼";
                end = "┤\n";
                break;
            case "bottom": 
                start = "\n╰";
                middle = "┴";
                end = "╯\n";
                break;
        }
        output.add(start);
        for (Integer number : collumnsWidth) {
            int repetitions = number;
            while (repetitions > 0) {
                output.add("─");
                repetitions --;
            }
            output.add(middle);
        }
        output.set(output.size() - 1, end);
        return String.join("", output);
    }

    private String centerField(String field, int collumnWidth) {
        List<String> centeredField = new ArrayList<>();
        boolean flip = true;
        int repetitions = collumnWidth - field.length();
        int shift = 1;

        centeredField.add(field);
        while (repetitions > 0) {
            if (flip == true) {
                centeredField.add(centeredField.size() - shift, " ");
            } else {
                centeredField.add(" ");
            }
            flip = !flip;
            shift ++;
            repetitions --;
        }
        return String.join("", centeredField);
    }
}