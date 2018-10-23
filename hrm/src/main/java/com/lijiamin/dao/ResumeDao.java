package com.lijiamin.dao;

import com.lijiamin.model.Resume;

import java.util.List;

/**
 * Created by 31543 on 2018/10/20.
 */
public interface ResumeDao {
    Integer insertResume(Resume Resume);    //添简历
    Integer deleteResume(Resume Resume);    //删简历
    Integer updateResume(Resume Resume);    //改简历
    Resume queryResumeByResume_id(Integer resume_id);   //据简历id查简历
    List<Resume> queryResumeByResume_user_id(Integer resume_user_id);   //据用户id查简历集合
}
