package com.ssafy.happyhouse.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.ssafy.happyhouse.model.dto.Env;

public class EnvInfoView extends JFrame {
	static LinkedList<Env> list;

	public EnvInfoView() {
		setTitle("환경 지도점검 내역 현황");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getList();

		JFrame jf = new JFrame();
		JPanel p = new JPanel();
		JList li = new JList();

		JTextArea ta = new JTextArea("");

		li.removeAll();
		li.setListData(list.toArray());
		li.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Env n = (Env) li.getSelectedValue();
				ta.setText(n.getDescription());
			}
		});

		ta.setLineWrap(true);
		p.setLayout(new BorderLayout());
		p.add(new JScrollPane(li));
		jf.setLayout(new GridLayout(2, 1, 8, 2));
		jf.add(p);
		jf.add(ta);
		jf.setSize(800, 500);
		jf.setVisible(true);

	}

	public static void getList() {
		list = new LinkedList<>();

		String csvFileName = "res/서울시 영등포구 환경 지도점검 내역 현황.csv";
		StringTokenizer st;
		try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				Env env = new Env();
				String[] values = line.split(",");
				env.setName(values[0]);
				env.setClas(values[3]);
				env.setDate(values[4]);
				env.setCheck(values[7]);
				st = new StringTokenizer(values[12], " ");
				int cnt = 0;
				String dong = "";
				while (st.hasMoreTokens()) {
					if (cnt == 2) {
						dong = st.nextToken();
						int nxt = dong.indexOf('동');
						dong = dong.substring(0, nxt + 1);
					}
					st.nextToken();
					cnt++;
				}
				if (dong.length() < 1)
					continue;
				env.setAddress(dong);
				list.add(env);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
//
//class EnvInfoViewMain {
//	public static void main(String[] args) {
//		new EnvInfoView();
//	}
//}
