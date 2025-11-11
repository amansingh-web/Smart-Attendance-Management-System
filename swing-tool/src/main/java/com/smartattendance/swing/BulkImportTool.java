package com.smartattendance.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class BulkImportTool extends JFrame {
    private JTextArea log = new JTextArea(12, 40);
    public BulkImportTool() {
        super("Smart Attendance — Bulk Import (Swing + JDBC)");
        JButton choose = new JButton("Choose CSV & Import");
        choose.addActionListener(e -> importCSV());
        add(choose, BorderLayout.NORTH);
        add(new JScrollPane(log), BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
    private void importCSV() {
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_db","root","password");
                String line; int count=0;
                while((line=br.readLine())!=null){
                    String[] p = line.split(",");
                    if(p.length<4) continue;
                    PreparedStatement ps = con.prepareStatement("INSERT INTO student(name, roll_no, course, semester) VALUES(?,?,?,?)");
                    ps.setString(1,p[0]); ps.setString(2,p[1]); ps.setString(3,p[2]); ps.setString(4,p[3]);
                    ps.executeUpdate(); count++;
                }
                log.append("Imported "+count+" students\n");
                con.close();
            } catch(Exception ex){ log.append("Error: "+ex.getMessage()+"\n"); }
        }
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new BulkImportTool().setVisible(true)); }
}
