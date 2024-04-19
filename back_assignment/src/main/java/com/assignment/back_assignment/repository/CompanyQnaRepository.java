package com.assignment.back_assignment.repository;

import com.assignment.back_assignment.entity.CompanyQna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyQnaRepository extends JpaRepository<CompanyQna, Long> {
    // 묻고답하기 검색 기능
//    List<CompanyQna> findByQnaTitleContaining(String searchText);
//    List<CompanyQna> findByQnaContentContaining(String searchText);
//    List<CompanyQna> findByQnaNameContaining(String searchText);

    //  묻고답하기 검색 기능- 쿼리로 작성해보기
    @Query("SELECT qna FROM CompanyQna qna WHERE qna.qnaTitle LIKE %:searchText%")
    List<CompanyQna> findByQnaTitleContaining(@Param("searchText") String searchText);

    @Query("SELECT qna FROM CompanyQna qna WHERE qna.qnaContent LIKE %:searchText%")
    List<CompanyQna> findByQnaContentContaining(@Param("searchText") String searchText);

    @Query("SELECT qna FROM CompanyQna qna WHERE qna.qnaName LIKE %:searchText")
    List<CompanyQna> findByQnaNameContaining(@Param("searchText") String searchText);
}
