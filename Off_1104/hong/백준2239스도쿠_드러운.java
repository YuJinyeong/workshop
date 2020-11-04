package hong;
import java.util.Scanner;

//0���� 80��������... 0���� 8�� 1�� 9���� 17�� 2��.. �̷������� �ε����� �����մϴ�.
public class ����2239������_�巯�� {
	static StringBuilder sb = new StringBuilder();
//	static PriorityQueue<String> pq = new PriorityQueue<String>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 9; i++)
			sb.append(sc.next());
		dfs(sb.toString().toCharArray());
		for(int i = 0; i < 81; i += 9) {
			System.out.println(ans.substring(i, i+9));
		}
	}
	static String ans = null;
	static void dfs(char[] s) {
		//�̹� ���� ã������ �׸�.
		if(ans != null)
			return;
		//ó������ 0�� �ƴ� �ε����� ã���ϴ�.
		int idx = -1;
		for(int i = 0; i < 81; i++) {
			if(s[i] == '0') {
				idx = i;
				break;
			}
		}
		//0�ΰ��� �ȳ������� �����Դϴ�.
		if(idx == -1) {
			ans = new String(s);
			return;
		}
		//ó�� 0�� ���۵Ǵ� ��ġ�� ���� ���° ������
		int rowStart = idx / 9;
		//���° ������	
		int colStart = idx % 9;
		//�� �࿭ ��ġ�� ���簢�ڽ��� ������� �����.
		int boxStart = rowStart / 3 * 3 * 9+ colStart / 3 * 3;
		//���������� �־�ϴ� 1~9
		for(int i = 1; i < 10; i++) {
			//���� ���� �ڽ��� �˻��ؼ�
			if(check(s, (char)(i + 48), rowStart, colStart, boxStart)) {
				//������ ì���
				char tmp = s[idx];
				//ã�� �� �ְ�
				s[idx] = (char) (i + 48);
				//���� ����
				dfs(s);
				//����
				s[idx] = tmp;
			}
		}
	}
	static boolean check(char[] s,char val, int rS, int cS, int bS) {
		//9���� ���ؤä�
		for(int i = 0; i < 9; i++) {
			//���� �ִ� �࿡ ���� �� �ִ���
			if(s[rS*9+i] == val) 
				return false;
			//���� ���� �� �ִ���
			if(s[cS+9*i] == val)
				return false;
		}
		//�ڽ� �˻�.
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(s[bS + 9*i + j] == val)
					return false;
			}
		}
		return true;
	}
}