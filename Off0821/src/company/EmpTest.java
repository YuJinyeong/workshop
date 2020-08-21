package company;
import java.util.ArrayList;
import java.util.List;

public class EmpTest {
	public static void main(String[] args) {
		EmpMgr em = EmpMgr.getInstance();
		List<Employee> list = new ArrayList<>();

		// 직원정보 DB에 저장
		em.add(new Employee(12, "aaa", "A", "4"));
		em.add(new Employee(34, "bbb", "A", "5"));
		em.add(new Employee(56, "ccc", "B", "2"));
		em.add(new Employee(78, "ddd", "B", "2"));
		em.add(new Employee(78, "fff", "C", "1"));
		em.add(new Employee(89, "fff", "C", "3"));

		// 저장된 모든 직원 정보
		printList(em.search());

		// 사번으로 직원 검색
		list = em.search(78);
		if (list != null)
			printList(list);
		else
			System.out.println("해당하는 사번의 직원을 찾을 수 없습니다.");

		// 사번으로 직원 검색 - 해당하는 사번의 직원이 없을 때
		list = em.search(01);
		if (list != null)
			printList(list);
		else
			System.out.println("해당하는 사번의 직원을 찾을 수 없습니다.");

		// 이름으로 직원 검색
		list = em.search("fff");
		if (list != null)
			printList(list);
		else
			System.out.println("해당하는 사번의 직원을 찾을 수 없습니다.");

		// 이름으로 직원 검색 - 해당하는 사번의 직원이 없을 때
		list = em.search("eee");
		if (list != null) {
			printList(list);
			printList(em.search());
		}
		else
			System.out.println("해당하는 사번의 직원을 찾을 수 없습니다.");

		// 사번으로 부서 수정
		if (em.update(12, "D") == true) {
			System.out.println("해당하는 사번의 직원을 찾아 부서를 수정했습니다.");
			printList(em.search());
		} else {
			System.out.println("수정에 실패했습니다.");
		}

		// 사번으로 부서 수정 - 실패
		if (em.update(11, "D") == true) {
			System.out.println("해당하는 사번의 직원을 찾아 부서를 수정했습니다.");
			printList(em.search());
		} else {
			System.out.println("수정에 실패했습니다.");
		}

		// 사번으로 직원 데이터 삭제
		if (em.delete(89) == true) {
			System.out.println("해당하는 사번의 직원을 찾아 데이터를 삭제했습니다.");
			printList(em.search());
		} else {
			System.out.println("삭제에 실패했습니다.");
		}

		// 사번으로 직원 데이터 삭제 - 실패
		if (em.delete(00) == true) {
			System.out.println("해당하는 사번의 직원을 찾아 데이터를 삭제했습니다.");
			printList(em.search());
		} else {
			System.out.println("삭제에 실패했습니다.");
		}

	}

	private static void printList(List<Employee> search) {
		System.out.println("==================== Employee List ====================");
		for (Employee e : search) {
			System.out.println(e.toString());
		}
	}
}

