package baitap.buoi3.util;

import java.util.ArrayList;
import java.util.List;

public class TableRenderer {
    private final String[] headers;
    private final int[] maxCap;
    private final List<String[]> rows = new ArrayList<>();

    public TableRenderer(String[] headers, int[] maxCap){
        this.headers = headers; this.maxCap = maxCap;
    }
    public void addRow(String[] row){ rows.add(row); }

    public String render(){
        int cols = headers.length;
        int[] width = new int[cols];
        for (int c=0;c<cols;c++) width[c]=Math.min(maxCap[c], headers[c].length());

        for (String[] r : rows)
            for (int c=0;c<cols;c++)
                for (String line : r[c].split("\n"))
                    width[c] = Math.min(maxCap[c], Math.max(width[c], line.length()));

        StringBuilder out = new StringBuilder();
        out.append(sep(width)).append("\n");
        out.append(row(headers,width)).append("\n");
        out.append(sep(width)).append("\n");
        for (String[] r : rows) {
            int h=1; for (String cell:r) h=Math.max(h, cell.split("\n").length);
            for (int i=0;i<h;i++){
                String[] parts = new String[cols];
                for (int c=0;c<cols;c++){
                    String[] lines = r[c].split("\n");
                    parts[c] = (i<lines.length)?lines[i]:"";
                }
                out.append(row(parts,width)).append("\n");
            }
            out.append(sep(width)).append("\n");
        }
        return out.toString();
    }
    private static String sep(int[] w){
        StringBuilder sb=new StringBuilder("+");
        for (int x:w) sb.append("-".repeat(x+2)).append("+");
        return sb.toString();
    }
    private static String row(String[] cells,int[] w){
        StringBuilder sb=new StringBuilder("|");
        for (int c=0;c<cells.length;c++) sb.append(" ").append(pad(cells[c],w[c])).append(" |");
        return sb.toString();
    }
    private static String pad(String s,int width){
        if (s.length()<=width) return s + " ".repeat(width - s.length());
        return s.substring(0, Math.max(0,width-1)) + "…";
    }
}
