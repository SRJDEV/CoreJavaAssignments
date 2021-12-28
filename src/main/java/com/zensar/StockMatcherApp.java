
package com.zensar;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.management.modelmbean.ModelMBean;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class StockMatcherApp extends JFrame {
	static JTable buySellTable;
	JTable orderMatcherTable;
	static Container contentPane;

	static JScrollPane spBuySell;
	JScrollPane spOrderMatcher;

	static String[] stockColumnNames = { "Stock Name", "Buy price", "Sell price" };
	static String[] orderMatchColumnNames = { "Stock Name", "Order Price", "Order Match Count" };
	
	static BuySellTableModel model;
	static OrderPriceTableModel modelMatcher;
	
	public StockMatcherApp() {

		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		

		 model = new BuySellTableModel();
		
		buySellTable = new JTable(model);
		spBuySell = new JScrollPane(buySellTable);

		spBuySell.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Stock Buy/Sell Table"));
	

		
		
		
		modelMatcher = new OrderPriceTableModel();
		
		
		orderMatcherTable = new JTable(modelMatcher);
		
		spOrderMatcher = new JScrollPane(orderMatcherTable);

		spOrderMatcher
				.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Order Matcher Table"));

	

		contentPane.add(spBuySell);
		contentPane.add(spOrderMatcher);
		

		
		

	   

	}

	public static void updateBuySellTable(String[][] stockData) {

		System.out.println("Updating BuySell Table");

        
		 model.stockData = stockData;

		if(buySellTable!=null) {
		 System.out.println("Repaint Called");
			model.fireTableDataChanged();
		 
		}
		
		
//		contentPane.setVisible(true);
//	    contentPane.repaint();

	}

	public static void updateMatcherTable(String[][] orderMatchData) {

		modelMatcher.orderMatcherData = orderMatchData;
		modelMatcher.fireTableDataChanged();
		
		
	}

	public static void main(String[] args) {

		JFrame jframe = new StockMatcherApp();

		jframe.setBounds(200, 200, 1000, 300);
		jframe.setTitle("Stock Price App");
		jframe.setVisible(true);

		App app = new App();
	}
	
	static class BuySellTableModel extends AbstractTableModel{

		
		public String[][] stockData = {
				{ "IBM", "12", "11"},
				{ "Reliance", "55", "53" },
				{ "TCS", "23", "23" },
				{ "Wipro", "17", "15" },
				{ "Zensar", "74", "70" }
		};

		public int getRowCount() {
			// TODO Auto-generated method stub
			return stockData.length;
		}

		public int getColumnCount() {
			// TODO Auto-generated method stub
			return stockColumnNames.length;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			  return stockData[rowIndex][columnIndex];
		}
		@Override
		public String getColumnName(int column) {
			// TODO Auto-generated method stub
			return stockColumnNames[column];
		}
		
	    public Class getColumnClass(int c) {
	        return getValueAt(0, c).getClass();
	    }
	
		
	}
	static class OrderPriceTableModel extends AbstractTableModel{

		
		public String[][] orderMatcherData = {
				{ "IBM", "12", "0"},
				{ "Reliance", "55", "0" },
				{ "TCS", "23", "0" },
				{ "Wipro", "17", "0" },
				{ "Zensar", "74", "0" }
		};

		public int getRowCount() {
			// TODO Auto-generated method stub
			return orderMatcherData.length;
		}

		public int getColumnCount() {
			// TODO Auto-generated method stub
			return orderMatchColumnNames.length;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			  return orderMatcherData[rowIndex][columnIndex];
		}
		@Override
		public String getColumnName(int column) {
			// TODO Auto-generated method stub
			return orderMatchColumnNames[column];
		}
		
	    public Class getColumnClass(int c) {
	        return getValueAt(0, c).getClass();
	    }
	
		
	}

}