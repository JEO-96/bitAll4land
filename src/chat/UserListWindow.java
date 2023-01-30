package chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class UserListWindow extends JFrame {
	private JPanel jp, jp2;
	private Vector<String> userListVector = new Vector<String>();
	private MultiClient mc;
	private String reciveUser;
	private ArrayList<String> userLIst = new ArrayList<String>();
	private Vector<String> returnColumn;
	private JTable table;
	private DefaultTableModel model;
	
	public UserListWindow(MultiClient mc) {

		getUserList(userListVector);
		setTitle("사용자 정보");
		this.mc = mc;
		jp = new JPanel();
		jp2 = new JPanel();
		jp.setLayout(new BorderLayout());
		jp.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		returnColumn = new Vector<String>();
		setTableColumn();
		
		JScrollPane jsp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		jp.add(jsp, BorderLayout.CENTER);
		jp.add(jp2, BorderLayout.SOUTH);
		add(jp);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		pack();
		setSize(800,800);
		setLocation((screenWidth - getWidth()) / 2, (screenHeight - getHeight()) / 2);
		setVisible(true);
	}
	
	private void setTableColumn() {
		returnColumn.add("ID");
		returnColumn.add("이름");
		returnColumn.add("강퇴 횟수");
		returnColumn.add("마지막 접속일");
		
		model = new DefaultTableModel(returnColumn, 0) {
			public boolean isCellEditable(int r, int c) {
				return false;
			}
		};
		
		// 테이블 생성
		String strRetable = "SELECT * FROM users order by last_login DESC";
		reTable(strRetable);
		
		table.getTableHeader().setReorderingAllowed(false);	// 테이블 편집 불가
		table.setFillsViewportHeight(true);	// 테이블 배경색
		JTableHeader tableHeader = table.getTableHeader();	// 테이블 헤더 값 가져오기
	}
	
	private void reTable(String strRetable) {
	      model.setNumRows(0);

	      ResultSet rs = DB.getResultSet(strRetable);
	      String[] rsArr = new String[4]; // 값 받아올 배열
	      
	      try {
	         
	         
	         while(rs.next()) {
	            
	            rsArr[0] = rs.getString(1);
	            rsArr[1] = rs.getString(2);
	            rsArr[2] = rs.getString(4).toString();
	            if(rs.getString(5) == null) {
	               rsArr[3] = "";
	            }else {
	               rsArr[3] = rs.getString(5).toString().substring(0, 16);
	            }
	            
	            
	            model.addRow(rsArr); // 모델에 배열 추가
	         }
	         
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }

	      table = new JTable(model);
	   }

	private void getUserList(Vector<String> vstr) { // DB에서 유저의 목록을 가져오기
		ResultSet rs = DB.getResultSet("SELECT nickname FROM users");
		try {
			while (rs.next()) {
				vstr.add(rs.getString("nickname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
