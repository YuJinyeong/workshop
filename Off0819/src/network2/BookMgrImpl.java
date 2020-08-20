package network2;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookMgrImpl implements IBookMgr {
	private List<Book> list;

	private BookMgrImpl() {
		// 리스트를 새로 만드는 게 아니라 파일로부터 읽어서 리스트를 복구!
		try {
			ObjectInputStream oi = new ObjectInputStream(new FileInputStream("book.dat"));
			list = (List<Book>) oi.readObject();
		} catch (Exception e) {
			list = new ArrayList<>();
		}
	}

	private static BookMgrImpl instance;

	public static synchronized BookMgrImpl getInstance() {
		if (instance == null)
			instance = new BookMgrImpl();
		return instance;
	}

	@Override
	public void add(Book b) {
		list.add(b);
		Scanner sc = new Scanner(System.in);
		try {
			ServerSocket serverSocket = new ServerSocket(3000);
			Socket socket = serverSocket.accept();
			while (true) {
				ObjectOutputStream bw = new ObjectOutputStream(socket.getOutputStream());
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String str = sc.next();
				if (!str.equals("종료")) {
					bw.writeObject(list);
					bw.flush(); // 비움 X 보내고 비움 O
				} else {
					System.out.println("Client에 의해서 종료");
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> list() {
		return new ArrayList<>(list);
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		// list를 순회하면서 isbn이 일치하는 책을 찾는다.
		Book target = null;
		for (Book b : list) {
			if (b.getIsbn().equals(isbn)) {
				target = b;
			}
		}
		// target가 null이라면 못찾은 것.

		// 못찾는다면 ISBNNotFoundException 발생.
		if (target == null)
			throw new ISBNNotFoundException(isbn);
		// 해당 책에 quantity가 부족하다면 QuantityException 발생.
		if (target.getQuantity() - quantity < 0)
			throw new QuantityException(quantity - target.getQuantity());
		// 문제 없다면 해당 책의 quantity를 차감
		target.setQuantity(target.getQuantity() - quantity);
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		// list를 순회하면서 isbn이 일치하는 책을 찾는다.
		Book target = null;
		for (Book b : list) {
			if (b.getIsbn().equals(isbn)) {
				target = b;
			}
		}
		// target가 null이라면 못찾은 것.

		// 못찾는다면 ISBNNotFoundException 발생.
		if (target == null)
			throw new ISBNNotFoundException(isbn);
		target.setQuantity(target.getQuantity() + quantity);
	}

	@Override
	public int getTotalAmount() {
		int amount = 0;
		for (Book b : list) {
			amount += (b.getPrice() * b.getQuantity());
		}
		return amount;
	}

	@Override
	public void save() {
		// 기록해야되는 내용이 많아서 파일 저장하는 데에 시간이 오래 걸릴것 같으면
		// 그동안 우리 프로그램은 먹통이 될 수 도 있으므로
		// 해당 작업은 스레드를 사용해서 동작하도록 합시다.
		
		// 스레드를 한번만 쓸거라  anonymous로 선언
		new Thread(new Runnable() {
			@Override
			public void run() {
				// book.dat에 멤버변수 list에 있는 책 정보를 저장하겠다
				// 입출력을 위한 예외처리 구조. 그리고 효율성을 위한 Buffered사용. 그리고 객체 형태의 입출력을 위한 ObjectOutput
				ObjectOutputStream bo = null;
				try {
					// bo = new ObjectOutputStream(new BufferedOutputStream(new
					// FileOutputStream("book.dat")));
					bo = new ObjectOutputStream(new FileOutputStream("book.dat"));
					bo.writeObject(list);
					bo.flush();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (bo != null) {
						try {
							bo.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}).start();

	}
}
