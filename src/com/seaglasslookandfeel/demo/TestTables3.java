package com.seaglasslookandfeel.demo;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import sun.swing.table.DefaultTableCellHeaderRenderer;

public class TestTables3 {
    public static void main(String args[]) {
        if (true) {
            try {
                UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        final Object rows[][] = { { "one", "1" }, { "two", "2" }, { "three", "3" } };
        JFrame frame = new JFrame("Label Header");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String headers[] = { "Some text", "#" };
        JTable table = new JTable(rows, headers);
        JScrollPane scrollPane = new JScrollPane(table);

        TableModel tableModel = table.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
        table.setRowSorter(sorter);

        Icon redIcon = new ImageIcon(TestTables3.class.getResource("/com/seaglasslookandfeel/images/gear.png"));
        Icon blueIcon = new ImageIcon(TestTables3.class.getResource("/com/seaglasslookandfeel/images/Event.png"));

        Border headerBorder = UIManager.getBorder("TableHeader.cellBorder");

        JLabel blueLabel = new JLabel(headers[0], blueIcon, JLabel.LEADING);
        blueLabel.setBorder(headerBorder);

        TableColumnModel columnModel = table.getColumnModel();

        TableColumn column0 = columnModel.getColumn(0);
        TableColumn column1 = columnModel.getColumn(1);

        column0.setHeaderValue(blueLabel);
        column1.setHeaderValue(redIcon);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}
