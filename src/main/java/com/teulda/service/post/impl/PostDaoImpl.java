package com.teulda.service.post.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.teulda.common.Photo;
import com.teulda.common.Search;
import com.teulda.service.domain.Comment;
import com.teulda.service.domain.Post;
import com.teulda.service.post.PostDao;

@Repository("postDaoImpl")
public class PostDaoImpl implements PostDao {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public PostDaoImpl() {
		System.out.println(this.getClass());
	}
	
	@Override
	public void addPost(Post post) throws Exception {
		sqlSession.insert("PostMapper.addPost", post);
		
	}

	@Override
	public Post getPost(int postNo) throws Exception {
		
		return sqlSession.selectOne("PostMapper.getPost",postNo);
	}

	@Override
	public void updatePost(Post post) throws Exception {
		
		sqlSession.update("PostMapper.updatePost", post);
		
	}

	@Override
	public void deletePost(int postNo) throws Exception {
		
		sqlSession.delete("PostMapper.deletePost", postNo);
		
	}

	@Override
	public List<Post> getPostList(Search search) throws Exception {
		
		return sqlSession.selectList("PostMapper.getPostList", search);
	}

	@Override
	public void addComment(Comment comment) throws Exception {
		
		sqlSession.insert("PostMapper.addComment", comment);
		
	}

	@Override
	public void updateComment(Comment comment) throws Exception {
		
		sqlSession.update("PostMapper.updateComment", comment);
	}

	@Override
	public void deleteComment(int commentNo) throws Exception {
		
		sqlSession.delete("PostMapper.deleteComment", commentNo);
		
	}

	@Override
	public List<Comment> getMycommentList(Search search, String nickname) throws Exception {
		
		return sqlSession.selectList("PostMapper.getCommentList", search);
	}

	@Override
	public int getPostTotalCount(Search search) throws Exception {
		
		return sqlSession.selectOne("PostMapper.getPostTotalCount", search);
	}

	@Override
	public int getCommentTotalCount(Search search) throws Exception {
		
		return sqlSession.selectOne("PostMapper.getCommentTotalCount", search);
	}

	@Override
	public void addPhoto(Photo photo) throws Exception {
		
		sqlSession.insert("PhotoMapper.addPhoto", photo);
		
	}

	@Override
	public List<Comment> getCommentList(int postNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Photo> getPhotoList(int postNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
