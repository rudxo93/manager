package manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {
	
	public static void main(String[] args) {
		
		MemberDao memberDao = new MemberDao();  // DAO로 조작을 하면 데이터베이스에 반영이 된다 *객체지향 개념
		
		// C (insert)  // HashMap을 대상으로 작업
		MemberVo vo1 = new MemberVo(1, "test1", "1234", "nick1");  // 회원번호, 아이디, 비밀번호, 닉네임 생성
		vo1.setRegdate(new Date());  // 각각에 날짜 저장
		MemberVo vo2 = new MemberVo(2, "test2", "1234", "nick2");
		vo2.setRegdate(new Date());
		MemberVo vo3 = new MemberVo(3, "test3", "1234", "nick3");
		vo3.setRegdate(new Date());
		
		memberDao.insertMenber(vo1);  // 데이터베이스에 넣어주기
		memberDao.insertMenber(vo2); 
		memberDao.insertMenber(vo3); 
		
		System.out.println("저장 완료!");
		
		// R (select)
		List<MemberVo> ls = memberDao.selectMemberAll(); // 전체 조회  values()은 collection을 반환함 -> collection을 이용해서 ArrayList 생성
		for (MemberVo tmp : ls) {  // 임시 변수 tmp에 ls에 들어있는 만큼 반복
			System.out.println(tmp);  // toString값이 나온다.
		}
		System.out.println("전체조회 완료!");
		
		// 하나의 데이터만 조회
		MemberVo vo = null;
		vo = memberDao.selectMember(1);  // 1번 회원 조회
		System.out.println(vo);
		
		vo = memberDao.selectMember(4);  // 4번 회원 조회
		System.out.println(vo);  // null
		System.out.println("조회 완료!");
		
		// U (update)
		vo = memberDao.selectMember(1);  // 1번 회원 조회
		System.out.println(vo);
		
		if(vo != null) {  // vo가 null이 아니다 => 검색
			vo.setMemberPw("4321");  // 비밀번호 변경
			vo.setNickName("1nick");  // 닉네임 변경
			memberDao.updateMember(vo);  // 변경값 올리기(현재 vo의 번호에, vo가 들어감)
		}
		
		vo = memberDao.selectMember(1);  //  업데이트한 1번 회원 조회
		System.out.println(vo);
		System.out.println("수정 완료!");
		
		// D (delete)
		memberDao.deleteMember(2);  // 2번 회원 삭제
		ls = memberDao.selectMemberAll();
		for (MemberVo tmp : ls) { 
			System.out.println(tmp); 
		}
		System.out.println("전체조회 완료!");
		
		// 전체 삭제
		memberDao.deleteMemberAll();
		ls = memberDao.selectMemberAll();
		for (MemberVo tmp : ls) { 
			System.out.println(tmp); 
		}
		System.out.println("전체조회 완료!");
		
	}

}
