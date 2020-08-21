package gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class TestFrm extends JFrame {
	JFrame f;
	JPanel jp;
	JList jl;
	JTextArea jt;
	
	public TestFrm() {
		f = new JFrame();
		jl = new JList();
		jp = new JPanel();
		jt = new JTextArea();
		//f.add(jl);
		showList();
		jp.setLayout(new BorderLayout());
		f.add(jp);
		f.add(jt);
		
		jl.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Account w = (Account)jl.getSelectedValue();
				jt.setText(w.toString());
			}
		});
		
		f.setSize(400, 400);
		createMenu();
		
		f.setVisible(true);
	}
	
	public void showList() {
		AccountDAO adao = new AccountDAO();
		jl.removeAll();
		List<Account> li = adao.getAllList();
		jl.setListData(li.toArray());
		f.add(new JScrollPane(jl));
	}
	
	void createMenu() {
		JMenuBar mb = new JMenuBar(); 
		JMenu screenMenu = new JMenu("Account");
		
		screenMenu.add(new JMenuItem("Load"));
		screenMenu.add(new JMenuItem("Hide"));
		screenMenu.add(new JMenuItem("ReShow"));
		screenMenu.addSeparator();
		screenMenu.add(new JMenuItem("Exit"));

		mb.add(screenMenu);
		mb.add(new JMenu("Edit"));
		mb.add(new JMenu("Source"));
		mb.add(new JMenu("Project"));
		mb.add(new JMenu("Run"));
		setJMenuBar(mb);
	}
}

public class MainProcess {
	LoginView loginView;
	TestFrm testFrm;

	public static void main(String[] args) {
		// 메인클래스 실행
		MainProcess main = new MainProcess();
		main.loginView = new LoginView(); // 로그인창 보이기
		main.loginView.setMain(main); // 로그인창에게 메인 클래스보내기
	}

	// 로그인 테스트프레임창
	public void showFrameTest(){
        loginView.dispose(); // 로그인창닫기
        this.testFrm = new TestFrm(); // 테스트프레임 오픈
    }
	
}
