package manager;

import java.util.List;

public class MemberService {
	
	private MemberDao memberDao;  // memberDao를 가지고 있어야 함
	
	public MemberService(MemberDao memberDao) {  // 생성자 생성
		this.memberDao = memberDao;  // this에 memberDao를 담아준다.
	}
	
	// 등록하기
	public boolean regist(MemberVo vo) {
		if(memberDao.selectMember(vo.getNum()) == null) {  // 로직 처리 memberDao에서 selectMember을 한다 vo의 getNum을 가지고  = null일때 -> 동일한 회원이 없다.
			memberDao.insertMember(vo);  // 동일한 회원이 없을 시 insertMember을 통해서 등록해준다.
			return true;
		} else {
			return false;
		}
	}
	
	// 조회
	public MemberVo read(int num) {
		return memberDao.selectMember(num);
	}
	
	// 전체조회 
	public List<MemberVo> listAll() {
		return memberDao.selectMemberAll();
	}
	
	// 수정
	public void edit(MemberVo vo) {
		MemberVo searchMember= memberDao.selectMember(vo.getNum()); 
		
		if(searchMember.getMemberPw().equals(vo.getMemberPw())) {  
			memberDao.updateMember(vo);
		}
	}
	
	// 탈퇴
	public void remove(int num) {
		memberDao.deleteMember(num);
	}
	

}





