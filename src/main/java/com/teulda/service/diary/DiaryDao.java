package com.teulda.service.diary;

import java.util.List;

import com.teulda.common.Group;
import com.teulda.common.Photo;
import com.teulda.common.Search;
import com.teulda.service.domain.Diary;
import com.teulda.service.domain.HashTag;

//==> 기록관리에서 CRUD 추상화/캡슐화한 DAO Interface Definition
public interface DiaryDao {

	// INSERT
	public void addDiary(Diary diary) throws Exception;
	
	// INSERT
	public void addHashTag(HashTag hashTag) throws Exception;
	
	// INSERT
	public void addPhoto(Photo photo) throws Exception;

	// INSERT
	public void addDiaryGroup(Group group) throws Exception;

	// SELECT ONE
	public Diary getDiary(int diaryNo) throws Exception;
	
	// SELECT ONE (특정 기록의 북마크 추가 횟수)
	public int getBookmarkCount(int diaryNo) throws Exception;
	 
	// SELECT LIST
	public List<HashTag> getHashTagList(int diaryNo) throws Exception;
	
	// SELECT LIST
	public List<Photo> getPhotoList(int diaryNo) throws Exception;
	
	// SELECT LIST 
	public List<Group> getDiaryGroupList(String nickname) throws Exception;

	// SELECT LIST 
	public List<Diary> getMyDiaryList(Search search, String nickname, char isDelete) throws Exception;
	
	// 게시판 Page 처리를 위한 Row(totalCount) return 
	public int getMyDiaryCount(Search search, String nickname, char isDelete) throws Exception;
	
	// SELECT LIST
	public List<Diary> getDiaryList(Search search) throws Exception;
	
	// 게시판 Page 처리를 위한 Row(totalCount) return 
	public int getDiaryCount(Search search) throws Exception;

	// UPDATE (기록 수정)
	public void updateDiary(Diary diary) throws Exception;

	// UPDATE (기록 상태 수정 - 삭제/복원)
	public void updateDiaryStatus(Diary diary) throws Exception;

	// UPDATE (기록 그룹 수정 - 그룹 옮김)
	public void updateDiaryGroup(Diary diary) throws Exception;

	// UPDATE (기록 조회수 증가) 
	public void updateDiaryViewCount(int diaryNo) throws Exception;
	
	// UPDATE (스크랩 추가 할 시 스크랩 추가 횟수 증가)
	public void updateDiaryScrapCount(int diaryNo) throws Exception;
	
	// UPDATE (스크랩 추가 할 시 회원 계정에서 스크랩 추가 횟수 증가)
	public void updateUserScrapCount(String originNickname) throws Exception;

	// DELETE (기록 영구삭제)
	public void deleteDiary(int diaryNo) throws Exception;
	
	// DELETE (기록 영구삭제할때 기록번호로 포함된 해시태그 싹 다 찾아서 삭제)
	public void deleteHashTagUseDiaryNo(int diaryNo) throws Exception;
	
	// DELETE (기록 영구삭제할때 기록번호로 포함된 사진 싹 다 찾아서 삭제)
	public void deletePhotoUseDiaryNo(int diaryNo) throws Exception;
	
	// DELETE (해시태그 번호로 해시태그 삭제 - ajax로 바로 삭제)
	public void deleteHashTag(int hashTagNo) throws Exception;
	
	// DELETE (사진 번호로 사진 삭제 - ajax로 바로 삭제)
	public void deletePhoto(int photoNo) throws Exception;

}
